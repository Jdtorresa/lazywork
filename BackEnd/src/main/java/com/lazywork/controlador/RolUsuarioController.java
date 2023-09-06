package com.lazywork.controlador;

import com.lazywork.entidad.RolUsuario;
import com.lazywork.servicios.RolService;
import com.lazywork.servicios.RolUsuarioService;
import com.lazywork.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rolusuario")
@CrossOrigin("*")
public class RolUsuarioController {

    private RolUsuarioService servicioRU;

    @Autowired
    public RolUsuarioController(RolUsuarioService servicioRU) {
        this.servicioRU = servicioRU;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<RolUsuario>> findAll() {
        return new ResponseEntity<>(servicioRU.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<RolUsuario>> findById(@PathVariable String id) {
        if (servicioRU.existsById(id)) {
            return new ResponseEntity<>(servicioRU.findByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<RolUsuario> save(@RequestBody RolUsuario rolUsuario) {
        if(servicioRU.existsById(String.valueOf(rolUsuario.getUsuario().getUsuarioID()))){
            if(servicioRU.existsById(String.valueOf(findById(String.valueOf(rolUsuario.getUsuario().getUsuarioID()))))){
                servicioRU.save(rolUsuario);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        servicioRU.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
