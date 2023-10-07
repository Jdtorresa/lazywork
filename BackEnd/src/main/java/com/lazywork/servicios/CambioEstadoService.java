package com.lazywork.servicios;

import com.lazywork.entidad.CambioEstado;
import com.lazywork.repositorio.CambioEstadoCrudRepository;
import com.lazywork.repositorio.EstadosIncidenciasCrudRepository;
import com.lazywork.repositorio.IncidenciaCrudRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CambioEstadoService {

    private  CambioEstadoCrudRepository cambioEstadoRepository;
    private  IncidenciaCrudRepository incidenciaCrudRepository;
    private  EstadosIncidenciasCrudRepository estadosIncidenciasCrudRepository;

    @Autowired
<<<<<<< HEAD
    private CambioEstadoCrudRepository cambioEstadoRepository;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05

    public CambioEstadoService(CambioEstadoCrudRepository cambioEstadoCrudRepository, IncidenciaCrudRepository incidenciaCrudRepository, EstadosIncidenciasCrudRepository estadosIncidenciasCrudRepository) {
        this.cambioEstadoRepository = cambioEstadoCrudRepository;
        this.incidenciaCrudRepository = incidenciaCrudRepository;
        this.estadosIncidenciasCrudRepository = estadosIncidenciasCrudRepository;
    }

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    public List<CambioEstado> obtenerTodosLosCambioEstado() {
        return (List<CambioEstado>) cambioEstadoRepository.findAll();
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public Optional<CambioEstado> obtenerCambioEstadoPorId(String id) {
        return cambioEstadoRepository.findById(id);
=======
<<<<<<< HEAD
    public Optional<CambioEstado> obtenerCambioEstadoPorId(String id) {
        return cambioEstadoRepository.findById(id);
=======
    public Optional<CambioEstado> obtenerCambioEstadoPorId(Long id) {
        return cambioEstadoRepository.findById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    }

    public CambioEstado crearCambioEstado(CambioEstado cambioEstado) {
        return cambioEstadoRepository.save(cambioEstado);
    }

<<<<<<< HEAD
    public void eliminarCambioEstado(String id) {
        cambioEstadoRepository.deleteById(id);
=======
<<<<<<< HEAD
    public void eliminarCambioEstado(String id) {
        cambioEstadoRepository.deleteById(id);
=======
    public CambioEstado actualizarCambioEstado(CambioEstado cambioEstado){
=======

    public Optional<CambioEstado> obtenerCambioEstadoPorId(Long id) {
        return cambioEstadoRepository.findById(id);}




    public CambioEstado crearCambioEstado(CambioEstado cambioEstado) {
        cambioEstado.setIncidencia(incidenciaCrudRepository.findById(cambioEstado.getIncidencia().getIncidenciaID()).get());
        cambioEstado.setEstado(estadosIncidenciasCrudRepository.findById(cambioEstado.getEstado().getEstadoID()).get());
        cambioEstado.setFechaRegistro(LocalDate.now());
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
        return cambioEstadoRepository.save(cambioEstado);
    }

    public void eliminarCambioEstado(Long id) {
<<<<<<< HEAD
        cambioEstadoRepository.deleteById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
        cambioEstadoRepository.deleteById(id);
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    }
}
