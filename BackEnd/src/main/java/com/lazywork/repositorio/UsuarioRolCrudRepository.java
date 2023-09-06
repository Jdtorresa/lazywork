package com.lazywork.repositorio;

import com.lazywork.entidad.RolUsuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRolCrudRepository extends CrudRepository<RolUsuario, String> {
}
