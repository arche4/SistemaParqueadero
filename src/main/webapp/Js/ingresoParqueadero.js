function showBicicleta() {
    element = document.getElementById("content3");
    check = document.getElementById("bicicleta");
    if (check.checked) {
        element.style.display = 'block';
    } else {
        element.style.display = 'none';
    }
}
function showMoto() {
    element = document.getElementById("contentMoto");
    check = document.getElementById("moto");
    if (check.checked) {
        element.style.display = 'block';
    } else {
        element.style.display = 'none';
    }
}
function showCarro() {
    element = document.getElementById("contentCarro");
    check = document.getElementById("carro");
    if (check.checked) {
        element.style.display = 'block';
    } else {
        element.style.display = 'none';
    }
}

function showBicicletaIngreso() {
    element = document.getElementById("content1");
    check = document.getElementById("biciIngreso");
    if (check.checked) {
        element.style.display = 'block';
    } else {
        element.style.display = 'none';
    }
}
function showMotoIngreso() {
    element = document.getElementById("content2");
    check = document.getElementById("motoIngreso");
    if (check.checked) {
        element.style.display = 'block';
    } else {
        element.style.display = 'none';
    }
}
function showCarroIngreso() {
    element = document.getElementById("content4");
    check = document.getElementById("carroIngreso");
    if (check.checked) {
        element.style.display = 'block';
    } else {
        element.style.display = 'none';
    }
}



function validarVehiculo() {
    var cilindraje = document.getElementById('cilindraje').value;
    var tiempo = document.getElementById('tiempo').value;
    var placa = document.getElementById('placa').value;
    var placa = document.getElementById('placa').value;

    var bicicleta = document.getElementById('moto').checked;
    var isMoto = document.getElementById('moto').checked;
    var carro = document.getElementById('moto').checked;
    if (isMoto) {

    }

}

function validarUpload() {
    document.getElementById("upload").action = "/SistemaParqueadero/vehiculoServlet";
    document.getElementById("upload").submit();
    return true;
}

$body = $("body");
$(document).ready(function () {
    var alt = $(document).height();
    $('.modal-dialog').css('top', alt * 0.3);
    $(window).resize(function () {
        var alt2 = $(document).height();
        $('.modal-dialog').css('top', alt2 * 0.3);
    });
    $("body").on("click", "#uploapFile", function () {
        const files = document.querySelector('[type=file]').files
        const formData = new FormData()

        for (let i = 0; i < files.length; i++) {
            let file = files[i]

            formData.append('files[]', file)
        }
        $.ajax({
            async: false,
            type: "GET",
            url: "/sofCoiso/MotoServletuploapFile",
            data: 'formData=' + formData,
            success: function (data) {
                var json_obj = $.parseJSON(data);

                $('#modalCaso').modal('show');
            }
        });
    });
});