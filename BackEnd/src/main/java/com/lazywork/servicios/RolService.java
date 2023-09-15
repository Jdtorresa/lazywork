package com.lazywork.servicios;

import com.lazywork.entidad.Rol;
import com.lazywork.repositorio.RolCrudRepository;

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

<<<<<<< HEAD
    public List<Rol> finAll() {
        return (List<Rol>) repoRol.findAll();
    }

    public boolean existsById(String id){
        return repoRol.existsById(id);
    }
    public Optional<Rol> findById(String id) {
        return repoRol.findById(id);
=======
    public List<Rol> findAll() {
        return (List<Rol>) repoRol.findAll();
    }
    public boolean existsById(Long id){
        return repoRol.existsById(String.valueOf(id));
    }
    public Optional<Rol> findById(Long id) {
        return repoRol.findById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
    }

    public Rol save(Rol roles) {
        return repoRol.save(roles);
    }

<<<<<<< HEAD
    public void deleteById(String id) {
        repoRol.deleteById(id);
    }

    public boolean existsInUsuarioRol(String id){
        return repoRol.existsInUsuarioRol(id);
=======
    public void deleteById(Long id) {
        repoRol.deleteById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
    }
}
