/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.beans;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Dominique_2
 */
public class Ventil {
    private Calendar jourVentil;
    private int periode;
    private Pompier pompier;
    private int activite;
    private boolean isDeGarde;
    private boolean isInBdd = false;

    /**
     * @return the jourVentil
     */
    public Calendar getJourVentil() {
        return jourVentil;
    }

    /**
     * @param jourVentil the jourVentil to set
     */
    public void setJourVentil(Calendar jourVentil) {
        this.jourVentil = jourVentil;
    }

    /**
     * @return the periode
     */
    public int getPeriode() {
        return periode;
    }

    /**
     * @param periode the periode to set
     */
    public void setPeriode(int periode) {
        this.periode = periode;
    }

    /**
     * @return the salarie
     */
    public Pompier getPompier() {
        return pompier;
    }

    /**
     * @param salarie the salarie to set
     */
    public void setSalarie(Pompier salarie) {
        this.pompier = salarie;
    }

    /**
     * @return the activite
     */
    public int getActivite() {
        return activite;
    }

    /**
     * @param activite the activite to set
     */
    public void setActivite(int activite) {
        this.activite = activite;
    }

    public Ventil(Calendar jourVentil, int periode, Pompier pompier, int activite, boolean isDeGarde) {
        this.jourVentil = jourVentil;
        this.periode = periode;
        this.pompier = pompier;
        this.activite = activite;
        this.isDeGarde = isDeGarde;
    }

    @Override
    public String toString() {
        return "\nVentil{" + "jourVentil=" + jourVentil.getTime() + ", periode=" + periode + ", pompier=" + pompier + ", activite=" + activite + ", isdeGarde=" + isDeGarde +", isInBdd=" + isIsInBdd() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.jourVentil);
        hash = 41 * hash + Objects.hashCode(this.periode);
        hash = 41 * hash + Objects.hashCode(this.pompier);
        hash = 41 * hash + this.activite;
        hash = 41 * hash + (this.isDeGarde ? 1 : 0);
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
        final Ventil other = (Ventil) obj;
        if (this.activite != other.activite) {
            return false;
        }
        if (this.isDeGarde != other.isDeGarde) {
            return false;
        }
        if (!Objects.equals(this.periode, other.periode)) {
            return false;
        }
        if (!Objects.equals(this.jourVentil, other.jourVentil)) {
            return false;
        }
        if (!Objects.equals(this.pompier, other.pompier)) {
            return false;
        }
        return true;
    }

    

    /**
     * @return the isInBdd
     */
    public boolean isIsInBdd() {
        return isInBdd;
    }

    /**
     * @param isInBdd the isInBdd to set
     */
    public void setIsInBdd(boolean isInBdd) {
        this.isInBdd = isInBdd;
    }

    public boolean isIsDeGarde() {
        return isDeGarde;
    }

    public void setIsDeGarde(boolean isDeGarde) {
        this.isDeGarde = isDeGarde;
    }
       
}
