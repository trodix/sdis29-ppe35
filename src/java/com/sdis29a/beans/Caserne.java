/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.beans;

/**
 *
 * @author Dominique_2
 */
public class Caserne {
    private int cId;
    private String cNom;
    private String cAdresse;
    private String cTel;

    /**
     * @return the cId
     */
    public int getcId() {
        return cId;
    }

    /**
     * @param cId the cId to set
     */
    public void setcId(int cId) {
        this.cId = cId;
    }

    /**
     * @return the cNom
     */
    public String getcNom() {
        return cNom;
    }

    /**
     * @param cNom the cNom to set
     */
    public void setcNom(String cNom) {
        this.cNom = cNom;
    }

    /**
     * @return the cAdresse
     */
    public String getcAdresse() {
        return cAdresse;
    }

    /**
     * @param cAdresse the cAdresse to set
     */
    public void setcAdresse(String cAdresse) {
        this.cAdresse = cAdresse;
    }

    /**
     * @return the cTel
     */
    public String getcTel() {
        return cTel;
    }

    /**
     * @param cTel the cTel to set
     */
    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public Caserne(int cId, String cNom, String cAdresse, String cTel) {
        this.cId = cId;
        this.cNom = cNom;
        this.cAdresse = cAdresse;
        this.cTel = cTel;
    }
    
    
}
