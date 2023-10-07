    package com.lazywork.controlador;

<<<<<<< HEAD
    import com.lazywork.entidad.Usuario;
    import com.lazywork.repositorio.UsuarioCrudRepository;
    import com.lazywork.servicios.UsuarioServicio;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.validation.BindingResult;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.*;

=======
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
<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
<<<<<<< HEAD
@CrossOrigin("*")
=======
<<<<<<< HEAD
@CrossOrigin("*")
=======
@CrossOrigin(origins = "http://127.0.0.1:5500")
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
 // Cambia esto al origen de tu sitio web
public class UsuarioControlador {
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3

    import java.util.List;
    import java.util.NoSuchElementException;
    import java.util.Optional;

<<<<<<< HEAD
    @RestController
    @RequestMapping("/api/usuario")
    @CrossOrigin(origins = "http://127.0.0.1:5500") // Cambia esto al origen de tu sitio web
    public class UsuarioControlador {

        private final UsuarioServicio usuarioServicio;
        @Autowired
        private UsuarioCrudRepository usuarioRepository;
        @Autowired
        public UsuarioControlador(UsuarioServicio usuarioServicio) {
            this.usuarioServicio = usuarioServicio;
        }

        @PostMapping("/crear")
        public ResponseEntity<?> crearUsuario(@Validated @RequestBody Usuario nuevoUsuario, BindingResult result) {
            // Verifica si hay errores de validación
            if (result.hasErrors()) {
                return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
            }
=======
    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======


>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
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
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    @GetMapping("/buscarporid/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable String id) {
        Optional<Usuario> usuario = usuarioServicio.findById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3

            // Resto de la lógica para crear y guardar el usuario
            Usuario usuarioGuardado = usuarioServicio.save(nuevoUsuario);
            return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);
        }
<<<<<<< HEAD
=======
    }
<<<<<<< HEAD
=======
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
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3

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
        public ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
            try {
                // Obtener el usuario que deseas eliminar
                Usuario usuario = usuarioRepository.findById(id).orElse(null);

                if (usuario != null) {
                    // Eliminar el usuario y sus registros relacionados en inicios_sesion
                    usuarioRepository.delete(usuario);
                    return new ResponseEntity<>(HttpStatus.OK); // Usuario eliminado exitosamente
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Usuario no encontrado
                }
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Otro error
            }
        }

        @PutMapping("/actualizar/{id}")
        public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuarioActualizado, @PathVariable String id) {
            try {
                Usuario usuarioGuardado = usuarioServicio.actualizarUsuario(id, usuarioActualizado);
                return new ResponseEntity<>(usuarioGuardado, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }}

