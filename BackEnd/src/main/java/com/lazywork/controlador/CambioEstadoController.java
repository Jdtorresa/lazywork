package com.lazywork.controlador;


import com.lazywork.entidad.CambioEstado;
import com.lazywork.servicios.CambioEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cambio-estado")
<<<<<<< HEAD
@CrossOrigin("*")
=======
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
public class CambioEstadoController {

    @Autowired
    private CambioEstadoService cambioEstadoService;

<<<<<<< HEAD
    @GetMapping
    public ResponseEntity<List<CambioEstado>> obtenerTodosLosCambioEstado() {
=======
    @GetMapping("/listar")
    public ResponseEntity<List<CambioEstado>> obtenerTodasLosCambioEstado() {
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
        List<CambioEstado> cambioEstado = cambioEstadoService.obtenerTodosLosCambioEstado();
        return ResponseEntity.ok(cambioEstado);
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<CambioEstado> obtenerCambioEstadoPorId(@PathVariable String id) {
        Optional<CambioEstado> cambioEstado = cambioEstadoService.obtenerCambioEstadoPorId(id);
        if (cambioEstado.isPresent()) {
            return ResponseEntity.ok(cambioEstado.get());
=======
    public ResponseEntity<CambioEstado> obtenerCambioestadoPorId(@PathVariable Long id) {
        Optional<CambioEstado> cambioestado = cambioEstadoService.obtenerCambioEstadoPorId(id);
        if (cambioestado.isPresent()) {
            return ResponseEntity.ok(cambioestado.get());
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
        } else {
            return ResponseEntity.notFound().build();
        }
    }

<<<<<<< HEAD
    @PostMapping
    public ResponseEntity<CambioEstado> crearCambioEstado(@RequestBody CambioEstado cambioEstado) {
        CambioEstado cambioEstadoCreado = cambioEstadoService.crearCambioEstado(cambioEstado);
        return ResponseEntity.status(HttpStatus.CREATED).body(cambioEstadoCreado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCambioEstado(@PathVariable String id) {
=======
    @PostMapping("/crear")
    public ResponseEntity<CambioEstado> crearCambioestado(@RequestBody CambioEstado cambioEstado) {
        CambioEstado cambioestadoCreado = cambioEstadoService.crearCambioEstado(cambioEstado);
        return ResponseEntity.status(HttpStatus.CREATED).body(cambioestadoCreado);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CambioEstado> actualizarCambioestado(@PathVariable Long id, @RequestBody CambioEstado cambioEstado){
        Optional<CambioEstado> cambioestadoActual = cambioEstadoService.obtenerCambioEstadoPorId((id));
        if (cambioestadoActual.isPresent()) {
            cambioEstado.setId(id);
            CambioEstado cambioestadoActualizado = cambioEstadoService.actualizarCambioEstado(cambioEstado);
            return ResponseEntity.ok(cambioestadoActualizado);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> eliminarcambioEstado(@PathVariable Long id) {
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
        cambioEstadoService.eliminarCambioEstado(id);
        return ResponseEntity.noContent().build();
    }
}
