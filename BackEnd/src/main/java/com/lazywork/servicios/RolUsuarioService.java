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
    private UsuarioRolCrudRepository repoRU;

    public List<RolUsuario> findAll() {
        return (List<RolUsuario>) repoRU.findAll();
    }
    public boolean existsById(String id){
        return repoRU.existsById(id);
    }
    public Optional<RolUsuario> findByID(String id) {
        return repoRU.findById(id);
    }

    public RolUsuario save(RolUsuario usuarioRoles) {
        return repoRU.save(usuarioRoles);
    }

    public void deleteById(String id) {
        repoRU.deleteById(id);
    }
}
