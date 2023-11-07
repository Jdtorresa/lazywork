package com.example.demo.Servicio;

import com.example.demo.Entidad.Rol;
import com.example.demo.Repositorio.RolCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {



    private RolCrudRepository repoRol;
    @Autowired
    public RolService(RolCrudRepository repoRol) {
        this.repoRol = repoRol;
    }

    public List<Rol> finAll() {
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

    public boolean existsInUsuarioRol(String id){
        return repoRol.existsInUsuarioRol(id);
    }
}