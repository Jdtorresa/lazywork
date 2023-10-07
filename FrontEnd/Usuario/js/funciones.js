<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD

>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
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
                $("#errormsg").text("❌ El ID " + idAConsultar + " no se encontró...");
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
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======
=======
function findById(){
=======
function buscarUsuarioId(){
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    let errorMensaje = document.querySelector('#errormsg')
    errorMensaje.innerHTML='';
    errorMensaje.classList.remove('alert-danger')
    let idAConsultar=$("#byid").val();
    let tabla=document.querySelector("#tableid");
    if (idAConsultar === '') {
        errorMensaje.classList.add('alert-danger');
        $("#errormsg").text("❌ Ingrese un id para realizar la consulta");
        return;
    }
    $.ajax({
        url: "http://localhost:8080/api/usuario/"+ idAConsultar,
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#byid").val("");
            $("#tableid tbody").remove();
            tabla.innerHTML += '<tr><td>' + respuesta.idUser +
            '</td><td>' + respuesta.nombre +
            '</td><td>' + respuesta.apellido +
            '</td><td>' + respuesta.documento +
            '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarUsuario(\""+respuesta.idUser+"\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\""+respuesta.idUser+"\")'> <i class='material-icons'>edit</i></a>" +
            '</td></tr>';         
        },
        error: function(xhr) {
            if(xhr.status===404){
                errorMensaje.classList.add('alert-danger');
                $("#errormsg").text("❌ El id "+ idAConsultar +" no se encontro...");
                return;
            }
        }
    })
}
function buscarUsuarioIdParametro(id){
    let idAConsultar=$("#byid").val(id);
    buscarUsuarioId()
}

