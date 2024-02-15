var isLoggedIn = false;

    // Función para mostrar u ocultar los botones según el estado de inicio de sesión
    function toggleButtons() {
        var iniciarSesionButton = document.getElementById('iniciarSesion');
        var adminButton = document.getElementById('adminButton');
        var tecnicoButton = document.getElementById('tecnicoButton');

        if (isLoggedIn) {
            iniciarSesionButton.style.display = 'none';
            adminButton.style.display = 'inline-block';  // O 'block' según tus preferencias de estilo
            tecnicoButton.style.display = 'inline-block';  // O 'block' según tus preferencias de estilo
        } else {
            iniciarSesionButton.style.display = 'inline-block';  // O 'block' según tus preferencias de estilo
            adminButton.style.display = 'none';
            tecnicoButton.style.display = 'none';
        }
    }

    // Llama a la función al cargar la página (puedes llamarla según eventos de inicio de sesión reales)
    toggleButtons();

    function getGivenName() {
        let errorMensaje = document.querySelector('#errormsg');
        errorMensaje.innerHTML = '';
        errorMensaje.classList.remove('alert-danger');
        let nombreUsuario = document.querySelector("#nombreUsuario");
        $.ajax({
            url: "http://localhost:8080/user"
            type: "GET",
            dataType: "json",
            success: function (respuesta) {
                $("#nombreUsuario").text(respuesta.nombreUsuario);
            },
            error: function (xhr) {
                if (xhr.status === 404) {
                    errorMensaje.classList.add('alert-danger');
                    $("#errormsg").text("❌ El usuario no se encontró...");
                    return;
                }
            }
        });
    }