package com.lazywork.servicios;

import com.lazywork.entidad.Rol;
import com.lazywork.repositorio.RolCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolCrudRepository repoRol;

    public List<Rol> findAll() {
        return (List<Rol>) repoRol.findAll();
    }
    public boolean existsById(String id){
        return repoRol.existsById(id);
    }
    public Optional<Rol> findById(String id) {
        return repoRol.findById(id);
    }

    public Rol save(Rol roles) {
        return repoRol.save(roles);
    }

    public void deleteById(String id) {
        repoRol.deleteById(id);
    }
}
