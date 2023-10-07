<<<<<<< HEAD
// Función para buscar inicio de sesión por ID
function findInicioSesionById() {
<<<<<<< HEAD
    const errorMensaje = $("#errormsg");
    errorMensaje.html('').removeClass('alert-danger');
    const idAConsultar = $("#byid").val();
=======
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');
    let idAConsultar = $("#byid").val();
    let tabla = document.querySelector("#tableid");
=======
<<<<<<< HEAD

// Esta función se llama cuando se hace clic en el botón "Buscar por ID"
function findInicioSesionById() {
    const errorMensaje = $("#errormsg");
    errorMensaje.html('');
    errorMensaje.removeClass('alert-danger');
    const idAConsultar = $("#byid").val();
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3

    if (!idAConsultar) {
        errorMensaje.addClass('alert-danger').text("❌ Ingrese un ID para realizar la consulta");
        return;
    }

    $.ajax({
<<<<<<< HEAD
        url: `http://localhost:8080/api/iniciosesion/buscarporid/${idAConsultar}`,
=======
        url: "http://localhost:8080/api/iniciosesion/buscarporid/" + idAConsultar,
<<<<<<< HEAD
=======
=======
function buscarInicioPorId() {
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
        url: "http://localhost:8080/api/inicio/" + idAConsultar,
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            $("#byid").val("");
<<<<<<< HEAD
            const tabla = $("#listaIniciosSesion");
            tabla.empty();
<<<<<<< HEAD
            const usuarioNombreApellido = `${respuesta.usuario.nombre} ${respuesta.usuario.apellido}`;
=======
=======
<<<<<<< HEAD
            const tabla = $("#tableid");
            tabla.find("tbody").empty();
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
            tabla.append(`
                <tr>
                    <td>${respuesta.idInicio}</td>
                    <td>${respuesta.hora}</td>
                    <td>${respuesta.fecha}</td>
                    <td>${usuarioNombreApellido}</td>
                    <td>
<<<<<<< HEAD
                        <button class="btn btn-danger" data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio(${respuesta.idInicio})'><i class='material-icons'>delete</i></button>
                        <button class="btn btn-primary" data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio(${respuesta.idInicio})'><i class='material-icons'>edit</i></button>
=======
                        <a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio(${respuesta.idInicio})'><i class='material-icons'>delete</i></a>
                        <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio(${respuesta.idInicio})'><i class='material-icons'>edit</i></a>
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
                    </td>
                </tr>
            `);
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                errorMensaje.addClass('alert-danger').text(`❌ El ID ${idAConsultar} no se encontró...`);
            } else {
<<<<<<< HEAD
                errorMensaje.addClass('alert-danger').text("❌ Error al realizar la consulta.");
=======
<<<<<<< HEAD
                errorMensaje.addClass('alert-danger');
                errorMensaje.text("❌ Error al realizar la consulta.");
=======
                // Manejar otros errores si es necesario.
=======
            $("#tableid tbody").empty();
            tabla.innerHTML += '<tr><td>' + respuesta.idInicio +
                '</td><td>' + respuesta.hora +
                '</td><td>' + respuesta.fecha +
                '</td><td>' + respuesta.usuario.nombre + ' ' + respuesta.usuario.apellido +
                '</td><td>' + `<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio("${respuesta.idInicio}")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio("${respuesta.idInicio}")'> <i class='material-icons'>edit</i></a>` +
                '</td></tr>';
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                errorMensaje.classList.add('alert-danger');
                $("#errormsg").text("❌ El ID " + idAConsultar + " no se encontró...");
                return;
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
            }
        }
    });
}

