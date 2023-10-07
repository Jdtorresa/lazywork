    package com.lazywork.controlador;

    import com.lazywork.entidad.Usuario;
    import com.lazywork.repositorio.UsuarioCrudRepository;
    import com.lazywork.servicios.UsuarioServicio;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.validation.BindingResult;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.*;


    import java.util.List;
    import java.util.NoSuchElementException;
    import java.util.Optional;

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

            // Resto de la lógica para crear y guardar el usuario
            Usuario usuarioGuardado = usuarioServicio.save(nuevoUsuario);
            return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);
        }

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

