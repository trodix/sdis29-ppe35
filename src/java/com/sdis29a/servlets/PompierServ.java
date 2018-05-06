/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdis29a.servlets;

import com.sdis29a.bdd.PompierMySQL;
import com.sdis29a.beans.Pompier;
import com.sdis29a.forms.MajPompierForms;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dominique_2
 */
public class PompierServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PompierServ</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PompierServ at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request.getParameter("page") != null) {
            String laPage = request.getParameter("page");
            request.setAttribute("page", laPage);
            //request.setAttribute("action", request.getParameter("action"));
            switch (laPage) {
                case ("lesPompiers") :
                    HttpSession maSession = request.getSession();
                    if (maSession.getAttribute("lesPompiers") == null) {
                        Pompier lePompier = (Pompier) maSession.getAttribute("lePompier");
                        int codeCaserne = lePompier.getLaCaserne().getcId();
                        PompierMySQL pompierMyQSL = new PompierMySQL();
                        ArrayList <Pompier> lesPompiers = pompierMyQSL.readLesPompiersCaserne(codeCaserne);
                        maSession.setAttribute("lesPompiers", lesPompiers);                        
                    }
                    break;
                case ("monProfil") :
                    break;
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/pompierJSP.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession maSession = request.getSession();  
        String page = request.getParameter("page")!=null?request.getParameter("page"):"";
        
        // --------------------------------------Choix du pompier à afficher----------------------------------------
        if (page.equals("choixPompier")) {
                ArrayList<Pompier> lesPompiers =(ArrayList<Pompier>)maSession.getAttribute("lesPompiers");
                int indice = Integer.parseInt(request.getParameter("ldrPompier"));
                Pompier lePompierAf = lesPompiers.get(indice);
                request.setAttribute("lePompierAf",lePompierAf);
                request.setAttribute("page","lesPompiers");
                getServletContext().getRequestDispatcher("/WEB-INF/pompierJSP.jsp").forward(request, response);                           
        }
        // -------------------------------------MAJ ou ajout ------------------------------------------------------
        String laPage="";
        Pompier lePompier = (Pompier) maSession.getAttribute("lePompier"); // Pompier authentifié
        MajPompierForms majPompierForms = new MajPompierForms();
        Pompier lePompierMaj = majPompierForms.majPompier(request, lePompier);
        if (lePompierMaj == null) { // maj ko -- A compléter
            processRequest(request, response);
        } else {
                                     
            if (request.getParameter("btLesPompiers")!=null) {
                // --- Cas : Modif d'un pompier volontaire ou ajout d'un nouveau pompier volontaire ---
                laPage = "lesPompiers";
                // Maj de la liste des pompiers
                PompierMySQL pompierMyQSL = new PompierMySQL();
                ArrayList <Pompier> lesPompiers = pompierMyQSL.readLesPompiersCaserne(lePompier.getLaCaserne().getcId());
                // Préparation de l'affichage sur le pompier maj
                maSession.setAttribute("lesPompiers", lesPompiers);                  
                request.setAttribute("lePompierAf",lePompierMaj);                     
            } else {
                // --- Cas : Modif de mon profil ---
                maSession.setAttribute("lePompier", lePompierMaj);
                laPage = "monProfil";                           
            }
            request.setAttribute("page", laPage);
            getServletContext().getRequestDispatcher("/WEB-INF/pompierJSP.jsp").forward(request, response); 
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
