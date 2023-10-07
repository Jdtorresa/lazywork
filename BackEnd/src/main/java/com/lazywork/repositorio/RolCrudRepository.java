package com.lazywork.repositorio;

import com.lazywork.entidad.Rol;
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RolCrudRepository extends CrudRepository<Rol, String> {
    @Query("SELECT CASE WHEN COUNT(ur) > 0 THEN true ELSE false END FROM UsuarioRol ur INNER JOIN ur.rol rol WHERE rol.id = :rolId")
    boolean existsInUsuarioRol(@Param("rolId") String rolId);
<<<<<<< HEAD
=======
=======
=======
import org.springframework.data.jpa.repository.Query;
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RolCrudRepository extends CrudRepository<Rol, String> {
<<<<<<< HEAD

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
    @Query("SELECT CASE WHEN COUNT(ur) > 0 THEN true ELSE false END FROM UsuarioRol ur INNER JOIN ur.rol rol WHERE rol.id = :rolId")
    boolean existsInUsuarioRol(@Param("rolId") String rolId);
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
}
