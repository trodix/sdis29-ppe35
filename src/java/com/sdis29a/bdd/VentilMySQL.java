/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.bdd;


import com.sdis29a.util.TrmtDate;
import com.sdis29a.beans.Caserne;
import com.sdis29a.beans.Pompier;
import com.sdis29a.beans.Ventil;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * 
 * @author Dominique_2
 */
public class VentilMySQL {
    
    private final Connection laConnection  = Connexion.getConnect("Localhost", 
                                                                "bdpersonnel", 
                                                                "adminBDPers", 
                                                                "mdpBDPers");
    
    /**
     * Retoune la collection de ventilations pour la période entre les dates extrêmes du tableau de dates
     * @param lesDates : tableau de Calendar
     * @param lesPeriodes : tableau d'entiers représentant les codes des périodes
     * @return 
     */
    public ArrayList<Ventil> getLesVentil(Calendar[]lesDates, int[]lesPeriodes, ArrayList<Pompier> lesPompiers) {
        ArrayList<Ventil> lesVentil = new ArrayList();
        /* 1. initialisation de la collection lesVentil pour la période,
              création d'une ventil par pompier, date et période */
        int indiceDateFin = lesDates.length - 1;
        System.out.println("Début getLesVentil, dd: "+lesDates[0].getTime()+" - df: "+ lesDates[indiceDateFin].getTime());
        Ventil uneVentil;
        Pompier lePompier;
        PompierMySQL pMySQL = new PompierMySQL();
        CaserneMySQL cMySQL = new CaserneMySQL();
        
        int idCaserne = 0;
        if (lesPompiers.size()>0) {
            idCaserne = lesPompiers.get(0).getLaCaserne().getcId();
        }
        
        int idUnPompier = 0;
        if (lesPompiers.size()==1) {
            idUnPompier = lesPompiers.get(0).getpId();
        }
        //ArrayList<Pompier> lesPompiers = pMySQL.readAll();
        for (Pompier unPompier:lesPompiers) {
            for (Calendar dateTraitee:lesDates) {
                for (int unePeriode:lesPeriodes) {
                    uneVentil = new Ventil(dateTraitee, unePeriode, unPompier,0, false);
                    lesVentil.add(uneVentil);                    
                }                
            }
        }   
        // 2. Maj de la collection en fonction de la table ventilation
        try {
            PreparedStatement stmt = null;
            String selPompier = idUnPompier == 0 ? "" : "AND pid = ?";
            String sql = "SELECT * FROM pompier "
                    + "INNER JOIN ventilation on pCis = vCis AND pid = vPompier "
                    + "WHERE vDate BETWEEN ? AND ? "
                    + "AND pCis = ? "+ selPompier +";";                    
            stmt = laConnection.prepareStatement(sql); 
            stmt.setDate(1, TrmtDate.getSQLDate(lesDates[0])); 
            stmt.setDate(2, TrmtDate.getSQLDate(lesDates[indiceDateFin]));  
            stmt.setInt(3,idCaserne);
            if (idUnPompier != 0) {
                stmt.setInt(4,idUnPompier);
            }
            ResultSet resultat = stmt.executeQuery();
            //System.out.println("Requete : " + stmt.toString());            
            while (resultat.next()) {
                Caserne uneCaserne = cMySQL.read(resultat.getInt("pCis"));
                lePompier = new Pompier(    uneCaserne,
                                            resultat.getInt("pId"), 
                                            resultat.getString("pNom"), 
                                            resultat.getString("pPrenom"));
                                            
                uneVentil = new Ventil(TrmtDate.getCalDate(resultat.getDate("vDate")), 
                                        resultat.getInt("vTranche"), lePompier, 0, false);
                //Recherche de uneVentil dans lesVentil afin de la mettre à jour
                int indice = lesVentil.indexOf(uneVentil);
                if (indice > -1 ) {
                    uneVentil = lesVentil.get(indice);
                } 
                uneVentil.setActivite(resultat.getInt("vDispo"));
                uneVentil.setIsDeGarde(resultat.getBoolean("vGarde"));
                uneVentil.setIsInBdd(true);
                if (indice==-1) {
                    lesVentil.add(uneVentil);
                    System.out.println("Ventil non trouvée dans lesVentils " + uneVentil); 
                }
            }            
            stmt.close();  
            resultat.close();
        } catch(SQLException ex){
            System.out.println("SQLExecption : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("CodeErreur : " + ex.getErrorCode());
        }  
             
        return lesVentil;
    }
    /**
     * 
     * @param uneVentil
     * @param act
     * @param garde
     * @param typMaj type de mise à jour : d : dispo, g garde
     */
    public void update(Ventil uneVentil, int act, boolean garde, char typMaj) {
        System.out.println("uneVentil à maj : "+ uneVentil+" - act : "+ act);
        try {           
            PreparedStatement stmt;
            String maj = typMaj=='d'? "vDispo = ?":"vGarde = ?";
            String sql = "UPDATE ventilation SET "+ maj + " WHERE "
                    + "vDate=? AND vTranche=? AND vCis=? AND vPompier=?";
            stmt = laConnection.prepareStatement(sql);
            stmt.setDate(2, TrmtDate.getSQLDate(uneVentil.getJourVentil()));
            stmt.setInt(3, uneVentil.getPeriode());
            stmt.setInt(4, uneVentil.getPompier().getLaCaserne().getcId());
            stmt.setInt(5, uneVentil.getPompier().getpId());
            if (typMaj=='d') {
                stmt.setInt(1, act);
            } else {
                stmt.setBoolean(1, garde);
            }
            stmt.setInt(1, act);
            // System.out.println("Requete : " + stmt.toString());
            int statut = stmt.executeUpdate();            
            if (statut <= 0) {
                System.out.println("Pb lors de la maj dans ventilation");
                System.out.println("Requete : " + stmt.toString());
            }
            stmt.close();  
        } catch(SQLException ex){
            System.out.println("SQLExecption : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("CodeErreur : " + ex.getErrorCode());
        }
        
    }
    public void create(Ventil uneVentil, int act) {
        System.out.println("uneVentil à créer : "+ uneVentil+" - act : "+ act);
        try {           
            PreparedStatement stmt;
            String sql = "INSERT INTO ventilation VALUES (?,?,?,?,?,?);";
            stmt = laConnection.prepareStatement(sql);
            stmt.setInt(1, uneVentil.getPompier().getLaCaserne().getcId());
            stmt.setInt(2, uneVentil.getPompier().getpId());            
            stmt.setDate(3, TrmtDate.getSQLDate(uneVentil.getJourVentil()));
            stmt.setInt(4, uneVentil.getPeriode());
            stmt.setInt(5, act);
            stmt.setBoolean(6, false);
            // System.out.println("Requete : " + stmt.toString());
            int statut = stmt.executeUpdate();            
            if (statut <= 0) {
                System.out.println("Pas d'insertion dans ventilation");
                System.out.println("Requete : " + stmt.toString());
            }
            stmt.close();  
        } catch(SQLException ex){
            System.out.println("SQLExecption : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("CodeErreur : " + ex.getErrorCode());
        }
    }
    public void delete(Ventil uneVentil) {
        System.out.println("uneVentil à supprimer : "+ uneVentil);
        try {           
            PreparedStatement stmt;
            String sql = "DELETE FROM ventilation WHERE "
                    + "vDate=? AND vTranche=? AND vCis=? AND vPompier=?";
            stmt = laConnection.prepareStatement(sql);
            stmt.setDate(1, TrmtDate.getSQLDate(uneVentil.getJourVentil()));
            stmt.setInt(2, uneVentil.getPeriode());
            stmt.setInt(3, uneVentil.getPompier().getpId());
            stmt.setInt(4, uneVentil.getPompier().getLaCaserne().getcId());
            // System.out.println("Requete : " + stmt.toString());
            int statut = stmt.executeUpdate();            
            if (statut <= 0) {
                System.out.println("Suppression non effectuée");
                System.out.println("Requete : " + stmt.toString());
            }
            stmt.close();  
        } catch(SQLException ex){
            System.out.println("SQLExecption : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("CodeErreur : " + ex.getErrorCode());
        }
    }
}
