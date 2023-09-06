package com.lazywork.controlador;

import com.lazywork.entidad.RolUsuario;
import com.lazywork.servicios.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario-rol")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService servicioUR;

    @GetMapping
    public ResponseEntity<List<RolUsuario>> obtenerTodosLosUsuarioRoles() {
        List<RolUsuario> usuarioRoles = servicioUR.obtenerTodosLosUsuarioRoles();
        return ResponseEntity.ok(usuarioRoles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolUsuario> obtenerUsuarioRolesPorId(@PathVariable String id) {
        Optional<RolUsuario> usuarioRoles = servicioUR.obtenerUsuarioRolesPorId(id);
        if (usuarioRoles.isPresent()) {
            return ResponseEntity.ok(usuarioRoles.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RolUsuario> crearUsuarioRoles(@RequestBody RolUsuario usuarioRoles) {
        RolUsuario usuarioRolesCreado = servicioUR.crearUsuarioRoles(usuarioRoles);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRolesCreado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioRoles(@PathVariable String id) {
        servicioUR.eliminarUsuarioRoles(id);
        return ResponseEntity.noContent().build();
    }
}
