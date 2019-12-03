function validar() {
    var usuario = document.getElementById('usuario').value;
    var clave = document.getElementById('clave').value;
    if (usuario == "" && clave == "") {
        toastr.error("No ha ingresado usuario", "Aviso!");
        toastr.error("No ha ingresado clave", "Aviso!");
        return false;
    }
    if ($.trim(clave) == "") {
        toastr.error("No ha ingresado el usuario", "Aviso!");
        return false;
    }
    if ($.trim(usuario) == "") {
        toastr.error("No ha ingresado la clave", "Aviso!");
        return false;
    }
    
    
    if (!usuario == "" && !clave == "") {
        document.getElementById("Login").action = "/SistemaParqueadero/LoginServlet";
        document.getElementById("Login").submit();
        return true;
    }
}