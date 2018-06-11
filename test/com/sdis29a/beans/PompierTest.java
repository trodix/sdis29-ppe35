/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.beans;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sébastien
 */
public class PompierTest {
    
    public PompierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLaCaserne method, of class Pompier.
     */
    @Test
    public void testGetLaCaserne() {
        System.out.println("getLaCaserne");
        Caserne expResult = new Caserne(1, "Caserne1", "1 Rue du test", "06 00 00 00 00");
        Pompier unPompier = new Pompier(new Caserne(1, "Caserne1", "1 Rue du test", "06 00 00 00 00"), 1, "Dupont", "Jean");
        Caserne result = unPompier.getLaCaserne();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of setLaCaserne method, of class Pompier.
//     */
//    @Test
//    public void testSetLaCaserne() {
//        System.out.println("setLaCaserne");
//        Caserne laCaserne = null;
//        Pompier instance = null;
//        instance.setLaCaserne(laCaserne);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hashCode method, of class Pompier.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Pompier instance = null;
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equals method, of class Pompier.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Pompier instance = null;
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpId method, of class Pompier.
//     */
//    @Test
//    public void testGetpId() {
//        System.out.println("getpId");
//        Pompier instance = null;
//        int expResult = 0;
//        int result = instance.getpId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpId method, of class Pompier.
//     */
//    @Test
//    public void testSetpId() {
//        System.out.println("setpId");
//        int pId = 0;
//        Pompier instance = null;
//        instance.setpId(pId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpNom method, of class Pompier.
//     */
//    @Test
//    public void testGetpNom() {
//        System.out.println("getpNom");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpNom();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpNom method, of class Pompier.
//     */
//    @Test
//    public void testSetpNom() {
//        System.out.println("setpNom");
//        String pNom = "";
//        Pompier instance = null;
//        instance.setpNom(pNom);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpPrenom method, of class Pompier.
//     */
//    @Test
//    public void testGetpPrenom() {
//        System.out.println("getpPrenom");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpPrenom();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpPrenom method, of class Pompier.
//     */
//    @Test
//    public void testSetpPrenom() {
//        System.out.println("setpPrenom");
//        String pPrenom = "";
//        Pompier instance = null;
//        instance.setpPrenom(pPrenom);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpMail method, of class Pompier.
//     */
//    @Test
//    public void testGetpMail() {
//        System.out.println("getpMail");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpMail();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpMail method, of class Pompier.
//     */
//    @Test
//    public void testSetpMail() {
//        System.out.println("setpMail");
//        String pMail = "";
//        Pompier instance = null;
//        instance.setpMail(pMail);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpLogin method, of class Pompier.
//     */
//    @Test
//    public void testGetpLogin() {
//        System.out.println("getpLogin");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpLogin();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpLogin method, of class Pompier.
//     */
//    @Test
//    public void testSetpLogin() {
//        System.out.println("setpLogin");
//        String pLogin = "";
//        Pompier instance = null;
//        instance.setpLogin(pLogin);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpMdp method, of class Pompier.
//     */
//    @Test
//    public void testGetpMdp() {
//        System.out.println("getpMdp");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpMdp();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpMdp method, of class Pompier.
//     */
//    @Test
//    public void testSetpMdp() {
//        System.out.println("setpMdp");
//        String pMdp = "";
//        Pompier instance = null;
//        instance.setpMdp(pMdp);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getLeStatut method, of class Pompier.
//     */
//    @Test
//    public void testGetLeStatut() {
//        System.out.println("getLeStatut");
//        Pompier instance = null;
//        Parametre expResult = null;
//        Parametre result = instance.getLeStatut();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setLeStatut method, of class Pompier.
//     */
//    @Test
//    public void testSetLeStatut() {
//        System.out.println("setLeStatut");
//        Parametre leStatut = null;
//        Pompier instance = null;
//        instance.setLeStatut(leStatut);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getLeType method, of class Pompier.
//     */
//    @Test
//    public void testGetLeType() {
//        System.out.println("getLeType");
//        Pompier instance = null;
//        Parametre expResult = null;
//        Parametre result = instance.getLeType();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setLeType method, of class Pompier.
//     */
//    @Test
//    public void testSetLeType() {
//        System.out.println("setLeType");
//        Parametre leType = null;
//        Pompier instance = null;
//        instance.setLeType(leType);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpAdresse method, of class Pompier.
//     */
//    @Test
//    public void testGetpAdresse() {
//        System.out.println("getpAdresse");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpAdresse();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpAdresse method, of class Pompier.
//     */
//    @Test
//    public void testSetpAdresse() {
//        System.out.println("setpAdresse");
//        String pAdresse = "";
//        Pompier instance = null;
//        instance.setpAdresse(pAdresse);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpCp method, of class Pompier.
//     */
//    @Test
//    public void testGetpCp() {
//        System.out.println("getpCp");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpCp();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpCp method, of class Pompier.
//     */
//    @Test
//    public void testSetpCp() {
//        System.out.println("setpCp");
//        String pCp = "";
//        Pompier instance = null;
//        instance.setpCp(pCp);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpVille method, of class Pompier.
//     */
//    @Test
//    public void testGetpVille() {
//        System.out.println("getpVille");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpVille();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpVille method, of class Pompier.
//     */
//    @Test
//    public void testSetpVille() {
//        System.out.println("setpVille");
//        String pVille = "";
//        Pompier instance = null;
//        instance.setpVille(pVille);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpBip method, of class Pompier.
//     */
//    @Test
//    public void testGetpBip() {
//        System.out.println("getpBip");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpBip();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpBip method, of class Pompier.
//     */
//    @Test
//    public void testSetpBip() {
//        System.out.println("setpBip");
//        String pBip = "";
//        Pompier instance = null;
//        instance.setpBip(pBip);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpCommentaire method, of class Pompier.
//     */
//    @Test
//    public void testGetpCommentaire() {
//        System.out.println("getpCommentaire");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.getpCommentaire();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpCommentaire method, of class Pompier.
//     */
//    @Test
//    public void testSetpCommentaire() {
//        System.out.println("setpCommentaire");
//        String pCommentaire = "";
//        Pompier instance = null;
//        instance.setpCommentaire(pCommentaire);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getpGrade method, of class Pompier.
//     */
//    @Test
//    public void testGetpGrade() {
//        System.out.println("getpGrade");
//        Pompier instance = null;
//        int expResult = 0;
//        int result = instance.getpGrade();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setpGrade method, of class Pompier.
//     */
//    @Test
//    public void testSetpGrade() {
//        System.out.println("setpGrade");
//        int pGrade = 0;
//        Pompier instance = null;
//        instance.setpGrade(pGrade);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Pompier.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Pompier instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
