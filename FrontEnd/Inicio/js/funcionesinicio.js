<<<<<<< HEAD

// Esta función se llama cuando se hace clic en el botón "Buscar por ID"
function findInicioSesionById() {
    const errorMensaje = $("#errormsg");
    errorMensaje.html('');
    errorMensaje.removeClass('alert-danger');
    const idAConsultar = $("#byid").val();

    if (idAConsultar === '') {
        errorMensaje.addClass('alert-danger');
        errorMensaje.text("❌ Ingrese un ID para realizar la consulta");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/buscarporid/" + idAConsultar,
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
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            $("#byid").val("");
<<<<<<< HEAD
            const tabla = $("#tableid");
            tabla.find("tbody").empty();
            tabla.append(`
                <tr>
                    <td>${respuesta.idInicio}</td>
                    <td>${respuesta.hora}</td>
                    <td>${respuesta.fecha}</td>
                    <td>${respuesta.usuario.nombre} ${respuesta.usuario.apellido}</td>
                    <td>
                        <a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio(${respuesta.idInicio})'><i class='material-icons'>delete</i></a>
                        <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio(${respuesta.idInicio})'><i class='material-icons'>edit</i></a>
                    </td>
                </tr>
            `);
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                errorMensaje.addClass('alert-danger');
                errorMensaje.text(`❌ El ID ${idAConsultar} no se encontró...`);
            } else {
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
            }
        }
    });
}

<<<<<<< HEAD
// Esta función se llama cuando se hace clic en el botón "Insertar Inicio de Sesión"
function insertarInicioSesion() {
    const errorModal = $("#errormodal");
    errorModal.html('');
    errorModal.removeClass('alert-danger');

    const usuarioId = $("#usuarioId").val(); // ID del usuario
    const fechaHoraInicio = $("#fechaHoraInicio").val();

    if (usuarioId === '' || fechaHoraInicio === '') {
        errorModal.addClass('alert-danger');
        errorModal.text("❌ Ingresa todos los campos requeridos...");
        return;
    }

    const data = {
        usuario: {
            id: usuarioId // ID del usuario
        },
        fechaHoraInicio: fechaHoraInicio
    };

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/insertar",
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
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
<<<<<<< HEAD
            // Limpiar los campos después de una inserción exitosa
            $("#usuarioId").val('');
            $("#fechaHoraInicio").val('');

            // Cerrar el modal después de la inserción
            $('#registrarModal').modal('hide');

            // Mostrar mensaje de éxito
            alert("Inicio de sesión registrado con éxito.");

            // Actualizar la lista de inicios
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
            data.forEach(function (inicio) {
                tabla.append(`
                    <tr>
                        <td>${inicio.idInicio}</td>
                        <td>${inicio.hora}</td>
                        <td>${inicio.fecha}</td>
                        <td>${inicio.usuario.nombre} ${inicio.usuario.apellido}</td>
                        <td>
                            <a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarInicio("${inicio.idInicio}")'><i class='material-icons'>delete</i></a>
                            <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatosInicio("${inicio.idInicio}")'><i class='material-icons'>edit</i></a>
                        </td>
                    </tr>
                `);
            });
        },
        error: function (xhr) {
            // Manejar errores si es necesario
            if (xhr.status === 404) {
                errorMensaje.addClass('alert-danger');
                errorMensaje.text("❌ Error al listar inicios de sesión: No se encontraron datos.");
            } else {
                errorMensaje.addClass('alert-danger');
                errorMensaje.text("❌ Error al listar inicios de sesión.");
            }
        }
    });
}
// Esta función se llama cuando se hace clic en el botón "Eliminar Inicio de Sesión"
function eliminarInicio() {
    const errorModal = $("#errormodal");
    errorModal.html('');
    errorModal.removeClass('alert-danger');

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

    $.ajax({
        url: "http://localhost:8080/api/iniciosesion/eliminar/" + id,
        type: "DELETE",
        success: function () {
            // Cerrar el modal de eliminación
            $("#eliminarModal").modal("hide");
            
            // Actualizar la lista de inicios después de eliminar uno
            listarIniciosSesion();

            // Mostrar un mensaje de éxito
            alert("Inicio de sesión eliminado con éxito.");
        },
        error: function (xhr) {
            // Manejar errores si es necesario.
            errorModal.addClass('alert-danger');
            errorModal.text("❌ Error al eliminar el inicio de sesión.");
        }
    });
}


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
