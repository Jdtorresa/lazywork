package com.lazywork.servicios;


import com.lazywork.entidad.CambioEstado;
import com.lazywork.repositorio.CambioEstadoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CambioEstadoService {

    @Autowired
    private CambioEstadoCrudRepository cambioEstadoRepository;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======


>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    public List<CambioEstado> obtenerTodosLosCambioEstado() {
        return (List<CambioEstado>) cambioEstadoRepository.findAll();
    }

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
        return cambioEstadoRepository.save(cambioEstado);
    }

    public void eliminarCambioEstado(Long id) {
        cambioEstadoRepository.deleteById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    }
}

