package com.lazywork.controlador;

import com.lazywork.entidad.Incidencia;
import com.lazywork.servicios.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incidencia")
<<<<<<< HEAD
<<<<<<< HEAD
@CrossOrigin(origins = "http://127.0.0.1:5500") // Cambia esto al origen de tu sitio web
=======
<<<<<<< HEAD
@CrossOrigin("*")
=======
<<<<<<< HEAD
@CrossOrigin("*")
=======
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
=======
@CrossOrigin("*")
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping("/lisar")
    public ResponseEntity<List<Incidencia>> obtenerTodasLasIncidencias() {
        List<Incidencia> incidencias = incidenciaService.obtenerTodasLasIncidencias();
        return ResponseEntity.ok(incidencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> obtenerIncidenciaPorId(@PathVariable Long id) {
        Optional<Incidencia> incidencia = incidenciaService.obtenerIncidenciaPorId(id);
        if (incidencia.isPresent()) {
            return ResponseEntity.ok(incidencia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Incidencia> crearIncidencia(@RequestBody Incidencia incidencia) {
        Incidencia incidenciaCreada = incidenciaService.crearIncidencia(incidencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(incidenciaCreada);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Incidencia> actualizarIncidencia(@PathVariable Long id, @RequestBody Incidencia incidencia) {
        Optional<Incidencia> incidenciaActual = incidenciaService.obtenerIncidenciaPorId(id);
        if (incidenciaActual.isPresent()) {
            incidencia.setId(id);
            Incidencia incidenciaActualizada = incidenciaService.actualizarIncidencia(incidencia);
            return ResponseEntity.ok(incidenciaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarIncidencia(@PathVariable Long id) {
        incidenciaService.eliminarIncidencia(id);
        return ResponseEntity.noContent().build();
    }
}
