/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.bdd;

import com.sdis29a.beans.Caserne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dominique_2
 */
public class CaserneMySQL {
    private final Connection laConnection  = Connexion.getConnect("Localhost", 
                                                                "sdis29", 
                                                                "adminBDsdis", 
                                                                "mdpBDsdis");    
    public Caserne read(int id) {
        Caserne laCaserne = null;
        try {
            PreparedStatement prepStmt = null;
            String sql = "SELECT * FROM caserne WHERE cId=?";
            prepStmt = laConnection.prepareStatement(sql);
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();
            if (result.first()) {
                laCaserne = new Caserne(result.getInt(1), result.getString(2), 
                                        result.getString(3), result.getString(4));
            }
            prepStmt.close();
        } catch (SQLException ex) {
                System.out.println("SQLExeption : " + ex.getMessage());
                System.out.println("SQLState : " + ex.getSQLState());
                System.out.println("Code erreur : " + ex.getErrorCode());
        }        
        return laCaserne;
    }
}
