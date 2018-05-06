/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.bdd;


import com.sdis29a.beans.Caserne;
import com.sdis29a.beans.Parametre;
import com.sdis29a.beans.Pompier;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dominique_2
 */
public class PompierMySQL {
    private final Connection laConnection  = Connexion.getConnect("Localhost", 
                                                                "sdis29", 
                                                                "adminBDsdis", 
                                                                "mdpBDsdis");    


    public Pompier readAuthentif(String login, String mdp) {
        Pompier lePompier = null;
        try {
            PreparedStatement prepStmt = null;
            String sql = "SELECT * FROM pompier WHERE pLogin=? AND pMdp=? ";
                   
            prepStmt = laConnection.prepareStatement(sql);
            prepStmt.setString(1, login);
            prepStmt.setString(2, mdp);
            ResultSet result = prepStmt.executeQuery();
            if (result.first()) {
                CaserneMySQL laCaserneMySQL = new CaserneMySQL();
                Caserne laCaserne = laCaserneMySQL.read(result.getInt(1));
                lePompier = constituerLePompier(result, laCaserne);
            }
            prepStmt.close();
        } catch (SQLException ex) {
                System.out.println("SQLExeption : " + ex.getMessage());
                System.out.println("SQLState : " + ex.getSQLState());
                System.out.println("Code erreur : " + ex.getErrorCode());
        }        
        return lePompier;
    }
    /**
     * Rechercher des pompiers volontaires de la caserne
     * @param idCaserne
     * @return 
     */
    public ArrayList<Pompier> readLesPompiersCaserne(int idCaserne) {
        ArrayList<Pompier> lesPompiers = new ArrayList();
        try {
        PreparedStatement prepStmt = null;
        String sql = "SELECT * FROM pompier WHERE pCis=? AND pStatut=1 AND pType=2 ORDER BY pNom, pPrenom";
                   
        prepStmt = laConnection.prepareStatement(sql);
        prepStmt.setInt(1, idCaserne);            
        ResultSet result = prepStmt.executeQuery();
        CaserneMySQL laCaserneMySQL = new CaserneMySQL();
        Caserne laCaserne = laCaserneMySQL.read(idCaserne);
        while (result.next()) {
            Pompier unPompier = constituerLePompier(result, laCaserne);
            lesPompiers.add(unPompier);
        }        
        prepStmt.close();
        } catch (SQLException ex) {
                System.out.println("SQLExeption : " + ex.getMessage());
                System.out.println("SQLState : " + ex.getSQLState());
                System.out.println("Code erreur : " + ex.getErrorCode());
        }  
        return lesPompiers;
    }
    
