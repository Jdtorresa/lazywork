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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
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
<<<<<<< HEAD
=======
=======
    private EstadosIncidenciasCrudRepository estadosIncidenciasCrudRepository;
=======
    private EstadosIncidenciasCrudRepository estadosIncidenciasRepository;
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05

    public List<EstadoIncidencia> obtenerTodosLosEstadosIncidencias() {
        return (List<EstadoIncidencia>) estadosIncidenciasRepository.findAll();
    }

    public Optional<EstadoIncidencia> obtenerEstadosIncidenciasPorId(Long id) {
        return estadosIncidenciasRepository.findById((id));
    }

    public EstadoIncidencia crearEstadosIncidencias(EstadoIncidencia estadosIncidencias) {
        return estadosIncidenciasRepository.save(estadosIncidencias);
    }

    public EstadoIncidencia actualizarEstadosIncidencias(EstadoIncidencia estadosIncidencias) {
        return estadosIncidenciasRepository.save(estadosIncidencias);
    }

    public void eliminarEstadosIncidencias(Long id) {
<<<<<<< HEAD
        estadosIncidenciasCrudRepository.deleteById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
        estadosIncidenciasRepository.deleteById(id);
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    }
}
