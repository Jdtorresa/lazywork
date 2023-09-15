package com.lazywork.controlador;

import com.lazywork.entidad.Usuario;
import com.lazywork.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
<<<<<<< HEAD
@CrossOrigin("*")
=======
@CrossOrigin(origins = "http://127.0.0.1:5500")
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
 // Cambia esto al origen de tu sitio web
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
<<<<<<< HEAD
=======


>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@Validated @RequestBody Usuario nuevoUsuario, BindingResult result) {
        // Verifica si hay errores de validación
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        // Resto de la lógica para crear y guardar el usuario
        Usuario usuarioGuardado = usuarioServicio.save(nuevoUsuario);
        return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);
    }
<<<<<<< HEAD
    @GetMapping("/buscarporid/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable String id) {
        Optional<Usuario> usuario = usuarioServicio.findById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> findAll() {
        return new ResponseEntity<>(usuarioServicio.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Optional<Usuario> usuario = usuarioServicio.findById(id);
        if (usuario.isPresent()) {
            usuarioServicio.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
=======

        @GetMapping("/buscarporid/{id}")
        public ResponseEntity<Usuario> findById(@PathVariable String id) {
            Optional<Usuario> usuario = usuarioServicio.findById(id);
            return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @GetMapping("/listar")
        public ResponseEntity<List<Usuario>> findAll() {
            return new ResponseEntity<>(usuarioServicio.findAll(), HttpStatus.OK);
        }

        @DeleteMapping("/eliminar/{id}")
        public ResponseEntity<Void> delete(@PathVariable String id) {
            Optional<Usuario> usuario = usuarioServicio.findById(id);
            if (usuario.isPresent()) {
                usuarioServicio.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuarioActualizado, @PathVariable String id) {
        try {
            Usuario usuarioGuardado = usuarioServicio.actualizarUsuario(id, usuarioActualizado);
            return new ResponseEntity<>(usuarioGuardado, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }}