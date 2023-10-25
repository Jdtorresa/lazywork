function findById(){
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
        url: "http://localhost:8080/rol/findById/"+ idAConsultar,
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#byid").val("");
            $("#tableid tbody").remove();
            tabla.innerHTML += '<tr><td>' + respuesta.rolID +
            '</td><td>' + respuesta.nombreRol +
            '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='deleteById(\""+respuesta.rolID+"\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\""+respuesta.rolID+"\")'> <i class='material-icons'>edit</i></a>" +
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
function buscarRolIdParametro(id){
    let idAConsultar=$("#byid").val(id);
    findById()
}

function findAll(){
    let errorMensaje = document.querySelector('#errormsg')
    errorMensaje.innerHTML='';
    errorMensaje.classList.remove('alert-danger')
    let tabla=document.querySelector("#tableid");
    $.ajax({
        url: "http://localhost:8080/rol/findAll",
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#tableid tbody").remove();
            for(i=0;i<respuesta.length;i++){
                tabla.innerHTML += '<tr><td>' + respuesta[i].rolID +
                '</td><td>' + respuesta[i].nombreRol +
                '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='deleteById(\""+respuesta[i].rolID+"\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\""+respuesta[i].rolID+"\")'> <i class='material-icons'>edit</i></a>" +
                '</td></tr>';
            }      
        }
    })
}

function save(){
    let errorModal = document.querySelector('#errormodal')
    errorModal.innerHTML='';
    errorModal.classList.remove('alert-danger')
    let rolID=$("#rolId").val();
    let nombreRol=$("#nombreRol").val();
    if (rolID === '' || nombreRol === '') {
        errorModal.classList.add('alert-danger');
        $("#errormodal").text("❌ Ingrese todos los campos requeridos para ingresar...");
        return;
    }
    data={
        rolID: rolID,
        nombreRol: nombreRol
    }
    $.ajax({
        url:"http://localhost:8080/rol/save",
        type:"POST",
        data: JSON.stringify(data),
        contentType:"application/json",
        success: function(){
            $("#registrarModal").modal("hide");
            $("#rolId").val('');
            $("#nombreRol").val('');
            findAll(); 
        },
        error: function(xhr) {
            if(xhr.status===409){
                errorModal.classList.add('alert-danger');
                $("#errormodal").text("❌ El id "+ rolID +" ya existe, ingrese otro...");
                return;
            }
        }
        
    })
}

function re_save(){
    let errorModal = document.querySelector('#errorAc')
    errorModal.innerHTML='';
    errorModal.classList.remove('alert-danger')
    let rolID=$("#rolidAC").val();
    let nombreRol=$("#nombrerolAC").val();
    if (rolID === '' || nombreRol === '') {
        errorModal.classList.add('alert-danger');
        $("#errorAc").text("❌ Ingrese todos los campos requeridos para actualizar...");
        return;
    }
    data={
        rolID: rolID,
        nombreRol: nombreRol
    }
    $.ajax({
        url:"http://localhost:8080/rol/re_save",
        type:"PUT",
        data: JSON.stringify(data),
        contentType:"application/json",
        success: function(){
            $("#actualizarModal").modal("hide");
            $("#rolidAC").val('');
            $("#nombrerolAC").val('');
            findAll();
        },
        error: function(xhr) {
        }  
    })
}



function deleteById(rolID) {
    $("#confirmarEliminacion").off("click").on("click", function () {
        $.ajax({
            url: "http://localhost:8080/rol/deleteById/" + rolID,
            type: "DELETE",
            success: function () {
                $("#tableid tbody").find("td:contains('" + rolID + "')").closest("tr").remove();
                $("#exampleModal").modal("hide");
            }
        });
    });
}
function cargarDatos(rolID){
    $.ajax({
        url: "http://localhost:8080/rol/findById/"+ rolID,
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#actu input").val('');
            $("#rolidAC").val(respuesta.rolID);
            $("#rolidAC").prop('disabled', true);
            $("#nombrerolAC").val(respuesta.nombreRol);
        }
    })
}


document.addEventListener("DOMContentLoaded", function () {
    // Llama a la función findAll para mostrar la lista despues de refrescar la página
    findAll();
});

document.getElementById("byid").addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        findById(); 
    }
})



