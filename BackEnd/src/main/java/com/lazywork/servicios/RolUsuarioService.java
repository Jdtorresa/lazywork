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

    public List<RolUsuario> obtenerTodosLosUsuarioRoles() {
        return (List<RolUsuario>) repoUR.findAll();
    }

    public Optional<RolUsuario> obtenerUsuarioRolesPorId(String id) {
        return repoUR.findById(id);
    }

    public RolUsuario crearUsuarioRoles(RolUsuario usuarioRoles) {
        return repoUR.save(usuarioRoles);
    }

    public void eliminarUsuarioRoles(String id) {
        repoUR.deleteById(id);
    }
}
