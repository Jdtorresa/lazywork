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
        url: "http://localhost:8080/incidencia/"+ idAConsultar,
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#byid").val("");
            $("#tableid tbody").remove();
            tabla.innerHTML += '<tr><td>' + respuesta.incidenciaID +
            '</td><td>' + respuesta.nombreIncidencia +
            '</td><td>' + respuesta.ubicacion +
            '</td><td>' + respuesta.descripcion +
            '</td><td>' + respuesta.fechaRegistro +
            '</td><td>' + respuesta.usuario.id+
            '</td><td>' + respuesta.estado.estadoID+
            '</td><td>' + respuesta.prioridad.prioridadID+
            '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarIncidencia(\""+respuesta.incidenciaID+"\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\""+respuesta.incidenciaID+"\")'> <i class='material-icons'>edit</i></a>" +
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
function buscarIncidenciaIdParametro(noIncidencia){
    let idAConsultar=$("#byid").val(noIncidencia);
    buscarIncidenciaId()
}

function findAll(){
    let errorMensaje = document.querySelector('#errormsg')
    errorMensaje.innerHTML='';
    errorMensaje.classList.remove('alert-danger')
    let tabla=document.querySelector("#tableid");
    $.ajax({
        url: "http://localhost:8080/incidencia/listar",
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            console.log(respuesta)
            $("#tableid tbody").remove();
            for(i=0;i<respuesta.length;i++){
                tabla.innerHTML += '<tr><td>' + respuesta[i].incidenciaID +
                '</td><td>' + respuesta[i].nombreIncidencia +
                '</td><td>' + respuesta[i].ubicacion +
                '</td><td>' + respuesta[i].descripcion +
                '</td><td>' + respuesta[i].fechaRegistro +
                '</td><td>' + respuesta[i].usuario.id+
                '</td><td>' + respuesta[i].estado.estadoID+
                '</td><td>' + respuesta[i].prioridad.prioridadID+
                '</td><td>' + "<a href='#' class='eliminar-link' data-bs-toggle='modal' data-bs-target='#exampleModal' onclick='eliminarIncidencia(\""+respuesta[i].incidenciaID+"\")'> <i class='material-icons'>delete</i></a> <a href='#' class='editar-link' data-bs-toggle='modal' data-bs-target='#actualizarModal' onclick='cargarDatos(\""+respuesta[i].incidenciaID+"\")'> <i class='material-icons'>edit</i></a>" +
                '</td></tr>';
            }      
        }
    })
}

function findAll2() {
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');

    // Ocultar la tabla
    document.querySelector("#tableid").style.display = 'none';

    $.ajax({
        url: "http://localhost:8080/incidencia/listar",
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            let categories = [];
            let incidencesCount = [];

            respuesta.forEach(function (item) {
                categories.push(item.nombreIncidencia);
                incidencesCount.push(item.incidenciaID);
            });

            const canvas = document.getElementById('graficoIncidencias');
            canvas.width = 100;
            canvas.height = 100;

            const ctx = canvas.getContext('2d');

            const incidenceChart = new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: categories,
                    datasets: [
                        {
                            label: 'Numero de Incidencias',
                            data: incidencesCount,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                            ],
                            borderWidth: 1,
                        },
                    ],
                },
                options: {
                    plugins: {
                        legend: {
                            position: 'true', // Mostrar la leyenda en el lado izquierdo
                            labels: {
                                boxWidth: 20, // Tamaño de las cajas de la leyenda
                                fontSize: 12, // Tamaño de fuente de la leyenda
                            },
                        },
                    },
                },
            });

            // Rotar la gráfica para hacerla horizontal
            incidenceChart.rotation = Math.PI;
        },
        error: function (error) {
            console.error('Error al cargar los datos de incidencias:', error);
        }
    });
}


