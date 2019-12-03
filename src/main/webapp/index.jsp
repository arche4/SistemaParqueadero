<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title>Dashio - Bootstrap Admin Template</title>
        <script src="Js/login.js" type="text/javascript"></script>
        <!-- Favicons -->
        <link href="img/favicon.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Bootstrap core CSS -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--external css-->
        <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet">

        <!-- =======================================================
          Template Name: Dashio
          Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
          Author: TemplateMag.com
          License: https://templatemag.com/license/
        ======================================================= -->
    </head>

    <body>
        <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
        <div id="login-page">
            <div class="container">
                <form class="form-login" method="post" name="Login" id="Login" action="">
                    <h2 class="form-login-heading">Sismtema Parqueadero</h2>
                    <h5 class="form-login-heading">Iniciar Sesion</h5>

                    <div class="login-wrap">
                        <input type="text" class="form-control" id="usuario" name="usuario"  placeholder="Usuario" autofocus>
                        <br>
                        <input type="password" class="form-control" id="clave" name="clave" placeholder="Clave">
                        
                        <button class="btn btn-theme btn-block" name="accion" value="crear" type="submit" onclick="return validar()"><i class="fa fa-lock"></i>INGRESAR</button>
                        <hr>
                        
                        <div class="registration">
                            
                            <a class="" href="#">
                                Registrarse
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="lib/jquery/jquery.min.js"></script>
        <script src="lib/bootstrap/js/bootstrap.min.js"></script>
        <!--BACKSTRETCH-->
        <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
        <script type="text/javascript" src="lib/jquery.backstretch.min.js"></script>
        <script>
            $.backstretch("img/login-bg.jpg", {
                speed: 500
            });
        </script>
    </body>

</html>

