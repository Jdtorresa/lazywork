package com.lazywork.servicios;

import com.lazywork.entidad.EstadoIncidencia;
import com.lazywork.repositorio.EstadosIncidenciasCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadosIncidenciasService {

    @Autowired
<<<<<<< HEAD
    private EstadosIncidenciasCrudRepository estadosIncidenciasRepository;

    public List<EstadoIncidencia> obtenerTodosLosEstadosIncidencias() {
        return (List<EstadoIncidencia>) estadosIncidenciasRepository.findAll();
    }

    public Optional<EstadoIncidencia> obtenerEstadosIncidenciasPorId(Long id) {
        return estadosIncidenciasRepository.findById(String.valueOf(id));
    }

    public EstadoIncidencia crearEstadosIncidencias(EstadoIncidencia estadosIncidencias) {
        return estadosIncidenciasRepository.save(estadosIncidencias);
    }

    public EstadoIncidencia actualizarEstadosIncidencias(EstadoIncidencia estadosIncidencias) {
        return estadosIncidenciasRepository.save(estadosIncidencias);
    }

    public void eliminarEstadosIncidencias(Long id) {
        estadosIncidenciasRepository.deleteById(String.valueOf(id));
=======
    private EstadosIncidenciasCrudRepository estadosIncidenciasCrudRepository;



    public List<EstadoIncidencia> obtenerTodasLosEstadosIncidencias() {
        return (List<EstadoIncidencia>) estadosIncidenciasCrudRepository.findAll();
    }

    public Optional<EstadoIncidencia> obtenerEstadosIncidenciasPorId(Long id) {
        return estadosIncidenciasCrudRepository.findById(String.valueOf(id));
    }

    public EstadoIncidencia crearEstadosIncidencias(EstadoIncidencia estadosIncidencias) {
        return estadosIncidenciasCrudRepository.save(estadosIncidencias);
    }

    public EstadoIncidencia actualizarEstadosIncidencias(EstadoIncidencia estadosIncidencias) {
        return estadosIncidenciasCrudRepository.save(estadosIncidencias);
    }

    public void eliminarEstadosIncidencias(Long id) {
        estadosIncidenciasCrudRepository.deleteById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
    }
}
