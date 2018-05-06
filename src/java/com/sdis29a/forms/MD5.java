/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.forms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Dominique_2
 */
public abstract class  MD5 {
    
    public static String encode(String uneChaine){
        MessageDigest md = null;
        String myHash = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AuthentifForms.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(uneChaine.getBytes());
        byte[] digest = md.digest();
        myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();

        return myHash;
    }
    
}