function findAll2estado4() {
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');

    // Ocultar la tabla
    document.querySelector("#tableid2").style.display = 'none';

    $.ajax({
        url: "http://localhost:8080/incidencia/estado4",
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            let categories = [];
            let incidencesCount = [];

            respuesta.forEach(function (item) {
                categories.push(item.nombreIncidencia);
                incidencesCount.push(item.incidenciaID);
            });

            const canvas = document.getElementById('graficoIncidencias2');
            canvas.width = 200; // Establecer ambos valores iguales para hacer un círculo
            canvas.height = 200;

            const ctx = canvas.getContext('2d');

            const incidenceChart = new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: categories,
                    datasets: [
                        {
                            label: 'Numero de Incidencia',
                            data: incidencesCount,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                            ],
                            borderWidth: 1, // Establecer el borde en 0 para hacer un círculo
                        },
                    ],
                },
                options: {
                    plugins: {
                        legend: {
                            display: true, // Mostrar la leyenda
                            position: 'left', // Mostrar la leyenda en el lado izquierdo
                            labels: {
                                boxWidth: 20, // Tamaño de las cajas de la leyenda
                                fontSize: 12, // Tamaño de fuente de la leyenda
                            },
                        },
                    },
                },
            });

            // Rotar la gráfica para hacerla horizontal
            incidenceChart.rotation = Math.PI;
        },
        error: function (error) {
            console.error('Error al cargar los datos de incidencias:', error);
        }
    });
}



function findAll2estado1() {
    let errorMensaje = document.querySelector('#errormsg');
    errorMensaje.innerHTML = '';
    errorMensaje.classList.remove('alert-danger');

    // Ocultar la tabla
    document.querySelector("#tableid3").style.display = 'none';

    $.ajax({
        url: "http://localhost:8080/incidencia/estado1",
        type: "GET",
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            let categories = [];
            let incidencesCount = [];

            respuesta.forEach(function (item) {
                categories.push(item.nombreIncidencia);
                incidencesCount.push(item.incidenciaID);
                
            });

            const canvas = document.getElementById('graficoIncidencias3');
            canvas.width = 100;
            canvas.height = 100;

            const ctx = canvas.getContext('2d');

            const incidenceChart = new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: categories,
                    datasets: [
                        {
                            label: 'Numero de Incidencias',
                            data: incidencesCount,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                            ],
                            borderWidth: 1,
                        },
                    ],
                },
                options: {
                    plugins: {
                        legend: {
                            display: false, 
                            position: 'left', // Mostrar la leyenda en el lado izquierdo
                            labels: {
                                boxWidth: 20, // Tamaño de las cajas de la leyenda
                                fontSize: 12, // Tamaño de fuente de la leyenda
                            },// Oculta la leyenda
                        },
                    },
                },
            });

            // Rotar la gráfica para hacerla horizontal
            incidenceChart.rotation = Math.PI;
        },
        error: function (error) {
            console.error('Error al cargar los datos de incidencias:', error);
        }
    });
}







function obtenerIncidenciasEstado4(){
    let errorMensaje = document.querySelector('#errormsg')
    errorMensaje.innerHTML='';
    errorMensaje.classList.remove('alert-danger')
    let tabla=document.querySelector("#tableid2");
    $.ajax({
        url: "http://localhost:8080/incidencia/estado4",
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            console.log(respuesta)
            $("#tableid2 tbody").remove();
            for(i=0;i<respuesta.length;i++){
                tabla.innerHTML += '<tr><td>' + respuesta[i].incidenciaID +
                '</td><td>' + respuesta[i].nombreIncidencia +
                '</td><td>' + respuesta[i].ubicacion +
                '</td><td>' + respuesta[i].descripcion +
                '</td><td>' + respuesta[i].fechaRegistro +
                '</td><td>' + respuesta[i].usuario.id+
                '</td><td>' + respuesta[i].estado.estadoID+
                '</td><td>' + respuesta[i].prioridad.prioridadID+
             
                '</td></tr>';
            }      
        }
    })
}


function obtenerIncidenciasEstado3(){
    let errorMensaje = document.querySelector('#errormsg')
    errorMensaje.innerHTML='';
    errorMensaje.classList.remove('alert-danger')
    let tabla=document.querySelector("#tableid2");
    $.ajax({
        url: "http://localhost:8080/incidencia/estado3",
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            console.log(respuesta)
            $("#tableid2 tbody").remove();
            for(i=0;i<respuesta.length;i++){
                tabla.innerHTML += '<tr><td>' + respuesta[i].incidenciaID +
                '</td><td>' + respuesta[i].nombreIncidencia +
                '</td><td>' + respuesta[i].ubicacion +
                '</td><td>' + respuesta[i].descripcion +
                '</td><td>' + respuesta[i].fechaRegistro +
                '</td><td>' + respuesta[i].usuario.id+
                '</td><td>' + respuesta[i].estado.estadoID+
                '</td><td>' + respuesta[i].prioridad.prioridadID+
               
                '</td></tr>';
            }      
        }
    })
}



