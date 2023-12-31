package com.example.demo.Repositorio;

import com.example.demo.Entidad.Usuarioback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public interface UsuarioCrudRepository extends JpaRepository<Usuarioback, Long> {

    Usuarioback findByCorreo(String correo);


    Usuarioback findByNivelSoporte(String nivelSoporte);
}