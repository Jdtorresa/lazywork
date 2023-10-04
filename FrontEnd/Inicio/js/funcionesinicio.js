// Función para buscar inicio de sesión por ID
function findInicioSesionById() {
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');
    let idAConsultar = $("#byid").val();
    let tabla = document.querySelector("#tableid");

    if (idAConsultar === '') {
        errorMensaje.addClass('alert-danger');
        errorMensaje.text("❌ Ingrese un ID para realizar la consulta");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/buscarporid/" + idAConsultar,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            $("#byid").val("");
            const tabla = $("#listaIniciosSesion");
            tabla.empty();
            tabla.append(`
                <tr>
                    <td>${respuesta.idInicio}</td>
                    <td>${respuesta.hora}</td>
                    <td>${respuesta.fecha}</td>
                    <td>${respuesta.usuario.nombre} ${respuesta.usuario.apellido}</td>
                    <td>
                        <button class="btn btn-danger" data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio(${respuesta.idInicio})'><i class='material-icons'>delete</i></button>
                        <button class="btn btn-primary" data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio(${respuesta.idInicio})'><i class='material-icons'>edit</i></button>
                    </td>
                </tr>
            `);
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                errorMensaje.addClass('alert-danger');
                errorMensaje.text(`❌ El ID ${idAConsultar} no se encontró...`);
            } else {
                errorMensaje.addClass('alert-danger');
                errorMensaje.text("❌ Error al realizar la consulta.");
            }
        }
    });
}

// Función para insertar un inicio de sesión
function insertarInicioSesion() {
    const errorModal = $("#errormodal");
    errorModal.html('');
    errorModal.removeClass('alert-danger');

    const usuarioId = $("#usuarioId").val();
    const fechaHoraInicio = $("#fechaHoraInicio").val();

    if (usuarioId === '' || fechaHoraInicio === '') {
        errorModal.addClass('alert-danger');
        errorModal.text("❌ Ingresa todos los campos requeridos...");
        return;
    }

    const data = {
        usuario: {
            id: usuarioId
        },
        fechaHoraInicio: fechaHoraInicio
    };

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/insertar",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            $("#usuarioId").val('');
            $("#fechaHoraInicio").val('');
            $('#registrarModal').modal('hide');
            alert("Inicio de sesión registrado con éxito.");
            listarIniciosSesion();
        },
        error: function (xhr) {
            if (xhr.status === 409) {
                errorModal.addClass('alert-danger');
                errorModal.text("❌ Ya existe un inicio de sesión con los mismos datos...");
            } else {
                errorModal.addClass('alert-danger');
                errorModal.text("❌ Error al insertar el inicio de sesión.");
            }
        }
    });
}

// Función para listar inicios de sesión
function listarIniciosSesion() {
    const errorMensaje = $("#errormsg");
    const tabla = $("#listaIniciosSesion");

    errorMensaje.empty().removeClass('alert-danger');
    tabla.empty();
    tabla.append("<tr><td colspan='5'>Cargando...</td></tr>");

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/listar",
        type: "GET",
        dataType: "json",
        success: function (data) {
            tabla.empty();

            if (data.length === 0) {
                errorMensaje.addClass('alert-danger');
                errorMensaje.text("❌ No se encontraron datos.");
                return;
            }

            data.forEach(function (inicio) {
                tabla.append(`
                    <tr>
                        <td>${inicio.idInicio}</td>
                        <td>${inicio.hora}</td>
                        <td>${inicio.fecha}</td>
                        <td>${inicio.usuario.nombre} ${inicio.usuario.apellido}</td>
                        <td>
                            <button class="btn btn-danger" data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio(${inicio.idInicio})'><i class='material-icons'>delete</i></button>
                            <button class="btn btn-primary" data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio(${inicio.idInicio})'><i class='material-icons'>edit</i></button>
                        </td>
                    </tr>
                `);
            });
        },
        error: function (xhr) {
            errorMensaje.addClass('alert-danger');
            if (xhr.status === 404) {
                errorMensaje.text("❌ Error al listar inicios de sesión: No se encontraron datos.");
            } else {
                errorMensaje.text("❌ Error al listar inicios de sesión.");
            }
        }
    });
}

// Función para eliminar un inicio de sesión
function eliminarInicio(id) {
    const errorModal = $("#errormodal");
    errorModal.html('');
    errorModal.removeClass('alert-danger');

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/eliminar/" + id,
        type: "DELETE",
        success: function () {
            listarIniciosSesion();
        },
        error: function (xhr) {
            errorModal.addClass('alert-danger');
            errorModal.text("❌ Error al eliminar el inicio de sesión.");
        }
    });
}

$(document).ready(function () {
    listarIniciosSesion();
});