function obtenerIncidenciasEstado1(){
    let errorMensaje = document.querySelector('#errormsg')
    errorMensaje.innerHTML='';
    errorMensaje.classList.remove('alert-danger')
    let tabla=document.querySelector("#tableid2");
    $.ajax({
        url: "http://localhost:8080/incidencia/estado1",
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            console.log(respuesta)
            $("#tableid2 tbody").remove();
            for(i=0;i<respuesta.length;i++){
                tabla.innerHTML += '<tr><td>' + respuesta[i].incidenciaID +
                '</td><td>' + respuesta[i].nombreIncidencia +
                '</td><td>' + respuesta[i].ubicacion +
                '</td><td>' + respuesta[i].descripcion +
                '</td><td>' + respuesta[i].fechaRegistro +
                '</td><td>' + respuesta[i].usuario.id+
                '</td><td>' + respuesta[i].estado.estadoID+
                '</td><td>' + respuesta[i].prioridad.prioridadID+
              
                '</td></tr>';
            }      
        }
    })
}



function save(){
    let errorModal = document.querySelector('#errormodal')
    errorModal.innerHTML='';
    errorModal.classList.remove('alert-danger');
    let nombre=$("#nombre").val();
    let descripcion=$("#descripcion").val();
    let ubicacion=$("#ubicacion").val();
    let usuario=$("#usuario option:selected").val();
    let prioridad=$("#prioridad option:selected").val();
    let estado=$("#estado option:selected").val();
    if (descripcion === '' || nombre === '' || ubicacion ==='' || usuario === '' || prioridad === '' || estado === '') {
        errorModal.classList.add('alert-danger');
        $("#errormodal").text("❌ Ingrese todos los campos requeridos para ingresar...");
        return;
    }
    data={
        nombreIncidencia: nombre,
        ubicacion: ubicacion,
        descripcion:descripcion,
        usuario: {
            id: usuario
        },
        prioridad: {
            prioridadID: prioridad
        },
        estado: {
            estadoID: estado
        }
    }
    $.ajax({
        url:"http://localhost:8080/incidencia/crear",
        type:"POST",
        data: JSON.stringify(data),
        contentType:"application/json",
        success: function(){
            $("#registrarModal").modal("hide");
            $("#nombre").val('');
            $("#ubicacion").val('');
            $("#descripcion").val('');
            $("#usuario").val('');
            $("#prioridad").val('');
            $("#estado").val('');
            findAll()
        },
        error: function(xhr) {
            if(xhr.status===409){
                errorModal.classList.add('alert-danger');
                $("#errormodal").text("❌ El id "+ noIncidencia +" ya existe, ingrese otro...");
                return;
            }
            else{
                errorModal.classList.add('alert-danger');
                $("#errormodal").text("❌ El usuario "+ usuario +" no existe...");
                return; 
            }
        }
        
    })
}
function update(){
    let errorModal = document.querySelector('#errorAc')
    errorModal.innerHTML='';
    errorModal.classList.remove('alert-danger')
    let id=$("#idAC").val();
    let nombre=$("#nombreAC").val();
    let descripcion=$("#descripcionAC").val();
    let ubicacion=$("#ubicacionAC").val();
    let usuario=$("#usuarioAC option:selected").val();
    let prioridad=$("#prioridadAC option:selected").val();
    let estado=$("#estadoAC option:selected").val();
    if (id === '' || nombre === '' || ubicacion ==='' || descripcion ==='' || usuario === '' || prioridad ===''|| estado === '') {
        errorModal.classList.add('alert-danger');
        $("#errorAc").text("❌ Ingrese todos los campos requeridos para actualizar...");
        return;
    }
    data={
        incidenciaID: id,
        nombreIncidencia: nombre,
        ubicacion: ubicacion,
        descripcion:descripcion,
        usuario: {
            id: usuario
        },
        prioridad: {
            prioridadID: prioridad
        },
        estado: {
            estadoID: estado
        }
    }
    $.ajax({
        url:"http://localhost:8080/incidencia/actualizar",
        type:"PUT",
        data: JSON.stringify(data),
        contentType:"application/json",
        success: function(){
            $("#actualizarModal").modal("hide");
            $('#idAC').val('')
            $("#nombreAC").val('');
            $("#ubicacionAC").val('');
            $("#descripcionAC").val('');
            findAll()
        },
        error: function(xhr) {
        }  
    })
}

