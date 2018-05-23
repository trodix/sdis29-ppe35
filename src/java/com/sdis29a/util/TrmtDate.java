package com.sdis29a.util;
/*
 * Classe abstraite facilitant le traitement des dates
 * Toutes les méthodes sont statiques, appel : TrmtDate.nomMéthode
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author Dominique_2
 */
public abstract class  TrmtDate {
    static Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("Europe/Paris"));
    
    /**
     * Recherche de la date du début de la semaine courante
     * @return date du lundi de la semaine, format Calendar
     */
    public static Calendar getDateDebutSemaine() {
        return getDateDebutSemaine(getDateDuJour());
    }
    
    /**
     * Recherche de la date du début de semaine à partir de la date passée en paramètre
     * @param c Calendar, date de recherche
     * @return Calendar, début semaine à partir de c
     */
    public static Calendar getDateDebutSemaine(Calendar c) {
        Calendar leCal = getClone(c);
        leCal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        //System.out.println("Date du lundi correspondant : " + nvCal.getTime());
        return leCal;
    }
    /**
     * Retourne la date passée en paramètre sous la forme : lun.05/10 par exemple
     * @param d date à transformer
     * @return chaine de car., forme lun.05/10 par exemple
     */
    public static String getDateAAfficher(Calendar d) {    
        Locale locale = Locale.getDefault();
        String dateAAfficher = d.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, locale);         
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        String jrMois = sdf.format(d.getTime()); 
        dateAAfficher += jrMois;        
        return dateAAfficher; 
    }
    
    /**
     * Retourne une date égale à la date passée en paramètre plus le nb jours indiqués
     * @param dateInit date initiale, format Calendar
     * @param days nb jours à ajouter
     * @return dateInit + days, format Calendar
     */
    public static Calendar addDays(Calendar dateInit, int days) {
        Calendar leCal = getClone(dateInit);
        leCal.setTime(dateInit.getTime());
        leCal.add(Calendar.DAY_OF_MONTH, days);
	return leCal;
    }
          
     /**
     * Retourne une instance de Calendar correspondant à la date au format SQl 
     *      passée en paramètre
     * @param sqlDate : date au format java.sql.Date
     * @return instance de Calendar
     */
    public static Calendar getCalDate(java.sql.Date sqlDate) {
        cal.setTime(new java.util.Date(sqlDate.getTime()));
        return cal;
    }
    
    /**
     * Retourne une date sql à partir d'une instance de Calendar
     * @param unCal
     * @return date sql
     */
    public static java.sql.Date getSQLDate(Calendar unCal) {
        return new java.sql.Date(unCal.getTimeInMillis()); 
    }
    
    /**
     * Retourne une instance de Calendar correspondant à la date  
     *      passée en paramètre
     * @param utilDate : date au format java.util.Date
     * @return instance de Calendar
     */
    public static Calendar getCalDate(java.util.Date utilDate) {
        cal.setTime(utilDate);
        return cal;
    }
     
    /**
     * Retourne la date du jour au format SQL
     * @return Date au format sql
     */
    public static java.sql.Date getSQLDateDuJour() {
        return java.sql.Date.valueOf(java.time.LocalDate.now());
    }
    
    /**
     * Retourne la date du jour au format Calendar
     * @return Calendar
     */
    public static Calendar getDateDuJour() {
        Calendar nvCal = new GregorianCalendar(TimeZone.getTimeZone("Europe/Paris"));            
        nvCal.set(Calendar.HOUR_OF_DAY, 0);
        nvCal.set(Calendar.MINUTE, 0);
        nvCal.set(Calendar.SECOND, 0);
        nvCal.set(Calendar.MILLISECOND, 0);
        //System.out.println("Date du jour : " + nvCal.getTime());
        return nvCal;
    }   
    
    /**
     * Permet d'obtenir une autre instance de Calendar identique à celle passée en paramètre
     * @param c Calendar à cloner
     * @return nouvelle instance de Calendar
     */
    public static Calendar getClone(Calendar c) {
        Calendar leCal = Calendar.getInstance();
        leCal.setTime(c.getTime());
        return leCal;
    }
}
