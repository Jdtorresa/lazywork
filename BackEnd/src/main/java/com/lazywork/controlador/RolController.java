package com.lazywork.controlador;
<<<<<<< HEAD
import com.lazywork.entidad.Rol;
import com.lazywork.servicios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
=======



        import com.lazywork.entidad.Rol;
        import com.lazywork.entidad.Usuario;
        import com.lazywork.servicios.RolService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    private RolService servicioR;
    private HttpStatus status;
    private ArrayList respuesta = new ArrayList<>();
    @Autowired
    public RolController(RolService servicioRol) {
        this.servicioR = servicioRol;
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Rol>> findAll() {
<<<<<<< HEAD
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
=======
        respuesta.clear();
        status = HttpStatus.OK;
        if(!servicioR.findAll().isEmpty()){
            respuesta.add(servicioR.findAll());
            return new ResponseEntity<>(respuesta, status);
        }else{
            return new ResponseEntity<>(status);
        }

    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ArrayList> findById(@PathVariable Long id) {
        respuesta.clear();
        if (servicioR.existsById(Long.valueOf(id))) {
            respuesta.add(servicioR.findById(id).get());
            status = HttpStatus.OK;
        } else {
            respuesta.add("No se encontro el rol");
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(respuesta, status);
    }

    @PostMapping("/save")
    public ResponseEntity<ArrayList> save(@RequestBody Rol rol) {
        respuesta.clear();
        if(servicioR.existsById(rol.getRolID()) == false){
            servicioR.save(rol);
            respuesta.add("Se ha creado el rol exitosamente");
            status = HttpStatus.CREATED;

        }
        else{
            respuesta.add("El rol ya existe");
            status = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(respuesta, status);
    }


    @PutMapping("/re_save")
    public ResponseEntity<ArrayList> re_save(@RequestBody Rol rol) {
        respuesta.clear();
        if(servicioR.existsById(rol.getRolID())){
            servicioR.save(rol);
            respuesta.add("Se ha actualizado correctamente");
            status = HttpStatus.OK;
        }
        else{
            respuesta.add("El rol a actualizar no existe");
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(respuesta, status);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ArrayList> deleteById(@PathVariable Long id) {
        respuesta.clear();
        if(servicioR.existsById(Long.valueOf(id))){
            servicioR.deleteById(id);
            respuesta.add("Se elimino correctamente");
            status = HttpStatus.OK;
        }
        else{
            respuesta.add("Imposible eliminar, el rol no existe");
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(respuesta, status);
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
    }
}
