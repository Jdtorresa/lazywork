package com.lazywork.controlador;

import com.lazywork.entidad.CambioEstado;
import com.lazywork.servicios.CambioEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
<<<<<<< HEAD
@RequestMapping("/cambio-estado")
<<<<<<< HEAD
@CrossOrigin("*")
=======
<<<<<<< HEAD
@CrossOrigin("*")
=======
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
@RequestMapping("/cambioestado")
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
public class CambioEstadoController {

    @Autowired
    private CambioEstadoService cambioEstadoService;

<<<<<<< HEAD
    @GetMapping
    public ResponseEntity<List<CambioEstado>> obtenerTodosLosCambioEstado() {
=======
<<<<<<< HEAD
    @GetMapping
    public ResponseEntity<List<CambioEstado>> obtenerTodosLosCambioEstado() {
=======
    @GetMapping("/listar")
    public ResponseEntity<List<CambioEstado>> obtenerTodasLosCambioEstado() {
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
        List<CambioEstado> cambioEstado = cambioEstadoService.obtenerTodosLosCambioEstado();
        return ResponseEntity.ok(cambioEstado);
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    public ResponseEntity<CambioEstado> obtenerCambioEstadoPorId(@PathVariable String id) {
        Optional<CambioEstado> cambioEstado = cambioEstadoService.obtenerCambioEstadoPorId(id);
        if (cambioEstado.isPresent()) {
            return ResponseEntity.ok(cambioEstado.get());
<<<<<<< HEAD
=======
=======
    public ResponseEntity<CambioEstado> obtenerCambioestadoPorId(@PathVariable Long id) {
        Optional<CambioEstado> cambioestado = cambioEstadoService.obtenerCambioEstadoPorId(id);
        if (cambioestado.isPresent()) {
            return ResponseEntity.ok(cambioestado.get());
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
    public ResponseEntity<CambioEstado> obtenerCambioEstadoPorId(@PathVariable Long id) {
        Optional<CambioEstado> cambioEstado = cambioEstadoService.obtenerCambioEstadoPorId(id);
        if (cambioEstado.isPresent()) {
            return ResponseEntity.ok(cambioEstado.get());
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
        } else {
            return ResponseEntity.notFound().build();
        }
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    @PostMapping
    public ResponseEntity<CambioEstado> crearCambioEstado(@RequestBody CambioEstado cambioEstado) {
        CambioEstado cambioEstadoCreado = cambioEstadoService.crearCambioEstado(cambioEstado);
        return ResponseEntity.status(HttpStatus.CREATED).body(cambioEstadoCreado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCambioEstado(@PathVariable String id) {
<<<<<<< HEAD
=======
=======
    @PostMapping("/crear")
    public ResponseEntity<CambioEstado> crearCambioEstado(@RequestBody CambioEstado cambioEstadoB) {
        cambioEstadoService.crearCambioEstado(cambioEstadoB);
        return ResponseEntity.ok(cambioEstadoB);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CambioEstado> actualizarCambioEstado(@PathVariable Long id, @RequestBody CambioEstado cambioEstadoB) {
        Optional<CambioEstado> cambioEstado = cambioEstadoService.obtenerCambioEstadoPorId(cambioEstadoB.getCambioEstadoID());
        if (cambioEstado.isPresent()) {
            cambioEstadoService.crearCambioEstado( cambioEstadoB);
            return ResponseEntity.ok(cambioEstado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

<<<<<<< HEAD
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> eliminarcambioEstado(@PathVariable Long id) {
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCambioEstado(@PathVariable Long id) {
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
        cambioEstadoService.eliminarCambioEstado(id);
        return ResponseEntity.noContent().build();
    }
}