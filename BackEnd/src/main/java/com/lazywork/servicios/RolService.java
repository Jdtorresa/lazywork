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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    public List<Rol> finAll() {
        return (List<Rol>) repoRol.findAll();
    }

    public boolean existsById(String id){
        return repoRol.existsById(id);
    }
    public Optional<Rol> findById(String id) {
        return repoRol.findById(id);
<<<<<<< HEAD
=======
=======
    public List<Rol> findAll() {
=======
    public List<Rol> finAll() {
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
        return (List<Rol>) repoRol.findAll();
    }

    public boolean existsById(String id){
        return repoRol.existsById(id);
    }
<<<<<<< HEAD
    public Optional<Rol> findById(Long id) {
        return repoRol.findById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
    public Optional<Rol> findById(String id) {
        return repoRol.findById(id);
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    }

    public Rol save(Rol roles) {
        return repoRol.save(roles);
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    public void deleteById(String id) {
        repoRol.deleteById(id);
    }

    public boolean existsInUsuarioRol(String id){
        return repoRol.existsInUsuarioRol(id);
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
    public void deleteById(Long id) {
        repoRol.deleteById(String.valueOf(id));
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    }
}
