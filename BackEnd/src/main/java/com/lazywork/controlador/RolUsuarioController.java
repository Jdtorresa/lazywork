package com.lazywork.controlador;

import com.lazywork.entidad.RolUsuario;
import com.lazywork.servicios.RolUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rolusuario")
public class RolUsuarioController {

    @Autowired
    private RolUsuarioService servicioRDU;

    public RolUsuarioController(RolUsuarioService servicioRDU) {
        this.servicioRDU = servicioRDU;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<RolUsuario>> findAll() {
        List<RolUsuario> rolUsuario = servicioRDU.findAll();
        return ResponseEntity.ok(rolUsuario);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<RolUsuario> findById(@PathVariable String id) {
        Optional<RolUsuario> usuarioRoles = servicioRDU.findByID(id);
        if (usuarioRoles.isPresent()) {
            return ResponseEntity.ok(usuarioRoles.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<RolUsuario> save(@RequestBody RolUsuario rolUsuario) {
        RolUsuario usuarioRolesCreado = servicioRDU.save(rolUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRolesCreado);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        servicioRDU.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