function listarUsuarios(){
    let errorMensaje = document.querySelector('#errormsg')
    errorMensaje.innerHTML='';
    errorMensaje.classList.remove('alert-danger')
    let tabla=document.querySelector("#tableid");
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
    $.ajax({
        url: "http://localhost:8080/api/usuario/listar",
        type: "GET",
        dataType: "json",
<<<<<<< HEAD
        success: function (usuarios) {
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
        success: function (usuario) {
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
            $("#tableid tbody").remove();
            usuarios.forEach(function (usuario) {
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
<<<<<<< HEAD
=======
=======
        success: function(respuesta){
            $("#tableid tbody").remove();
            for(i=0;i<respuesta.length;i++){
                tabla.innerHTML += '<tr><td>' + respuesta[i].idUser +
                '</td><td>' + respuesta[i].nombre +
                '</td><td>' + respuesta[i].apellido +
                '</td><td>' + respuesta[i].documento +
                '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarUsuario(\""+respuesta[i].idUser+"\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\""+respuesta[i].idUser+"\")'> <i class='material-icons'>edit</i></a>" +
                '</td></tr>';
            }      
        }
    })
}

function insertarInicio() {
    let errorModal = document.querySelector('#errormodal')
    errorModal.innerHTML='';
    errorModal.classList.remove('alert-danger')
    let idInicio = $("#idInicio").val();
    
    let hora = $("#" + tipo + "hora").val(); // Nuevo campo para "inicio"
    let fecha = $("#" + tipo + "fecha").val(); // Nuevo campo para "inicio"
    let nombre = $("#" + tipo + "nombre").val();
    let apellido = $("#" + tipo + "apellido").val();
    let documento = $("#" + tipo + "documento").val();

    if (idInicio === '' || isNaN(idInicio)) {
        errorModal.classList.add('alert-danger');
        $("#errormodal").text("❌ Ingrese un ID de inicio válido...");
        return;
    }
     let data = {
        idInicio: idInicio,
        hora: hora, // Reemplaza 'hora' y 'fecha' con tus valores correctos
        fecha: fecha
    }
    
    $.ajax({
        url: "http://localhost:8080/api/inicio/insertar",
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            $("#registrarModal").modal("hide");
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
            $("#nombre").val('');
            $("#apellido").val('');
            $("#documento").val('');
            $("#nivelSoporte").val('');
            findAll();
<<<<<<< HEAD
=======
=======
            $("#" + tipo + "nombre").val('');
            $("#" + tipo + "apellido").val('');
            $("#" + tipo + "documento").val('');
            $("#" + tipo + "id").val('');
            
            // Llamar a la función correspondiente para listar (listarUsuarios o listarInicios)
            if (tipo === "usuario") {
                listarUsuarios();
            } else if (tipo === "inicio") {
                listarInicios();
            }
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
        },
        error: function (xhr) {
            if (xhr.status === 409) {
                errorModal.classList.add('alert-danger');
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
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
    let idAConsultar = $("#nuevoUserId").val();
    let nombre = $("#nombreAC").val();
    let apellido = $("#apellidoAC").val();
    let documento = $("#documentoAC").val();
    let nivelSoporte = $("#nivelSoporteAC").val();
    if (idAConsultar === '' || nombre === '' || apellido === '' || documento === '' || nivelSoporte === '') {
<<<<<<< HEAD
=======
=======
                $("#errormodal").text("❌ El id " + id + " ya existe, ingrese otro...");
                return;
            }
        }
    })
}

function actualizarUsuarios(){
    let errorModal = document.querySelector('#errorAc')
    errorModal.innerHTML='';
    errorModal.classList.remove('alert-danger')
    let id=$("#idAC").val();
    let nombre=$("#nombreAC").val();
    let apellido=$("#apellidoAC").val();
    let documento=$("#documentoAC").val();
    if (id === '' || nombre === '' || apellido ==='' || documento === '') {
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
        errorModal.classList.add('alert-danger');
        $("#errorAc").text("❌ Ingrese todos los campos requeridos para actualizar...");
        return;
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    let data = {
        nombre: nombre,
        apellido: apellido,
        documento: documento,
        nivelSoporte: nivelSoporte
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
            $("#nivelSoporteAC").val('');
            findAll();
        },
        error: function (xhr) {
            // Maneja los errores si es necesario
        }
    });
}

function eliminarUsuario(idUsuario) {
<<<<<<< HEAD
    console.log("ID del usuario a eliminar: " + idUsuario);

    // Configura el ID del usuario como un atributo personalizado en el botón de confirmación
    $("#confirmarEliminacion").data("idUsuario", idUsuario);

    // Adjunta un manejador de clic una sola vez al botón de confirmación
    $("#confirmarEliminacion").off("click").on("click", function () {
        var idUsuario = $(this).data("idUsuario"); // Obtiene el ID del usuario desde el atributo personalizado

        $.ajax({
            url: "http://localhost:8080/api/usuario/eliminar/" + idUsuario,
            type: "DELETE",
            success: function () {
                $("#tableid tbody").find("td:contains('" + idUsuario + "')").closest("tr").remove();
            },
            error: function (xhr) {
<<<<<<< HEAD
                // Maneja errores si es necesario
            }
        });
    });
}
=======
                // Handle errors if necessary
=======
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
=======
    data={
        idUser: id,
        nombre: nombre,
        apellido: apellido,
        documento: documento
    }
    $.ajax({
        url:"http://localhost:8080/api/usuario/actualizar/" + id,
        type:"PUT",
        data: JSON.stringify(data),
        contentType:"application/json",
        success: function(){
            $("#actualizarModal").modal("hide");
            $("#nombreAC").val('');
            $("#apellidoAC").val('');
            $("#documentoAC").val('');
            $("#idAC").val('');    
        },
        error: function(xhr) {
        }  
    })
}

function actualizarUsuarios(){
    let errorModal = document.querySelector('#errorAc')
    errorModal.innerHTML='';
    errorModal.classList.remove('alert-danger')
    let id=$("#idAC").val();
    let nombre=$("#nombreAC").val();
    let apellido=$("#apellidoAC").val();
    let documento=$("#documentoAC").val();
    if (id === '' || nombre === '' || apellido ==='' || documento === '') {
        errorModal.classList.add('alert-danger');
        $("#errorAc").text("❌ Ingrese todos los campos requeridos para actualizar...");
        return;
    }
    data={
        idUser: id,
        nombre: nombre,
        apellido: apellido,
        documento: documento
    }
    $.ajax({
        url:"http://localhost:8080/api/usuario/actualizar",
        type:"PUT",
        data: JSON.stringify(data),
        contentType:"application/json",
        success: function(){
            $("#actualizarModal").modal("hide");
            $("#nombreAC").val('');
            $("#apellidoAC").val('');
            $("#documentoAC").val('');
            $("#idAC").val('');
            buscarUsuarioIdParametro(id)      
        },
        error: function(xhr) {
        }  
    })
}

function eliminarUsuario(idUser) {
    $("#confirmarEliminacion").off("click").on("click", function () {
        $.ajax({
            url: "http://localhost:8080/api/usuario/eliminar/" + idUser,
            type: "DELETE",
            success: function () {
                $("#tableid tbody").find("td:contains('" + idUser + "')").closest("tr").remove();
                $("#exampleModal").modal("hide");
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
            }
        });
    });
}
<<<<<<< HEAD
=======
<<<<<<< HEAD

>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20

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
<<<<<<< HEAD
});
=======
});

=======
function cargarDatos(idUser){
    $.ajax({
        url: "http://localhost:8080/api/usuario/"+ idUser,
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#actu input").val('');
            $("#idAC").val(respuesta.idUser);
            $("#idAC").prop('disabled', true);
            $("#nombreAC").val(respuesta.nombre);
            $("#apellidoAC").val(respuesta.apellido);
            $("#documentoAC").val(respuesta.documento);
        }
    })
}

document.getElementById("byid").addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        buscarUsuarioId(); 
    }
})
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