function findById1(){
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
        url: "http://localhost:8080/usuario-rol/findById/"+ idAConsultar,
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#byid").val("");
            $("#tableid tbody").remove();
            tabla.innerHTML += '<tr><td>' + respuesta.usuarioRolID +
            '</td><td>' + respuesta.usuario.id +
            '</td><td>' + respuesta.rol.rolID +
            '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='deleteById(\""+respuesta.usuarioRolID+"\")'> <i class='material-icons'>delete</i></a>" +
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
function buscarUsuarioRolIdParametro(id){
    let idAConsultar=$("#byid").val(id);
    findById()
}

function findAll1(){
    let errorMensaje = document.querySelector('#errormsg')
    errorMensaje.innerHTML='';
    errorMensaje.classList.remove('alert-danger')
    let tabla=document.querySelector("#tableid1");
    $.ajax({
        url: "http://localhost:8080/usuario-rol/findAll",
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#tableid1 tbody").remove();
            for(i=0;i<respuesta.length;i++){
                tabla.innerHTML += '<tr><td>' + respuesta[i].usuarioRolID +
                '</td><td>' + respuesta[i].usuario.id +
                '</td><td>' + respuesta[i].rol.rolID +
                '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='deleteById(\""+respuesta[i].usuarioRolID+"\")'> <i class='material-icons'>delete</i></a>" +
                '</td></tr>';
            }      
        }
    })
}

function save(){
    let errorModal = document.querySelector('#errormodal')
    errorModal.innerHTML='';
    errorModal.classList.remove('alert-danger')
    let usuarioRolID=$("#usuarioRolId").val();
    let usuario=$("#usuarioId").val();
    let rol=$("#rolId").val();
    if (usuarioRolID === '' || usuario === '' || rol === '') {
        errorModal.classList.add('alert-danger');
        $("#errormodal").text("❌ Ingrese todos los campos requeridos para ingresar...");
        return;
    }

    data={
        usuarioRolID: usuarioRolID,
        usuario: {
            id: usuario
        },
        rol: {
            rolID: rol
        }
    }
    $.ajax({
        url:"http://localhost:8080/usuario-rol/save",
        type:"POST",
        data: JSON.stringify(data),
        contentType:"application/json",
        success: function(){
            $("#registrarModal1").modal("hide");
            $("#usuarioRolId").val('');
            $("#usuarioId").val('');
            $("#rolId").val('');
            findAll(); 
        },
        error: function(xhr) {
            if(xhr.status===409){
                errorModal.classList.add('alert-danger');
                $("#errormodal").text("❌ El Nº Registro "+ usuarioRolID +" ya existe, ingrese otro...");
                return;
            }
            else if(xhr.status===400){
                errorModal.classList.add('alert-danger');
                $("#errormodal").text("❌ Vuelva a verificar los campos Usuario y Rol");
                return;
            }
        }
        
    })
}





function deleteById(usuarioRolID) {
    $("#confirmarEliminacion").off("click").on("click", function () {
        $.ajax({
            url: "http://localhost:8080/usuario-rol/deleteById/" + usuarioRolID,
            type: "DELETE",
            success: function () {
                $("#tableid1 tbody").find("td:contains('" + usuarioRolID + "')").closest("tr").remove();
                $("#exampleModal").modal("hide");
            }
        });
    });
}
function cargarDatos(usuarioRolID){
    $.ajax({
        url: "http://localhost:8080/usuario-rol/findById/"+ usuarioRolID,
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#actu input").val('');
            $("#usuariorolidAC").val(respuesta.usuarioRolID);
            $("#usuariorolidAC").prop('disabled', true);
            $("#usuarioidAC").val(respuesta.usuario);
            $("#rolidAC").val(respuesta.rol);
        }
    })
}


document.addEventListener("DOMContentLoaded", function () {
    // Llama a la función findAll para mostrar la lista despues de refrescar la página
    findAll();
});

document.getElementById("byid").addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        findById(); 
    }
})