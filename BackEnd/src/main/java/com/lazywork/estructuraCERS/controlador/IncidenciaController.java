package com.lazywork.estructuraCERS.controlador;

import com.lazywork.estructuraCERS.entidad.Incidencia;
import com.lazywork.estructuraCERS.servicios.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/incidencia")
@CrossOrigin("*")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping("/listar")
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

    @PutMapping("/actualizar")
    public ResponseEntity<Incidencia> actualizarIncidencia( @RequestBody Incidencia incidencia) {
        Optional<Incidencia> incidenciaActual = incidenciaService.obtenerIncidenciaPorId(incidencia.getIncidenciaID());
        if (incidenciaActual.isPresent()) {
            incidencia.setId(incidencia.getIncidenciaID());
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
