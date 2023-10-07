package com.lazywork.controlador;
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
import com.lazywork.entidad.Rol;
import com.lazywork.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
@CrossOrigin("*")
public class RolController {

    @Autowired
    private RolService servRol;

    public RolController(RolService servRol) {
        this.servRol = servRol;
<<<<<<< HEAD
=======
=======
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
@CrossOrigin("*")
public class RolController {

    @Autowired
<<<<<<< HEAD
    public RolController(RolService servicioRol) {
        this.servicioR = servicioRol;
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
    private RolService servRol;

    public RolController(RolService servRol) {
        this.servRol = servRol;
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Rol>> findAll() {
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
        if(servRol.finAll().isEmpty()){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.ok(servRol.finAll());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Rol> findById(@PathVariable String id) {
        Optional<Rol> rol = servRol.findById(id);
        if (rol.isPresent()) {
            return ResponseEntity.ok(rol.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Rol> save(@RequestBody Rol rol) {
        if(servRol.existsById(String.valueOf(rol.getRolID())) == false){
            servRol.save(rol);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PutMapping("/re_save")
    public ResponseEntity<Rol> re_save(@RequestBody Rol rol) {
        if(servRol.existsById(String.valueOf(rol.getRolID()))){
            servRol.save(rol);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        if(servRol.existsById(id)){
            if(servRol.existsInUsuarioRol(id)){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }else{
                servRol.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }else{
            return ResponseEntity.notFound().build();
        }
<<<<<<< HEAD
=======
=======
        respuesta.clear();
        status = HttpStatus.OK;
        if(!servicioR.findAll().isEmpty()){
            respuesta.add(servicioR.findAll());
            return new ResponseEntity<>(respuesta, status);
=======
        if(servRol.finAll().isEmpty()){
            return ResponseEntity.ok().build();
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
        }else{
            return ResponseEntity.ok(servRol.finAll());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Rol> findById(@PathVariable String id) {
        Optional<Rol> rol = servRol.findById(id);
        if (rol.isPresent()) {
            return ResponseEntity.ok(rol.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Rol> save(@RequestBody Rol rol) {
        if(servRol.existsById(String.valueOf(rol.getRolID())) == false){
            servRol.save(rol);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PutMapping("/re_save")
    public ResponseEntity<Rol> re_save(@RequestBody Rol rol) {
        if(servRol.existsById(String.valueOf(rol.getRolID()))){
            servRol.save(rol);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        if(servRol.existsById(id)){
            if(servRol.existsInUsuarioRol(id)){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }else{
                servRol.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }else{
            return ResponseEntity.notFound().build();
        }
<<<<<<< HEAD
        else{
            respuesta.add("Imposible eliminar, el rol no existe");
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(respuesta, status);
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    }
}
