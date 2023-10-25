package com.lazywork.repositorio;

import com.lazywork.entidad.Incidencia;
import com.lazywork.entidad.UsuarioRol;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncidenciaCrudRepository extends CrudRepository<Incidencia, Long> {


        @Modifying
        @Query("UPDATE Incidencia i SET i.usuario = (SELECT u FROM Usuario u WHERE u.nivelSoporte = 'nivel 1') WHERE i.estado.tipoEstado = 'en curso' AND i.prioridad.prioridadID = 1")
        void actualizarIncidenciasNivel1Prioridad1();
        @Modifying
        @Query("UPDATE Incidencia i SET i.usuario = (SELECT u FROM Usuario u WHERE u.nivelSoporte = 'nivel 2') WHERE i.estado.tipoEstado = 'en curso' AND i.prioridad.prioridadID = 2")
        void actualizarIncidenciasNivel2Prioridad2();

        @Modifying
        @Query("UPDATE Incidencia i SET i.usuario = (SELECT u FROM Usuario u WHERE u.nivelSoporte = 'nivel 3') WHERE i.estado.tipoEstado = 'en curso' AND i.prioridad.prioridadID = 3")
        void actualizarIncidenciasNivel3Prioridad3();

        List<Incidencia> findByEstado_EstadoID(Long estadoID);

}


