<%-- 
    Document   : authentifJSP
    Created on : 21 oct. 2017, 16:27:46
    Author     : Dominique_2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div id="contenu">
                    <div id="contenuAffiche">
                        <fieldset id="authentif">
                            <legend>
                                Authentification
                            </legend>
                            <form id="fAuthentif" method="POST">
                                <div class="form-group">
                                <label for="ztLogin"> Login * </label>
                                <input type="text" placeholder="login" id="ztLogin" name="ztLogin" class="form-control" required="" />
                                </div>
                                <div class="form-group">
                                <label for="ztMDP"> Mot de passe  * </label>
                                <input type="password" placeholder="mdp" id="ztMDP" name="ztMDP" class="form-control" required/>
                                </div>
                                <div class="submit">
                                    <input type="submit" value="Valider" class="btn btn-danger" />                                    
                                </div>
                            </form>
                            <% if (request.getAttribute("isIncorrect") != null && 
                                    (boolean) request.getAttribute("isIncorrect")) {  %>
                            <div class="alert alert-danger" role="alert">
                                  Login ou mot de passe erroné
                            </div>                     
                            <% } %>    
                        </fieldset>
                    </div>                     
                </div>
            </main>
            <%@include file= "jspf/footer.jspf" %>
        </div>
        <script src="js/jquery.js"> </script>
        <script src="js/bootstrap.js"></script>
    </body>
</html>
