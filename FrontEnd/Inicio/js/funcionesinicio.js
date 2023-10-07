// Función para buscar inicio de sesión por ID
function findInicioSesionById() {
    const errorMensaje = $("#errormsg");
    errorMensaje.html('').removeClass('alert-danger');
    const idAConsultar = $("#byid").val();

    if (!idAConsultar) {
        errorMensaje.addClass('alert-danger').text("❌ Ingrese un ID para realizar la consulta");
        return;
    }

    $.ajax({
        url: `http://localhost:8080/api/iniciosesion/buscarporid/${idAConsultar}`,
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            $("#byid").val("");
            const tabla = $("#listaIniciosSesion");
            tabla.empty();
            const usuarioNombreApellido = `${respuesta.usuario.nombre} ${respuesta.usuario.apellido}`;
            tabla.append(`
                <tr>
                    <td>${respuesta.idInicio}</td>
                    <td>${respuesta.hora}</td>
                    <td>${respuesta.fecha}</td>
                    <td>${usuarioNombreApellido}</td>
                    <td>
                        <button class="btn btn-danger" data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio(${respuesta.idInicio})'><i class='material-icons'>delete</i></button>
                        <button class="btn btn-primary" data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio(${respuesta.idInicio})'><i class='material-icons'>edit</i></button>
                    </td>
                </tr>
            `);
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                errorMensaje.addClass('alert-danger').text(`❌ El ID ${idAConsultar} no se encontró...`);
            } else {
                errorMensaje.addClass('alert-danger').text("❌ Error al realizar la consulta.");
            }
        }
    });
}

// Función para insertar un inicio de sesión
function insertarInicioSesion() {
    const errorModal = $("#errormodal");
    errorModal.html('').removeClass('alert-danger');

    const usuarioId = $("#usuarioId").val();
    const fechaHoraInicio = $("#fechaHoraInicio").val();

    if (!usuarioId || !fechaHoraInicio) {
        errorModal.addClass('alert-danger').text("❌ Ingresa todos los campos requeridos...");
        return;
    }

    const data = {
        usuario: { id: usuarioId },
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
                errorModal.addClass('alert-danger').text("❌ Ya existe un inicio de sesión con los mismos datos...");
            } else {
                errorModal.addClass('alert-danger').text("❌ Error al insertar el inicio de sesión.");
            }
        }
    });
}

// Función para listar inicios de sesión
function listarIniciosSesion() {
    const errorMensaje = $("#errormsg");
    const tabla = $("#listaIniciosSesion");

    errorMensaje.empty().removeClass('alert-danger');
    tabla.empty().append("<tr><td colspan='5'>Cargando...</td></tr>");

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/listar",
        type: "GET",
        dataType: "json",
        success: function (data) {
            tabla.empty();

            if (data.length === 0) {
                errorMensaje.addClass('alert-danger').text("❌ No se encontraron datos.");
                return;
            }

            data.forEach(function (inicio) {
                const usuarioNombreApellido = `${inicio.usuario.nombre} ${inicio.usuario.apellido}`;
                tabla.append(`
                    <tr>
                        <td>${inicio.idInicio}</td>
                        <td>${inicio.hora}</td>
                        <td>${inicio.fecha}</td>
                        <td>${usuarioNombreApellido}</td>
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


function eliminarInicio(idInicio) {
    console.log("ID del inicio de sesión a eliminar: " + idInicio);

    // Configura el ID del inicio de sesión como un atributo personalizado en el botón de confirmación
    $("#confirmarEliminacion").data("idInicio", idInicio);

    // Adjunta un manejador de clic una sola vez al botón de confirmación
    $("#confirmarEliminacion").off("click").on("click", function () {
        var idInicio = $(this).data("idInicio"); // Obtiene el ID del inicio de sesión desde el atributo personalizado

        $.ajax({
            url: "http://localhost:8080/api/iniciosesion/eliminar/" + idInicio,
            type: "DELETE",
            success: function () {
                // Elimina la fila correspondiente de la tabla por ID del inicio de sesión
                $("#listaIniciosSesion").find("tr:has(td:contains('" + idInicio + "'))").remove();
                $('#exampleModal').modal('hide'); // Cierra el modal de confirmación
            },
            error: function (xhr) {
                // Maneja errores si es necesario
                console.error("Error al eliminar el inicio de sesión: " + xhr.statusText);
            }
        });
    });
}



$(document).ready(function () {
    listarIniciosSesion();
});

