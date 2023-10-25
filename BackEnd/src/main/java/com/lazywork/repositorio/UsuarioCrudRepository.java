package com.lazywork.repositorio;

import com.lazywork.entidad.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByNivelSoporte(String nivelSoporte);
}
