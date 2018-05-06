/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.forms;

import com.sdis29a.bdd.PompierMySQL;
import com.sdis29a.beans.Pompier;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Dominique_2
 */
public class MajPompierForms {
    /**
     * Préparation de la mise à jour
     * @param request       : request après submit du formulaire  
     * @param lePompierA    : le pompier authentifié
     * @return 
     */
    public Pompier majPompier(HttpServletRequest request, Pompier lePompierA) {
        Pompier lePompierMaj = null;
        PompierMySQL pompierMySQL = new PompierMySQL();
        
        // Zones saisies
        HashMap<String, Object> lesParametres = new HashMap();
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            Object value = request.getParameter(name);
            lesParametres.put(name, value);
        }
        // Zones implicites
        int idC = lePompierA.getLaCaserne().getcId();
        lesParametres.put("idC", idC);    // Caserne
        String ztMdp = MD5.encode((String)lesParametres.get("ztLogin"));
        lesParametres.put("ztMdp", ztMdp); // Mot de passe défini à partir du login        
        /* Pb pour les zones numériques : 
                elles doivent être mémorisées dans le dictionnaire en entier, pour
                une lecture par la suite */
        int zhIdP = Integer.parseInt(request.getParameter("zhIdP"));
        lesParametres.put("zhIdP", zhIdP);  // No du pompier dans la caserne
        
        if (request.getParameter("btLesPompiers")!=null) {
            int ldrGrade = Integer.parseInt(request.getParameter("ldrGrade"));
            lesParametres.put("ldrGrade", ldrGrade); 
            if (Integer.parseInt(request.getParameter("zhAction"))==1) {
                System.out.println("Modif un pompier volontaire");                
                lePompierMaj = pompierMySQL.update(lesParametres);
            } else { // Cas de l'ajout
                System.out.println("Ajout d'un pompier volontaire");               
                int idP = pompierMySQL.getIdMax(idC);
                lesParametres.put("zhIdP", idP+1); // No du pompier dans la caserne
                lesParametres.put("idType", 2);   // Pompier volontaire
                lesParametres.put("idStatut", 1); // Pompier
                
                lePompierMaj = pompierMySQL.create(lesParametres);
            }
        } else {            
            System.out.println("Modif monProfil");
            // Recherche du grade et du bip (non transmis par le formulaire)
            int idGrade = lePompierA.getpGrade();
            lesParametres.put("ldrGrade", idGrade);  
            String bip = (String) lePompierA.getpBip();
            lesParametres.put("ztBip", bip);
            
            lePompierMaj = pompierMySQL.update(lesParametres);            
        }         
        return lePompierMaj;
    }
    
}
