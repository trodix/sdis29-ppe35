/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.forms;

import com.sdis29a.bdd.ParamMySQL;
import com.sdis29a.bdd.PompierMySQL;
import com.sdis29a.beans.Parametre;
import com.sdis29a.beans.Pompier;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Dominique_2
 */
public class AuthentifForms {
    
    public boolean verifAuthentif(HttpServletRequest request) {
        boolean trouve = false;
        String login = request.getParameter("ztLogin");
        String mdp = MD5.encode(request.getParameter("ztMDP"));
        PompierMySQL pompierMySQL = new PompierMySQL();
        Pompier lePompier = pompierMySQL.readAuthentif(login, mdp);
        if (lePompier!= null) {
            trouve = true;
            HttpSession maSession = request.getSession();
            maSession.setAttribute("lePompier", lePompier);
            ParamMySQL paramMySQL = new ParamMySQL();
            ArrayList <Parametre> lesGrades = paramMySQL.readType("grade");
            maSession.setAttribute("lesGrades", lesGrades);
        }
        System.out.println("Trouve: " + trouve);
        return trouve;
    }
    
}