<<<<<<< HEAD
// Función para insertar un inicio de sesión
=======
<<<<<<< HEAD
// Esta función se llama cuando se hace clic en el botón "Insertar Inicio de Sesión"
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
function insertarInicioSesion() {
    const errorModal = $("#errormodal");
    errorModal.html('').removeClass('alert-danger');

<<<<<<< HEAD
    const usuarioId = $("#usuarioId").val();
=======
    const usuarioId = $("#usuarioId").val(); // ID del usuario
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    const fechaHoraInicio = $("#fechaHoraInicio").val();

    if (!usuarioId || !fechaHoraInicio) {
        errorModal.addClass('alert-danger').text("❌ Ingresa todos los campos requeridos...");
        return;
    }

    const data = {
<<<<<<< HEAD
        usuario: { id: usuarioId },
=======
        usuario: {
<<<<<<< HEAD
            id: usuarioId
=======
            id: usuarioId // ID del usuario
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
        },
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
        fechaHoraInicio: fechaHoraInicio
    };

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/insertar",
<<<<<<< HEAD
=======
=======
function listarInicios() {
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');
    let tabla = document.querySelector("#tableid");
    $.ajax({
        url: "http://localhost:8080/api/inicio/listar",
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            $("#tableid tbody").empty();
            for (let i = 0; i < respuesta.length; i++) {
                tabla.innerHTML += '<tr><td>' + respuesta[i].idInicio +
                    '</td><td>' + respuesta[i].hora +
                    '</td><td>' + respuesta[i].fecha +
                    '</td><td>' + respuesta[i].usuario.nombre + ' ' + respuesta[i].usuario.apellido +
                    '</td><td>' + `<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio("${respuesta[i].idInicio}")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio("${respuesta[i].idInicio}")'> <i class='material-icons'>edit</i></a>` +
                    '</td></tr>';
            }
        },
        error: function(xhr) {
            // Handle errors if needed
        }
    });
}

