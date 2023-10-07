package com.lazywork.repositorio;

<<<<<<< HEAD
<<<<<<< HEAD
import com.lazywork.entidad.UsuarioRol;
=======
<<<<<<< HEAD
import com.lazywork.entidad.UsuarioRol;
=======
import com.lazywork.entidad.Rol;
import com.lazywork.entidad.RolUsuario;
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
import com.lazywork.entidad.UsuarioRol;
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20

public interface UsuarioRolCrudRepository extends CrudRepository<UsuarioRol, String> {
    @Query(value = "SELECT * FROM usuario_rol ru WHERE ru.usuarioid = :usuarioid", nativeQuery = true)
    List<UsuarioRol> existsUsuario(@Param("usuarioid") String id);
<<<<<<< HEAD
=======
=======
import java.util.Optional;

public interface UsuarioRolCrudRepository extends CrudRepository<RolUsuario, Long> {
    @Query(value = "SELECT * FROM rol_usuario ru WHERE ru.usuarioid = :usuarioid", nativeQuery = true)
    List<RolUsuario> existsByUsuarioId(@Param("usuarioid") Long id);
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======

public interface UsuarioRolCrudRepository extends CrudRepository<UsuarioRol, String> {
    @Query(value = "SELECT * FROM usuario_rol ru WHERE ru.usuarioid = :usuarioid", nativeQuery = true)
    List<UsuarioRol> existsUsuario(@Param("usuarioid") String id);
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
}
