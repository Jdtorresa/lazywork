

function crear() {
    let errorModal = document.querySelector('#errormodal');
    errorModal.innerHTML = '';
    errorModal.classList.remove('alert-danger');

    let usuarioid = $("#usuarioid").val();
      let apellido = $("#apellido").val();
    let correo = $("#correo").val();
    let documento = $("#documento").val();
    let nivel_soporte = $("#nivel_soporte").val();
    let nombre = $("#nombre").val();
    let telefono = $("#telefono").val();

    if (usuarioid === '' || apellido === '' || correo === '' || documento === '' || nivel_soporte === '' || nombre === '' || telefono === '') {
        errorModal.classList.add('alert-danger');
        $("#errormodal").text("❌ Ingrese todos los campos requeridos para ingresar...");
        return;
    }

    let data = {
        usuarioid: usuarioid,
         apellido: apellido,
         correo: correo,
        documento: documento,
        nivel_soporte: nivel_soporte,
        nombre: nombre,

        telefono: telefono
    };

    $.ajax({
        url: "http://localhost:8080/api/usuario/crear",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            $("#registrarModal").modal("hide");
              $("#usuarioid").val('');
            $("#apellido").val('');
            $("#correo").val('');
            $("#documento").val('');
            $("#nivel_soporte").val('');
            $("#nombre").val('');
            $("#telefono").val('');

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

function findById() {
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');
    let idAConsultar = $("#byid").val();
    let tabla = document.querySelector("#tableid");
    if (idAConsultar === '') {
        errorMensaje.classList.add('alert-danger');
        $("#errormsg").text("❌ Enter a User ID to perform the query");
        return;
    }
    $.ajax({
        url: "http://localhost:8080/api/usuario/buscarporid/" + idAConsultar,
        type: "GET",
        dataType: "json",
        success: function (usuario) {
            $("#byid").val("");
            tabla.innerHTML = ''; // Clear the table
            tabla.innerHTML += '<tr><td>' + usuario.usuarioid +
                '</td><td>' + usuario.nombre +
                '</td><td>' + usuario.apellido +
                '</td><td>' + usuario.correo +
                '</td><td>' + usuario.documento +
                '</td><td>' + usuario.nivel_soporte +
                '</td><td>' + usuario.telefono +
                '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarUsuario(\"" + usuario.usuarioid + "\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\"" + usuario.usuarioid + "\")'> <i class='material-icons'>edit</i></a>" +
                '</td></tr>';
        },
        error: function (xhr) {
            if (xhr.status === 404) {
                errorMensaje.classList.add('alert-danger');
                $("#errormsg").text("❌ User ID " + idAConsultar + " not found...");
                return;
            }
        }
    });
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
        success: function (usuarios) {
            tabla.innerHTML = ''; // Clear the table
            usuarios.forEach(function (usuario) {
                tabla.innerHTML += '<tr><td>' + usuario.usuarioid +
                    '</td><td>' + usuario.nombre +
                    '</td><td>' + usuario.apellido +
                    '</td><td>' + usuario.correo +
                    '</td><td>' + usuario.documento +
                    '</td><td>' + usuario.nivel_soporte +
                    '</td><td>' + usuario.telefono +
                    '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarUsuario(\"" + usuario.usuarioid + "\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\"" + usuario.usuarioid + "\")'> <i class='material-icons'>edit</i></a>" +
                    '</td></tr>';
            });
        }
    });
}
