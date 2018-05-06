/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.beans;
 
import java.util.Objects;

/**
 *
 * @author Dominique_2
 */
public class Pompier {
    private Caserne laCaserne;
    private int pId;
    private String pNom;
    private String pPrenom;
    private Parametre leStatut;
    private Parametre leType;
    private String pMail;
    private String pLogin;
    private String pMdp;
    private String pAdresse;
    private String pCp;
    private String pVille;
    private String pBip;
    private int pGrade;
    private String pCommentaire;

    public Caserne getLaCaserne() {
        return laCaserne;
    }

    public void setLaCaserne(Caserne laCaserne) {
        this.laCaserne = laCaserne;
    }

    public Pompier(Caserne laCaserne, int pId, String pNom, String pPrenom, Parametre leStatut, Parametre leType, String pMail, String pLogin, String pMdp, String pAdresse, String pCp, String pVille, String pBip, int pGrade, String pCommentaire) {
        this.laCaserne = laCaserne;
        this.pId = pId;
        this.pNom = pNom;
        this.pPrenom = pPrenom;
        this.leStatut = leStatut;
        this.leType = leType;
        this.pMail = pMail;
        this.pLogin = pLogin;
        this.pMdp = pMdp;
        this.pAdresse = pAdresse;
        this.pCp = pCp;
        this.pVille = pVille;
        this.pBip = pBip;
        this.pGrade = pGrade;
        this.pCommentaire = pCommentaire;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.laCaserne);
        hash = 41 * hash + this.pId;
        hash = 41 * hash + Objects.hashCode(this.pNom);
        hash = 41 * hash + Objects.hashCode(this.pPrenom);
        hash = 41 * hash + Objects.hashCode(this.leStatut);
        hash = 41 * hash + Objects.hashCode(this.leType);
        hash = 41 * hash + Objects.hashCode(this.pMail);
        hash = 41 * hash + Objects.hashCode(this.pLogin);
        hash = 41 * hash + Objects.hashCode(this.pMdp);
        hash = 41 * hash + Objects.hashCode(this.pAdresse);
        hash = 41 * hash + Objects.hashCode(this.pCp);
        hash = 41 * hash + Objects.hashCode(this.pVille);
        hash = 41 * hash + Objects.hashCode(this.pBip);
        hash = 41 * hash + this.pGrade;
        hash = 41 * hash + Objects.hashCode(this.pCommentaire);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pompier other = (Pompier) obj;
        if (this.pId != other.pId) {
            return false;
        }
        if (this.pGrade != other.pGrade) {
            return false;
        }
        if (!Objects.equals(this.pNom, other.pNom)) {
            return false;
        }
        if (!Objects.equals(this.pPrenom, other.pPrenom)) {
            return false;
        }
        if (!Objects.equals(this.pMail, other.pMail)) {
            return false;
        }
        if (!Objects.equals(this.pLogin, other.pLogin)) {
            return false;
        }
        if (!Objects.equals(this.pMdp, other.pMdp)) {
            return false;
        }
        if (!Objects.equals(this.pAdresse, other.pAdresse)) {
            return false;
        }
        if (!Objects.equals(this.pCp, other.pCp)) {
            return false;
        }
        if (!Objects.equals(this.pVille, other.pVille)) {
            return false;
        }
        if (!Objects.equals(this.pBip, other.pBip)) {
            return false;
        }
        if (!Objects.equals(this.pCommentaire, other.pCommentaire)) {
            return false;
        }
        if (!Objects.equals(this.laCaserne, other.laCaserne)) {
            return false;
        }
        if (!Objects.equals(this.leStatut, other.leStatut)) {
            return false;
        }
        if (!Objects.equals(this.leType, other.leType)) {
            return false;
        }
        return true;
    }

    
  

    /**
     * @return the pId
     */
    public int getpId() {
        return pId;
    }

    /**
     * @param pId the pId to set
     */
    public void setpId(int pId) {
        this.pId = pId;
    }

    /**
     * @return the pNom
     */
    public String getpNom() {
        return pNom;
    }

    /**
     * @param pNom the pNom to set
     */
    public void setpNom(String pNom) {
        this.pNom = pNom;
    }

    /**
     * @return the pPrenom
     */
    public String getpPrenom() {
        return pPrenom;
    }

    /**
     * @param pPrenom the pPrenom to set
     */
    public void setpPrenom(String pPrenom) {
        this.pPrenom = pPrenom;
    }

    

    /**
     * @return the pMail
     */
    public String getpMail() {
        return pMail;
    }

    /**
     * @param pMail the pMail to set
     */
    public void setpMail(String pMail) {
        this.pMail = pMail;
    }

    /**
     * @return the pLogin
     */
    public String getpLogin() {
        return pLogin;
    }

    /**
     * @param pLogin the pLogin to set
     */
    public void setpLogin(String pLogin) {
        this.pLogin = pLogin;
    }

    /**
     * @return the pMdp
     */
    public String getpMdp() {
        return pMdp;
    }

    /**
     * @param pMdp the pMdp to set
     */
    public void setpMdp(String pMdp) {
        this.pMdp = pMdp;
    }

    /**
     * @return the leStatut
     */
    public Parametre getLeStatut() {
        return leStatut;
    }

    /**
     * @param leStatut the leStatut to set
     */
    public void setLeStatut(Parametre leStatut) {
        this.leStatut = leStatut;
    }

    /**
     * @return the leType
     */
    public Parametre getLeType() {
        return leType;
    }

    /**
     * @param leType the leType to set
     */
    public void setLeType(Parametre leType) {
        this.leType = leType;
    }

    /**
     * @return the pAdresse
     */
    public String getpAdresse() {
        return pAdresse;
    }

    /**
     * @param pAdresse the pAdresse to set
     */
    public void setpAdresse(String pAdresse) {
        this.pAdresse = pAdresse;
    }

    /**
     * @return the pCp
     */
    public String getpCp() {
        return pCp;
    }

    /**
     * @param pCp the pCp to set
     */
    public void setpCp(String pCp) {
        this.pCp = pCp;
    }

    /**
     * @return the pVille
     */
    public String getpVille() {
        return pVille;
    }

    /**
     * @param pVille the pVille to set
     */
    public void setpVille(String pVille) {
        this.pVille = pVille;
    }

    /**
     * @return the pBip
     */
    public String getpBip() {
        return pBip;
    }

    /**
     * @param pBip the pBip to set
     */
    public void setpBip(String pBip) {
        this.pBip = pBip;
    }

    

    /**
     * @return the pCommentaire
     */
    public String getpCommentaire() {
        return pCommentaire;
    }

    /**
     * @param leCommentaire the pCommentaire to set
     */
    public void setpCommentaire(String pCommentaire) {
        this.pCommentaire = pCommentaire;
    }

    /**
     * @return the pGrade
     */
    public int getpGrade() {
        return pGrade;
    }

    /**
     * @param pGrade the pGrade to set
     */
    public void setpGrade(int pGrade) {
        this.pGrade = pGrade;
    }

    @Override
    public String toString() {
        return "Pompier{" + "laCaserne=" + laCaserne + ", pId=" + pId + ", pNom=" + pNom + ", pPrenom=" + pPrenom + '}';
    }
    
    

    
    
    
    
    
}
