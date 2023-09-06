package com.lazywork.servicios;

import com.lazywork.entidad.RolUsuario;
import com.lazywork.repositorio.UsuarioRolCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolUsuarioService {

    @Autowired
    private UsuarioRolCrudRepository repoUR;

    public List<RolUsuario> findAll() {
        return (List<RolUsuario>) repoUR.findAll();
    }

    public Optional<RolUsuario> findByID(String id) {
        return repoUR.findById(id);
    }

    public RolUsuario save(RolUsuario usuarioRoles) {
        return repoUR.save(usuarioRoles);
    }

    public void deleteById(String id) {
        repoUR.deleteById(id);
    }
}
