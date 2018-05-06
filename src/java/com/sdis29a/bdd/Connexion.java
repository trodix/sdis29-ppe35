package com.sdis29a.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connexion {
    private static Connection connect;
  
  /**
   * Constructeur
   * @param serveur  nom du serveur, localhost si local
   * @param bdd nom de la base de données
   * @param nomUtil nom utilisateur
   * @param mdp mot de passe lié à l'utilisateur
   */
   
  private Connexion(String serveur, String bdd, String nomUtil, String mdp) {     
    try {
      // 1. Chargement du driver
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver accessible");
 
      // 2. Initialisation des paramètres de connexion
      String host   = serveur;                                  // Serveur de bd
//      String dbname = bdd; // + "?useUnicode=true&characterEncoding=utf-8";  
//      String dbname = bdd + "?characterEncoding=UTF-8";   
      String dbname = bdd;
      String url    = "jdbc:mysql://" + host + "/" + dbname;    // url de connexion      
      String user   = nomUtil;                                  // nom du user
      String passwd = mdp;                                      // mot de passe
       
      // 3. Connexion
      //connect = (Connection) DriverManager.getConnection(url, user, passwd);

      Properties info = new Properties();
      info.setProperty("user", user);
      info.setProperty("password", passwd);
      info.setProperty("useUnicode", "true");
      info.setProperty("characterEncoding", "UTF-8");      
      info.setProperty("noAccessToProcedureBodies", "true");   
      
      connect = (Connection) DriverManager.getConnection(url, info); 

      System.out.println("Connexion réussie !");     
           
    } catch (Exception e) {
      e.printStackTrace();
    }     
  }

    /**
     * Retourne la connection établie (Création d'une connection si elle n'existe pas)
     * @param serveur   nom du serveur, localhost si local
     * @param bdd       nom de la base de données
     * @param nomUtil   nom utilisateur
     * @param mdp       mot de passe lié à l'utilisateur
     * @return connection établie
     */  
    public static Connection getConnect(String serveur, String bdd, String nomUtil, String mdp) {
        System.out.println("getConnect");
        if (connect == null) {
            new Connexion(serveur, bdd, nomUtil, mdp);
        }
        return connect;
    }
    
}
