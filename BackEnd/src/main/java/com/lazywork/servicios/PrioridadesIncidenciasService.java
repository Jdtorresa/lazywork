package com.lazywork.servicios;

import com.lazywork.entidad.PrioridadIncidencia;

import com.lazywork.repositorio.PrioridadesIncidenciasCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrioridadesIncidenciasService {

    @Autowired
    private PrioridadesIncidenciasCrudRepository prioridadesIncidenciasCrudRepository;

    public List<PrioridadIncidencia> obtenerTodasLasPrioridadesIncidencias() {
        return (List<PrioridadIncidencia>) prioridadesIncidenciasCrudRepository.findAll();
    }

    public Optional<PrioridadIncidencia> obtenerPrioridadesIncidenciasPorId(Long id) {
        return prioridadesIncidenciasCrudRepository.findById(String.valueOf(id));
    }

    public PrioridadIncidencia crearPrioridadesIncidencias(PrioridadIncidencia prioridadesIncidencias) {
        return prioridadesIncidenciasCrudRepository.save(prioridadesIncidencias);
    }

    public PrioridadIncidencia actualizarPrioridadesIncidencias(PrioridadIncidencia prioridadesIncidencias) {
        return prioridadesIncidenciasCrudRepository.save(prioridadesIncidencias);
    }

    public void eliminarPrioridadesIncidencias(Long id) {
        prioridadesIncidenciasCrudRepository.deleteById(String.valueOf(id));
    }
}