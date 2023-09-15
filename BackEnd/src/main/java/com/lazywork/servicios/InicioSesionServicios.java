package com.lazywork.servicios;
import com.lazywork.entidad.InicioSesion;
import com.lazywork.repositorio.InicioSesionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InicioSesionServicios {

    private final InicioSesionCrudRepository inicioSesionRepository;

    @Autowired
    public InicioSesionServicios(InicioSesionCrudRepository inicioSesionRepository) {
        this.inicioSesionRepository = inicioSesionRepository;
    }

<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
    public List<InicioSesion> listaIniciosSesion() {
        return (List<InicioSesion>) inicioSesionRepository.findAll();
    }

    public InicioSesion insertarInicioSesion(InicioSesion inicioSesion) {
        return inicioSesionRepository.save(inicioSesion);
    }

    public InicioSesion actualizarInicioSesion(Long id, InicioSesion inicioSesionActualizado) {
        if (existeInicioSesion(id)) {
            InicioSesion inicioSesionExistente = inicioSesionRepository.findById(String.valueOf(id)).orElse(null);
            if (inicioSesionExistente != null) {
                // Actualizar los campos necesarios del inicio de sesión existente
                inicioSesionExistente.setUsuario(inicioSesionActualizado.getUsuario());
                inicioSesionExistente.setFechaHoraInicio(inicioSesionActualizado.getFechaHoraInicio());
                // Continuar actualizando otros campos según tus necesidades

                // Guardar el inicio de sesión actualizado en la base de datos
                return inicioSesionRepository.save(inicioSesionExistente);
            }
        }
        return null;
    }
    public Optional<InicioSesion> findInicioSesionById(Long id) {
        return inicioSesionRepository.findById(String.valueOf(id));
    }
    public void eliminarInicioSesion(Long id) {
        inicioSesionRepository.deleteById(String.valueOf(id));
    }

    public boolean existeInicioSesion(Long id) {
        return inicioSesionRepository.existsById(String.valueOf(id));
    }
}
