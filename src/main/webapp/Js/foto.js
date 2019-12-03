/*
 Tomar una fotografía y guardarla en un archivo
 @date 2017-11-22
 @author parzibyte
 @web parzibyte.me/blog
 */
function tieneSoporteUserMedia() {
    return !!(navigator.getUserMedia || (navigator.mozGetUserMedia || navigator.mediaDevices.getUserMedia) || navigator.webkitGetUserMedia || navigator.msGetUserMedia)
}
function _getUserMedia() {
    return (navigator.getUserMedia || (navigator.mozGetUserMedia || navigator.mediaDevices.getUserMedia) || navigator.webkitGetUserMedia || navigator.msGetUserMedia).apply(navigator, arguments);
}

// Declaramos elementos del DOM
var $video = document.getElementById("video"),
        $canvas = document.getElementById("canvas"),
        $boton = document.getElementById("boton"),
        $estado = document.getElementById("estado");
if (tieneSoporteUserMedia()) {
    _getUserMedia(
            {video: true},
            function (stream) {
                console.log("Permiso concedido");
                $video.srcObject = stream;
                $video.onloadedmetadata = function (e) {
                    $video.play();
                };

                //Escuchar el click
                $boton.addEventListener("click", function () {

                    //Pausar reproducción
                    $video.pause();

                    //Obtener contexto del canvas y dibujar sobre él
                    var contexto = $canvas.getContext("2d");
                    $canvas.width = $video.videoWidth;
                    $canvas.height = $video.videoWidth;
                    contexto.drawImage($video, 0, 0, $canvas.width, $canvas.height);

                    var foto = $canvas.toDataURL("image/png"); //Esta es la foto, en base 64
                    var imagen = foto;
                    var isMoto = document.getElementById('moto').checked;
                    var isbicicleta = document.getElementById('bicicleta').checked;
                    var iscarro = document.getElementById('carro').checked;

                    var cilindraje = document.getElementById('cilindraje').value;
                    var tiempo = document.getElementById('tiempo').value;
                    var placa = document.getElementById('placa').value;


                    var modelo = document.getElementById('modelo').value;
                    var numeroPuertas = document.getElementById('numeroPuertas').value;
                    var placaCarro = document.getElementById('placaCarro').value;
                    if (isMoto) {
                        if (!cilindraje == "" && !tiempo == "" && !placa == "") {
                            $estado.innerHTML = "Enviando foto. Por favor, espera...";
                            var vehiculo = "2";
                            $.ajax({
                                async: false,
                                type: "POST",
                                url: "/SistemaParqueadero/vehiculoServlet",
                                data: 'imagen=' + imagen + '&cilindraje=' + cilindraje + '&tiempo=' + tiempo + '&placa=' + placa + '&vehiculo=' + vehiculo,
                                success: function (data) {
                                    if (data == "Exitoso") {
                                        $('#vehiculo').modal('hide');
                                        $('#foto').modal('hide');
                                        $('#Exitoso').fadeIn(1000);
                                        setTimeout(function () {
                                            $('#Exitoso').fadeOut(1000);
                                        }, 5000);
                                    }

                                }
                            })
                        } else {
                            $('#vehiculo').modal('hide');
                            $('#foto').modal('hide');
                            $('#Error').fadeIn(1000);
                            setTimeout(function () {
                                $('#Error').fadeOut(1000);
                            }, 5000);

                        }
                    }

                    if (iscarro) {
                        if (!modelo == "" && !numeroPuertas == "" && !placaCarro == "") {
                            $estado.innerHTML = "Enviando foto. Por favor, espera...";
                            var vehiculo = "3";
                            $.ajax({
                                async: false,
                                type: "POST",
                                url: "/SistemaParqueadero/vehiculoServlet",
                                data: 'imagen=' + imagen + '&modelo=' + modelo + '&numeroPuertas=' + numeroPuertas + '&placaCarro=' + placaCarro + '&vehiculo=' + vehiculo,
                                success: function (data) {
                                    console.log(data);
                                    if (data == "Exitoso") {
                                        $('#vehiculo').modal('hide');
                                        $('#foto').modal('hide');
                                        $('#Exitoso').fadeIn(1000);
                                        setTimeout(function () {
                                            $('#Exitoso').fadeOut(1000);
                                        }, 5000);
                                    }
                                }
                            })
                        } else {
                            $('#vehiculo').modal('hide');
                            $('#foto').modal('hide');
                            $('#Error').fadeIn(1000);
                            setTimeout(function () {
                                $('#Error').fadeOut(1000);
                            }, 5000);

                        }
                    }

                    if (isbicicleta) {
                        $estado.innerHTML = "Enviando foto. Por favor, espera...";
                        var vehiculo = "1";
                        $.ajax({
                            async: false,
                            type: "POST",
                            url: "/SistemaParqueadero/vehiculoServlet",
                            data: 'imagen=' + imagen + '&vehiculo=' + vehiculo,
                            success: function (data) {
                                if (data == "Exitoso") {
                                    $('#vehiculo').modal('hide');
                                    $('#foto').modal('hide');
                                    $('#Exitoso').fadeIn(1000);
                                    setTimeout(function () {
                                        $('#Exitoso').fadeOut(1000);
                                    }, 5000);
                                } else {
                                    $('#vehiculo').modal('hide');
                                    $('#foto').modal('hide');
                                    $('#Error').fadeIn(1000);
                                    setTimeout(function () {
                                        $('#Error').fadeOut(1000);
                                    }, 5000);
                                }
                            }
                        })
                    }

                    //Reanudar reproducción
                    $video.play();
                });
            }, function (error) {
        console.log("Permiso denegado o error: ", error);
        $estado.innerHTML = "No se puede acceder a la cámara, o no diste permiso.";
    });
} else {
    alert("Lo siento. Tu navegador no soporta esta característica");
    $estado.innerHTML = "Parece que tu navegador no soporta esta característica. Intenta actualizarlo.";
}