function eliminarIncidencia(noIncidencia){
    console.log(noIncidencia)
    $("#confirmarEliminacion").off("click").on("click", function(){
        $.ajax({
            url: "http://localhost:8080/incidencia/delete/"+noIncidencia,
            type: "DELETE",
            success: function(){
                $("#tableid tbody").find("td:contains('" + noIncidencia + "')").closest("tr").remove();
                $("#exampleModal").modal("hide");   
            }
        })
    })
}
function cargarDatos(noIncidencia){
    console.log(noIncidencia)
    $.ajax({
        url: "http://localhost:8080/incidencia/"+ noIncidencia,
        type: "GET",
        dataType: "json",
        success: function(respuesta){
            $("#idAC").val(respuesta.incidenciaID)
            $("#idAC").prop("disabled", true)
            $("#nombreAC").val(respuesta.nombreIncidencia);
            $("#descripcionAC").val(respuesta.descripcion);
            $("#ubicacionAC").val(respuesta.ubicacion);
        }
    })
}

document.getElementById("byid").addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        buscarIncidenciaId(); 
    }
});
$(document).ready(function() {
    $("#asignarRolesAutomaticamenteBtn").on("click", function() {
        $.ajax({
            url: "http://localhost:8080/asignar-roles/automatica",
            type: "POST",
            success: function() {
                alert("Roles asignados automáticamente con éxito.");
            },
            error: function(xhr) {
                alert("Error al asignar roles automáticamente.");
            }
        });
    });
});
function actualizarNivel1Prioridad1() {
    // Llama a la función correspondiente en tu controlador de Spring
    // Puedes utilizar AJAX para hacer la llamada.
    // Aquí hay un ejemplo de cómo hacerlo con jQuery:
    $.ajax({
        url: 'http://localhost:8080/incidencia/actualizarIncidenciasNivel1Prioridad1',
        type: 'POST',
        success: function(response) {
            alert(response);
        },
        error: function(error) {
            alert('Error al actualizar las incidencias.');
        }
    });
}

function actualizarNivel2Prioridad2() {
    // Llama a la función correspondiente en tu controlador de Spring
    // Puedes utilizar AJAX para hacer la llamada.
    // Aquí hay un ejemplo de cómo hacerlo con jQuery:
    $.ajax({
        url: 'http://localhost:8080/incidencia/actualizarIncidenciasNivel2Prioridad2',
        type: 'POST',
        success: function(response) {
            alert(response);
        },
        error: function(error) {
            alert('Error al actualizar las incidencias.');
        }
    });
}
function actualizarNivel3Prioridad3() {
    // Llama a la función correspondiente en tu controlador de Spring
    // Puedes utilizar AJAX para hacer la llamada.
    // Aquí hay un ejemplo de cómo hacerlo con jQuery:
    $.ajax({
        url: 'http://localhost:8080/incidencia/actualizarIncidenciasNivel3Prioridad3',
        type: 'POST',
        success: function(response) {
            alert(response);
        },
        error: function(error) {
            alert('Error al actualizar las incidencias.');
        }
    });
}

function actualizarNivel4Prioridad4() {
    // Llama a la función correspondiente en tu controlador de Spring
    // Puedes utilizar AJAX para hacer la llamada.
    // Aquí hay un ejemplo de cómo hacerlo con jQuery:
    $.ajax({
        url: 'http://localhost:8080/incidencia/actualizarIncidenciasNivel4Prioridad4',
        type: 'POST',
        success: function(response) {
            alert(response);
        },
        error: function(error) {
            alert('Error al actualizar las incidencias.');
        }
    });
}
