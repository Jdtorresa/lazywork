
function findById() {
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');
    let idAConsultar = $("#byid").val();
    let tabla = document.querySelector("#tableid");
    if (idAConsultar === '') {
        errorMensaje.classList.add('alert-danger');
        $("#errormsg").text("❌ Ingrese un ID para realizar la consulta");
        return;
    }
    $.ajax({
        url: "http://localhost:8080/api/usuario/buscarporid/" + idAConsultar,
        type: "GET",
        dataType: "json",
        success: function (usuario) {
            $("#byid").val("");
            $("#tableid tbody").remove();
            tabla.innerHTML += '<tr><td>' + usuario.id +
                '</td><td>' + usuario.nombre +
                '</td><td>' + usuario.apellido +
                '</td><td>' + usuario.documento +
                '</td><td>' + usuario.nivelSoporte +
                '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarUsuario(\"" + usuario.id + "\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\"" + usuario.id + "\")'> <i class='material-icons'>edit</i></a>" +
                '</td></tr>';
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                errorMensaje.classList.add('alert-danger');
                $("#errormsg").text("❌ El ID " + id + " no se encontró...");
                return;
            }
        }
    });
}

function buscarUsuarioIdParametro(idUsuario) {
    let id = $("#byid").val(idUsuario);
    findById();
}

function findAll() {
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');
    let tabla = document.querySelector("#tableid");
    $.ajax({
        url: "http://localhost:8080/api/usuario/listar",
        type: "GET",
        dataType: "json",
        success: function (usuario) {
            $("#tableid tbody").remove();
            usuario.forEach(function (usuario) {
                tabla.innerHTML += '<tr><td>' + usuario.id +
                    '</td><td>' + usuario.nombre +
                    '</td><td>' + usuario.apellido +
                    '</td><td>' + usuario.documento +
                    '</td><td>' + usuario.nivelSoporte +
                    '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarUsuario(\"" + usuario.id + "\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\"" + usuario.id + "\")'> <i class='material-icons'>edit</i></a>" +
                    '</td></tr>';
            });
        }
    });

}
function crear() {
    let errorModal = document.querySelector('#errormodal');
    errorModal.innerHTML = '';
    errorModal.classList.remove('alert-danger');
    let nombre = $("#nombre").val();
    let apellido = $("#apellido").val();
    let documento = $("#documento").val();
    let nivelSoporte = $("#nivelSoporte").val();
    if (nombre === '' || apellido === '' || documento === '' || nivelSoporte === '') {
        errorModal.classList.add('alert-danger');
        $("#errormodal").text("❌ Ingrese todos los campos requeridos para ingresar...");
        return;
    }
    let data = {
        nombre: nombre,
        apellido: apellido,
        documento: documento,
        nivelSoporte: nivelSoporte
    };
    $.ajax({
        url: "http://localhost:8080/api/usuario/crear",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            $("#registrarModal").modal("hide");
            $("#nombre").val('');
            $("#apellido").val('');
            $("#documento").val('');
            $("#nivelSoporte").val('');
            findAll();
        },
        error: function (xhr) {
            if (xhr.status === 409) {
                errorModal.classList.add('alert-danger');
                $("#errormodal").text("❌ Ya existe un usuario con los mismos datos...");
                return;
            }
        }
    });
}

function actualizarUsuario() {
    let errorModal = document.querySelector('#errorAc');
    errorModal.innerHTML = '';
    errorModal.classList.remove('alert-danger');
    
    // Obtener el valor del campo "Nº Usuario" del formulario de actualización
    let idAConsultar = $("#nuevoUserId").val();
    
    let nombre = $("#nombreAC").val();
    let apellido = $("#apellidoAC").val();
    let documento = $("#documentoAC").val();
    let nivelSoporte = $("#nivelSoporteAC").val();
    if (idAConsultar === '' || nombre === '' || apellido === '' || documento === '' || nivelSoporte === '') {
        errorModal.classList.add('alert-danger');
        $("#errorAc").text("❌ Ingrese todos los campos requeridos para actualizar...");
        return;
    }
    let data = {
        nombre: nombre,
        apellido: apellido,
        documento: documento,
        nivelSoporte: nivelSoporte // Agregar nivel de soporte al objeto data
    };
    $.ajax({
        url: "http://localhost:8080/api/usuario/actualizar/" + idAConsultar,
        type: "PUT",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            $("#actualizarModal").modal("hide");
            $('#nuevoUserId').val('');
            $("#nombreAC").val('');
            $("#apellidoAC").val('');
            $("#documentoAC").val('');
            $("#nivelSoporteAC").val(''); // Limpiar el campo nivel de soporte
            findAll();
        },
        error: function (xhr) {
            // Handle errors if necessary
        }
    });
}

function eliminarUsuario(idUsuario) {
    // Imprime el ID del usuario a eliminar en la consola
    console.log("ID del usuario a eliminar: " + idUsuario);

    // Configura un manejador de clic en el botón de confirmación
    $("#confirmarEliminacion").off("click").on("click", function () {
        // Realiza una solicitud AJAX para eliminar el usuario
        $.ajax({
            // Especifica la URL del servicio web para eliminar el usuario
            url: "http://localhost:8080/api/usuario/eliminar/" + idUsuario,
            // Especifica el tipo de solicitud como DELETE
            type: "DELETE",
            success: function () {
                // En caso de éxito, elimina la fila correspondiente en la tabla de la interfaz de usuario
                $("#tableid tbody").find("td:contains('" + idUsuario + "')").closest("tr").remove();
            },
            error: function (xhr) {
                // Maneja los errores si es necesario
                // Puedes agregar código aquí para manejar los errores de la solicitud
            }
        });
    });
}


function cargarDatos(idUsuario) {
    $.ajax({
        url: "http://localhost:8080/api/usuario/" + idUsuario,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            $("#actualizarUsuarioModal input").val('');
            $("#nuevoUserId").val(respuesta.noUsuario);
            $("#nuevoUserId").prop('disabled', true);
            $("#nuevoNombre").val(respuesta.nombre);
            $("#nuevoApellido").val(respuesta.apellido);
            $("#nuevoDocumento").val(respuesta.documento);
            $("#nivelSoporteAC").val(respuesta.nivelSoporte); // Agregar nivel de soporte al formulario de actualización
        }
    });
}

document.getElementById("nuevoUserId").addEventListener("keydown", function (event) {
    if (event.key === "Enter") {
        event.preventDefault();
        findById();
    }
});

