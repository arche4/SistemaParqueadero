<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="es">
<head>
    
	<!--
		Tomar una fotografía y guardarla en un archivo
	    @date 2017-11-22
	    @author parzibyte
	    @web parzibyte.me/blog
	-->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Tomar foto con Javascript y PHP</title>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

</head>
<body>
	<video id="video"></video>
	<br>
	<button id="boton">Tomar foto</button>
	<p id="estado"></p>
	<canvas id="canvas" style="display: none;"></canvas>
</body>
<script src="../Js/foto.js" type="text/javascript"></script>
</html>