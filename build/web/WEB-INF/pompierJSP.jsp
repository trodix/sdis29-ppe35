<%-- 
    Document   : pompierJSPF
    Created on : 23 oct. 2017, 15:01:28
    Author     : Dominique_2
--%>

<%@page import="com.sdis29a.beans.Parametre"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, inital-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/mycss.css" rel="stylesheet" />
        <link rel="shortcut icon" type="image/x-icon" href="./images/favicon.ico" />
        <title>SDIS29</title>
    </head>
    <body>        
            <%@include file= "jspf/newjspf.jspf" %>
            <%  ArrayList <Parametre> lesGrades = (ArrayList <Parametre>) maSession.getAttribute("lesGrades");    
                String chef=(codeStatut==2)?"chef":"";%>        
                <div id="contenu">
                    <ul class="nav nav-tabs">
                        <%
                            // Déterminer l'onglet actif en fonction de l'attribut page
                            String monProfilActif = "";
                            String lesDispoActif = "";
                            String lesGardesActif = "";
                            String lesPompiersActif =""; 
                            String laPage= request.getAttribute("page")!=null?(String) request.getAttribute("page"):"";
                            switch (laPage) {
                                case "monProfil" :
                                    monProfilActif = "active";
                                    break;
                                case "lesDispo" :
                                    lesDispoActif = "active";
                                    break;
                                case "lesGardes" :
                                    lesGardesActif = "active";
                                    break;
                                case "lesPompiers" :
                                    lesPompiersActif ="active";
                                    break;
                                default :
                                    monProfilActif = "active";
                                    break;                                    
                            }
                        %>
                        <!--  Liste des onglets affichés en fonction du statut -->
                        <li class="<% out.print(monProfilActif); %>"><a href="#monProfil" data-toggle="tab">Mon profil</a></li>
                        <%
                            switch(codeStatut) {
                                case 1 : %>
                                    <li class="<% out.print(lesDispoActif); %>"><a href="#lesDispo" data-toggle="tab">Mes disponibilités</a></li>
                                    <li><a href="#lesGardes" data-toggle="tab">Mes Gardes</a></li>
                                    <%break; 
                                case 2 : 
                                    String urlLesPompiers = maSession.getAttribute("lesPompiers")!=null ? "href='#lesPompiers' data-toggle='tab'" : "href='pompier?page=lesPompiers'"; %>  
                                    <li class="<% out.print(lesPompiersActif); %>"><a <% out.print(urlLesPompiers); %>>Les pompiers</a></li> 
                                    <!--<li class="<% //out.print(lesPompiersActif); %>"><a href="pompier?page=lesPompiers">Les pompiers</a></li> -->
                                    <li class="<% out.print(lesDispoActif); %>"><a href="#lesDispo" data-toggle="tab">Les disponibilités</a></li>
                                    <li class="<% out.print(lesGardesActif); %>"><a href="#lesGardes" data-toggle="tab">Les Gardes</a></li>
                                <% break;
                                default :
                                    break;
                            }
                        %>
                    </ul>
                    <!--  Contenu des onglets -->
                    <div id="contenuAffiche" class="tab-content">
                        
                        <!-- Contenu de l'onglet Mon profil -->
                        <div class="tab-pane <% out.print(monProfilActif); %>" id ="monProfil">
                            <%  Pompier lePompierAf = lePompier; 
                                int action = 0;
                                String leForm="MonProfil"; %>
                           
                            <fieldset>
                                <legend>
                                    Mes données
                                    <span id="action">
                                        <span class="glyphicon glyphicon-eye-open" title="Voir" onclick="voirPompier('#monProfil');"></span>
                                        <span class="glyphicon glyphicon-pencil" title="Modifier" onclick="modifierPompier('#monProfil');"></span>
                                    </span>                                      
                                </legend>  
                                 <%@include file= "jspf/formPompier.jspf" %>
                            </fieldset>                            
                        </div>
                            
                        <!-- Contenu de l'onglet Les disponibilités -->    
                        <div class="tab-pane <% out.print(lesDispoActif); %>" id="lesDispo">
                            <fieldset>
                                <legend>Les dispo</legend>
                            </fieldset>
                        </div>
                            
                        <!-- Contenu de l'onglet Les pompiers de la caserne -->
                        <div class="tab-pane <% out.print(lesPompiersActif); %>" id="lesPompiers">
                            <fieldset>
                                <legend>Les pompiers de la caserne</legend>
                                <% if (maSession.getAttribute("lesPompiers")!=null) { 
                                    ArrayList<Pompier> lesPompiers =(ArrayList<Pompier>)maSession.getAttribute("lesPompiers");
                                    if (request.getAttribute("lePompierAf")!= null) {
                                        lePompierAf = (Pompier) request.getAttribute("lePompierAf");
                                    } else {
                                        lePompierAf = lesPompiers.get(0);
                                    }
                                    action = 1;
                                    leForm="LesPompiers";
                                %>
                                    <%@include file= "jspf/formChoixPompier.jspf" %>
                                    <%@include file= "jspf/formPompier.jspf" %>
                                <% } %>
                                
                            </fieldset>
                        </div>
                                
                        <!-- Contenu de l'onglet : Les gardes -->
                        <div class="tab-pane <% out.print(lesGardesActif); %>" id="lesGardes">
                            <fieldset>
                                <legend>Les gardes</legend>
                            </fieldset>
                        </div>
                    </div>                      
                </div>
            </main>
            <%@include file= "jspf/footer.jspf" %>
        </div>
        <script src="./js/jquery.js"> </script>
        <script src="./js/bootstrap.js"></script>
        <script>
            $(".formPompier").ready(voirPompier("#monProfil"));
            $("#choixPompier").ready(voirPompier("#lesPompiers"));
            function voirPompier(onglet) {  
                if ($("#lesPompiers .zhAction").val()==2 & onglet == "#lesPompiers") {
                    $("#choixPompier").submit();
                }
                
                var ref = onglet + " .glyphicon";
                $(ref).removeClass("bgWhite");
                ref = onglet + " .glyphicon-eye-open";
                $(ref).addClass("bgWhite");
                
                ref = onglet + " input, " + onglet + " textarea";
                $(ref).attr("readonly",true);
                ref = onglet + " select:not(#ldrPompier)";                
                $(ref).attr("disabled", "disabled");
                ref = onglet + " .submit, " + onglet + " .refPhoto";
                $(ref).hide();                 
            }
            function modifierPompier(onglet) {   
                if (onglet == "#lesPompiers") {
                    if ($("#lesPompiers .zhAction").val()==2) {
                        $("#choixPompier").submit();
                    }
                    $("#lesPompiers .zhAction").val(1);
                }
                var ref = onglet + " .glyphicon";
                $(ref).removeClass("bgWhite");
                ref = onglet + " .glyphicon-pencil";
                $(ref).addClass("bgWhite");
                
                ref = onglet + " input, " + onglet + " textarea";
                $(ref).attr("readonly",false);
                if (onglet == "#lesPompiers") {
                    $("#lesPompiers select").removeAttr("disabled");
                } else {
                    $("#monProfil #ztBip").attr("disabled", "disabled");
                }
                ref = onglet + " .submit, " + onglet + " .refPhoto";
                $(".submit, .refPhoto").show();
            }
            function ajouterPompier() {
                modifierPompier("#lesPompiers");  
                $("#lesPompiers .glyphicon").removeClass("bgWhite");
                $("#lesPompiers .glyphicon-plus").addClass("bgWhite");
                $("#lesPompiers input:not(.btn)").val("");
                $("#lesPompiers .zhAction").val(2);  
                $("#lesPompiers #zhIdP").val(-1);
            }
            
        </script>
</html>
