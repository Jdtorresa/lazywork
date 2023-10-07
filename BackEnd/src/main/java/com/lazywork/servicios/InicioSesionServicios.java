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
<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
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
    public void eliminarInicio(Long id) {
        inicioSesionRepository.deleteById(String.valueOf(id));
    }

    public boolean existeInicioSesion(Long id) {
        return inicioSesionRepository.existsById(String.valueOf(id));
    }
<<<<<<< HEAD

}

=======
<<<<<<< HEAD
}
=======
}
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
