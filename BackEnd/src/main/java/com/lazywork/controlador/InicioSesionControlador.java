package com.lazywork.controlador;

import com.lazywork.entidad.InicioSesion;
import com.lazywork.servicios.InicioSesionServicios;
import com.lazywork.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======

>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/iniciosesion")
<<<<<<< HEAD
@CrossOrigin(origins = "http://127.0.0.1:5500") // Cambia esto al origen de tu sitio web
=======
<<<<<<< HEAD
@CrossOrigin("*")
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
public class InicioSesionControlador {
=======
<<<<<<< HEAD
@CrossOrigin("*")
public class InicioSesionControlador {

    private final InicioSesionServicios inicioSesionServicios;
    private final UsuarioServicio usuarioServicio;

    @Autowired
    public InicioSesionControlador(InicioSesionServicios inicioSesionServicios, UsuarioServicio usuarioServicio) {
        this.inicioSesionServicios = inicioSesionServicios;
        this.usuarioServicio = usuarioServicio;
=======
public class InicioSesionControlador {
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    private final InicioSesionServicios inicioSesionServicios;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    public InicioSesionControlador(InicioSesionServicios inicioSesionServicios) {
        this.inicioSesionServicios = inicioSesionServicios;
<<<<<<< HEAD
=======
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    }


    @GetMapping("/buscarporid/{id}")
    public ResponseEntity<InicioSesion> findInicioSesionById(@PathVariable Long id) {
        Optional<InicioSesion> inicioSesion = inicioSesionServicios.findInicioSesionById(id);
        return inicioSesion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<InicioSesion>> listarIniciosSesion() {
        List<InicioSesion> iniciosSesion = inicioSesionServicios.listaIniciosSesion();
        return new ResponseEntity<>(iniciosSesion, HttpStatus.OK);
    }

    @PostMapping("/insertar")
<<<<<<< HEAD

    public ResponseEntity<?> insertarInicioSesion(@RequestBody InicioSesion inicioSesion) {
        if (inicioSesion.getUsuario() == null) {
=======
    public ResponseEntity<?> insertarInicioSesion(@RequestBody InicioSesion inicioSesion) {
<<<<<<< HEAD
        if (inicioSesion.getUsuario() == null || inicioSesion.getUsuario().getId() == null) {
=======
        if (inicioSesion.getUsuario() == null) {
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
            return new ResponseEntity<>("El usuario no puede ser nulo", HttpStatus.BAD_REQUEST);
        }

        Long usuarioId = inicioSesion.getUsuario().getId();
<<<<<<< HEAD
        if (usuarioId != null && usuarioServicio.existeUsuario(usuarioId)) {
=======
<<<<<<< HEAD
        if (usuarioServicio.existeUsuario(usuarioId)) {
=======
        if (usuarioId != null && usuarioServicio.existeUsuario(usuarioId)) {
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
            inicioSesion.setTiempodesesion(LocalDateTime.now()); // Establece el valor del tiempo de sesión
            InicioSesion nuevoInicioSesion = inicioSesionServicios.insertarInicioSesion(inicioSesion);
            if (nuevoInicioSesion != null) {
                return new ResponseEntity<>(nuevoInicioSesion, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("No se pudo crear el inicio de sesión", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("El usuario no existe", HttpStatus.BAD_REQUEST);
        }
    }
<<<<<<< HEAD
=======

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarInicioSesion(
            @PathVariable Long id,
            @RequestBody InicioSesion inicioSesionActualizado
    ) {
        // Verificar si el inicio de sesión con el ID especificado existe
        if (inicioSesionServicios.existeInicioSesion(id)) {
            // Realizar la actualización
            InicioSesion inicioSesion = inicioSesionServicios.actualizarInicioSesion(id, inicioSesionActualizado);
            if (inicioSesion != null) {
                return ResponseEntity.ok(inicioSesion);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el inicio de sesión");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inicio de sesión no encontrado");
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarInicio(@PathVariable Long id) {
        if (inicioSesionServicios.existeInicioSesion(id)) {
            inicioSesionServicios.eliminarInicio(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
