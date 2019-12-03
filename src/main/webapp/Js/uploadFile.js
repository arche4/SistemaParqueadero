const form = document.querySelector('form')

form.addEventListener('submit', e => {
    e.preventDefault()

    const files = document.querySelector('[type=file]').files
    const formData = new FormData()

    for (let i = 0; i < files.length; i++) {
        let file = files[i]

        formData.append('files[]', file)
    }

    $.ajax({
        async: false,
        type: "POST",
        url: "/SistemaParqueadero/MotoServlet",
        data: 'formData=' + formData,
        success: function (data) {
            console.log("La foto fue enviada correctamente");
            $estado.innerHTML = "Foto guardada con éxito. Puedes verla <a target='_blank' href='./" + xhr.responseText + "'> aquí</a>";
        }
    })
})