    public Pompier constituerLePompier(ResultSet result, Caserne laCaserne){
        Pompier lePompier = null;
        ParamMySQL leParamMySQL = new ParamMySQL();
        try {
            Parametre leStatut = leParamMySQL.read("statAgt", result.getInt(5));
            Parametre leType = leParamMySQL.read("typePer", result.getInt(6));
            lePompier = new Pompier(laCaserne, result.getInt(2),
                    result.getString(3), result.getString(4),
                    leStatut, leType,
                    result.getString(7), result.getString(8),
                    result.getString(9), result.getString(10),
                    result.getString(11), result.getString(12),
                    result.getString(13), result.getInt(15), result.getString(16));            
        } catch (SQLException ex) {
            Logger.getLogger(PompierMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lePompier;
    }
    /**
     * Recherche du dernier no de pompier utilisé pour une caserne
     * @param idC : caserne concernée
     * @return dernier no de pompier utilisé dansla caserne
     */
    public int getIdMax(int idC) {
        int max = 0;
        try {
            PreparedStatement prepStmt = null;
            String sql = "SELECT max(pId) FROM pompier WHERE pCis = ?";                   
            prepStmt = laConnection.prepareStatement(sql);
            prepStmt.setInt(1, idC);
            ResultSet result = prepStmt.executeQuery();
            if (result.first()) {
                max = result.getInt(1);              
            }
            prepStmt.close();
        } catch (SQLException ex) {
                System.out.println("SQLExeption : " + ex.getMessage());
                System.out.println("SQLState : " + ex.getSQLState());
                System.out.println("Code erreur : " + ex.getErrorCode());
        }
        return max;
    }
    public Pompier update(HashMap<String, Object> lesParametres) {       
//        Date dateJ = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dateDuJour = dateFormat.format(dateJ);
        String sql = "UPDATE pompier "
            + "SET pNom = ?, pPrenom = ?, pMail = ?, "
            + "pLogin = ?, pMdp = ?, pAdresse = ?, pCp = ?, pVille = ?, "
            + "pBip = ?, pGrade = ?, pCommentaire = ?, pDateModif = ? "                    
            + "WHERE pCis=? AND pId=?; ";                   
         return requeteMaj(sql, lesParametres);         
    }
    
    public Pompier create(HashMap<String, Object> lesParametres) {  
        String sql = "INSERT into pompier "
            + "(pNom, pPrenom, pMail, pLogin, pMdp, pAdresse, pCp, pVille, "
            + "pBip, pGrade, pCommentaire, pDateEnreg, pCis, pId, pStatut, pType) "                    
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";                    
        return requeteMaj(sql, lesParametres);        
    }
    
    private Pompier requeteMaj(String sql, HashMap<String, Object> lesParametres) {
        int nbLigne = 0;
        try {
            PreparedStatement prepStmt = null;
            prepStmt = laConnection.prepareStatement(sql);
            prepStmt.setString(1, (String)lesParametres.get("ztNom"));
            prepStmt.setString(2, (String)lesParametres.get("ztPrenom"));            
            prepStmt.setString(3, (String)lesParametres.get("ztMail"));
            prepStmt.setString(4, (String)lesParametres.get("ztLogin"));
            prepStmt.setString(5, (String)lesParametres.get("ztMdp"));
            prepStmt.setString(6, (String)lesParametres.get("ztAdresse"));
            prepStmt.setString(7, (String)lesParametres.get("ztCP"));
            prepStmt.setString(8, (String)lesParametres.get("ztVille"));
            prepStmt.setString(9, (String)lesParametres.get("ztBip")); 
            prepStmt.setInt(10, (Integer)lesParametres.get("ldrGrade"));
            prepStmt.setString(11, (String)lesParametres.get("taObs"));
            prepStmt.setDate(12, java.sql.Date.valueOf(java.time.LocalDate.now()));
            prepStmt.setInt(13, (Integer)lesParametres.get("idC"));
            prepStmt.setInt(14, (Integer)lesParametres.get("zhIdP"));
            if (sql.substring(0,6).equals("INSERT")) {
                prepStmt.setInt(15, (Integer)lesParametres.get("idStatut"));
                prepStmt.setInt(16, (Integer)lesParametres.get("idType"));
            }
            
            System.out.println(prepStmt);
            nbLigne = prepStmt.executeUpdate();            
            prepStmt.close();
        } catch (SQLException ex) {
                System.out.println("SQLExeption : " + ex.getMessage());
                System.out.println("SQLState : " + ex.getSQLState());
                System.out.println("Code erreur : " + ex.getErrorCode());
        } 
        Pompier lePompierMaj = null;
        if (nbLigne > 0) {
            lePompierMaj = read((Integer)lesParametres.get("idC"), (Integer)lesParametres.get("zhIdP"));
        }        
        return lePompierMaj;
    }
    
    public Pompier read(int idC, int idP) {
        Pompier unPompier = null;
        try {
            PreparedStatement prepStmt = null;
            String sql = "SELECT * FROM pompier WHERE pCis=? AND pId=? ";
                   
            prepStmt = laConnection.prepareStatement(sql);
            prepStmt.setInt(1, idC);
            prepStmt.setInt(2, idP);
            ResultSet result = prepStmt.executeQuery();
            if (result.first()) {
                CaserneMySQL laCaserneMySQL = new CaserneMySQL();
                Caserne laCaserne = laCaserneMySQL.read(result.getInt(1));
                unPompier = constituerLePompier(result, laCaserne);
            }
            prepStmt.close();
        } catch (SQLException ex) {
                System.out.println("SQLExeption : " + ex.getMessage());
                System.out.println("SQLState : " + ex.getSQLState());
                System.out.println("Code erreur : " + ex.getErrorCode());
        } 
        return unPompier;
    }    
}
