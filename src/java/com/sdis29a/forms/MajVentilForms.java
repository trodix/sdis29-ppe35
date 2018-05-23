/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.forms;

import com.sdis29a.bdd.VentilMySQL;
import com.sdis29a.beans.Ventil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dominique_2
 */
public class MajVentilForms {
    public void MajVentil(HttpServletRequest request) {
        HttpSession maSession = request.getSession();
        ArrayList<Ventil> lesVentil = (ArrayList<Ventil>) maSession.getAttribute("lesVentilInit");
        System.out.println("**********MajVentilForms*************");
        // Récupération des saisies effectuées
        Map<String, String[]> map = request.getParameterMap();
        String[] lesNvVentil = (map.get("tabVentil"));
        
        String[] lesGardes = request.getParameterValues("cbGarde");  
        ArrayList<Integer> listGardes= new ArrayList(); 
        if (lesGardes != null) {
            for (String uneGarde:lesGardes) {
                listGardes.add(Integer.parseInt(uneGarde));
            }
        }
        System.out.println("lesGardes:"+Arrays.toString(lesGardes));
        
        // Analyse des saisies, si modification, maj bdd
        int activite;
        int i = 0;
        VentilMySQL ventilM = new VentilMySQL();
        for(Ventil uneVentil:lesVentil) {
            activite = Integer.parseInt(lesNvVentil[i]);
            if (activite != uneVentil.getActivite() ) {
                if (uneVentil.isIsInBdd()){
                    if (activite == 0) { // activité par defaut
                        ventilM.delete(uneVentil);
                    } else {
                        ventilM.update(uneVentil, activite, false, 'd');
                    }
                } else {
                    ventilM.create(uneVentil, activite);
                }
            }
            // Maj des gardes
            boolean nvGarde = listGardes.indexOf(i)<0?false:true;
            if (nvGarde != uneVentil.isIsDeGarde()) {
                ventilM.update(uneVentil, -1, nvGarde, 'g');
            }

            i++;
        }        
    }
}
