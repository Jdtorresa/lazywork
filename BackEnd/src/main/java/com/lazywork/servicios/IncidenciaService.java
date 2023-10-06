package com.lazywork.servicios;

import com.lazywork.entidad.Incidencia;
import com.lazywork.repositorio.EstadosIncidenciasCrudRepository;
import com.lazywork.repositorio.IncidenciaCrudRepository;
import com.lazywork.repositorio.PrioridadesIncidenciasCrudRepository;
import com.lazywork.repositorio.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class
IncidenciaService {

    @Autowired
    private IncidenciaCrudRepository incidenciaRepository;

    private EstadosIncidenciasCrudRepository estadosIncidenciasCrudRepository;
     private PrioridadesIncidenciasCrudRepository prioridadesIncidenciasCrudRepository;
     private UsuarioCrudRepository usuarioCrudRepository;


    public List<Incidencia> obtenerTodasLasIncidencias() {
        return (List<Incidencia>) incidenciaRepository.findAll();
    }

    public Optional<Incidencia> obtenerIncidenciaPorId(Long id) {
        return incidenciaRepository.findById((id));
    }

    public Incidencia crearIncidencia(Incidencia incidencia) {

        incidencia.setEstado(estadosIncidenciasCrudRepository.findById(incidencia.getEstado().getEstadoID()).get());
        incidencia.setPrioridad(prioridadesIncidenciasCrudRepository.findById(incidencia.getPrioridad().getPrioridadID()).get());
        incidencia.setUsuario(usuarioCrudRepository.findById(incidencia.getUsuario().getId()).get());
        incidencia.setFechaRegistro(LocalDate.now());

        return incidenciaRepository.save(incidencia);
    }

    public Incidencia actualizarIncidencia(Incidencia incidencia) {

        return incidenciaRepository.save(incidencia);
    }

    public void eliminarIncidencia(Long id) {
        incidenciaRepository.deleteById(id);
    }
}