function insertarInicio() {
    let errorModal = document.querySelector('#errormodal');
    errorModal.innerHTML = '';
    errorModal.classList.remove('alert-danger');

    // Obtener los datos del formulario
    let id = $("#id").val();
    let anio = $("#anio").val();
    let mes = $("#mes").val();
    let dia = $("#dia").val();
    let hora = $("#hora").val();
    let usuarioId = $("#usuarioId").val();

    // Crear un objeto con los datos
    let data = {
        idInicio: id,
        anio: anio,
        mes: mes,
        dia: dia,
        hora: hora,
        usuarioId: usuarioId
    };

    $.ajax({
        url: "http://localhost:8080/api/inicio/insertar",
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
<<<<<<< HEAD
            $("#usuarioId").val('');
            $("#fechaHoraInicio").val('');
            $('#registrarModal').modal('hide');
            alert("Inicio de sesión registrado con éxito.");
=======
<<<<<<< HEAD
            // Limpiar los campos después de una inserción exitosa
            $("#usuarioId").val('');
            $("#fechaHoraInicio").val('');

            // Cerrar el modal después de la inserción
            $('#registrarModal').modal('hide');

            // Mostrar mensaje de éxito
            alert("Inicio de sesión registrado con éxito.");

            // Actualizar la lista de inicios
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
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

<<<<<<< HEAD
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

=======
// Esta función se llama cuando se hace clic en el botón "Listar Inicios de Sesión"
function listarIniciosSesion() {
    const errorMensaje = $("#errormsg");
    errorMensaje.html('');
    errorMensaje.removeClass('alert-danger');
    const tabla = $("#tableid");
    
    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/listar", // Cambia la URL a la correcta para listar inicios de sesión
        type: "GET",
        dataType: "json",
        success: function (data) {
            // Limpia el contenido de la tabla antes de agregar nuevos datos
            $("#tableid tbody").empty();
            
            // Recorre los datos y agrega cada inicio de sesión a la tabla
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
            data.forEach(function (inicio) {
                const usuarioNombreApellido = `${inicio.usuario.nombre} ${inicio.usuario.apellido}`;
                tabla.append(`
                    <tr>
                        <td>${inicio.idInicio}</td>
                        <td>${inicio.hora}</td>
                        <td>${inicio.fecha}</td>
                        <td>${usuarioNombreApellido}</td>
                        <td>
<<<<<<< HEAD
                            <button class="btn btn-danger" data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio(${inicio.idInicio})'><i class='material-icons'>delete</i></button>
                            <button class="btn btn-primary" data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio(${inicio.idInicio})'><i class='material-icons'>edit</i></button>
=======
                            <a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio("${inicio.idInicio}")'><i class='material-icons'>delete</i></a>
                            <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio("${inicio.idInicio}")'><i class='material-icons'>edit</i></a>
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
                        </td>
                    </tr>
                `);
            });
        },
        error: function (xhr) {
<<<<<<< HEAD
            errorMensaje.addClass('alert-danger');
            if (xhr.status === 404) {
                errorMensaje.text("❌ Error al listar inicios de sesión: No se encontraron datos.");
            } else {
=======
            // Manejar errores si es necesario
            if (xhr.status === 404) {
                errorMensaje.addClass('alert-danger');
                errorMensaje.text("❌ Error al listar inicios de sesión: No se encontraron datos.");
            } else {
                errorMensaje.addClass('alert-danger');
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
                errorMensaje.text("❌ Error al listar inicios de sesión.");
            }
        }
    });
}
<<<<<<< HEAD

<<<<<<< HEAD

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

=======
// Función para eliminar un inicio de sesión
function eliminarInicio(id) {
=======
// Esta función se llama cuando se hace clic en el botón "Eliminar Inicio de Sesión"
function eliminarInicio() {
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    const errorModal = $("#errormodal");
    errorModal.html('');
    errorModal.removeClass('alert-danger');

<<<<<<< HEAD
=======
    const id = $("#idInicioSesionEliminar").val(); // Obtener el ID desde un campo de entrada en el modal
    
    if (id === undefined || id === null || id === "") {
        console.error("ID no válido. No se realizará la eliminación.");
        errorModal.addClass('alert-danger');
        errorModal.text("❌ Ingresa un ID válido.");
        return;
    }

    // Preguntar al usuario si realmente desea eliminar
    if (!confirm("¿Estás seguro de que deseas eliminar este inicio de sesión?")) {
        return;
    }

>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/eliminar/" + id,
        type: "DELETE",
        success: function () {
<<<<<<< HEAD
            listarIniciosSesion();
        },
        error: function (xhr) {
=======
            // Cerrar el modal de eliminación
            $("#eliminarModal").modal("hide");
            
            // Actualizar la lista de inicios después de eliminar uno
            listarIniciosSesion();

            // Mostrar un mensaje de éxito
            alert("Inicio de sesión eliminado con éxito.");
        },
        error: function (xhr) {
            // Manejar errores si es necesario.
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
            errorModal.addClass('alert-danger');
            errorModal.text("❌ Error al eliminar el inicio de sesión.");
        }
    });
}

<<<<<<< HEAD
$(document).ready(function () {
    listarIniciosSesion();
});
=======

// Asegúrate de que estas funciones estén disponibles después de cargar la página
$(document).ready(function () {
    // Puedes mantener esta función vacía o realizar otras tareas de inicialización si es necesario.
});
=======
            // Limpiar los campos del formulario
            $("#id").val('');
            $("#anio").val('');
            $("#mes").val('');
            $("#dia").val('');
            $("#hora").val('');
            $("#usuarioId").val('');

            // Cerrar el modal
            $('#registrarModal').modal('hide');
            
            // Puedes mostrar un mensaje de éxito si lo deseas
        },
        error: function (xhr) {
            // Mostrar un mensaje de error en caso de fallo
            errorModal.classList.add('alert-danger');
            errorModal.textContent = "❌ Error al insertar el inicio.";
        }
    });
}
function ActualizarInicio() {
    let errorModal = document.querySelector('#errormodal');
    errorModal.innerHTML = '';
    errorModal.classList.remove('alert-danger');

    // Obtener los datos del formulario
    let id = $("#idAC").val();
    let anio = $("#anioAC").val();
    let mes = $("#mesAC").val();
    let dia = $("#diaAC").val();
    let hora = $("#horaAC").val();
    let usuarioId = $("#usuarioIdAC").val();

    // Crear un objeto con los datos
    let data = {
        idInicio: id,
        anio: anio,
        mes: mes,
        dia: dia,
        hora: hora,
        usuarioId: usuarioId
    };

    $.ajax({
        url: "http://localhost:8080/api/inicio/actualizar/" + id,
        type: "PUT",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            // Limpiar los campos del formulario
            $("#idAC").val('');
            $("#anioAC").val('');
            $("#mesAC").val('');
            $("#diaAC").val('');
            $("#horaAC").val('');
            $("#usuarioIdAC").val('');

            // Cerrar el modal
            $('#actualizarModal').modal('hide');
            
            // Puedes mostrar un mensaje de éxito si lo deseas
        },
        error: function (xhr) {
            // Mostrar un mensaje de error en caso de fallo
            errorModal.classList.add('alert-danger');
            errorModal.textContent = "❌ Error al actualizar el inicio.";
        }
    });
}


function eliminarInicio(id) {
    let errorModal = document.querySelector('#errormodal');
    errorModal.innerHTML = '';
    errorModal.classList.remove('alert-danger');
    $.ajax({
        url: "http://localhost:8080/api/inicio/eliminar/" + id,
        type: "DELETE",
        success: function () {
            // Aquí puedes realizar alguna acción después de eliminar el inicio, como recargar la lista de inicios.
            listarInicios();
        },
        error: function (xhr) {
            // Manejar errores si es necesario.
            errorModal.classList.add('alert-danger');
            errorModal.textContent = "❌ Error al eliminar el inicio.";
        }
    });
}
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
