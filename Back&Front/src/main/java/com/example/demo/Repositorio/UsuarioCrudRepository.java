package com.example.demo.Repositorio;

import com.example.demo.Entidad.Usuarioback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioCrudRepository extends JpaRepository<Usuarioback, Long> {

    Usuarioback findByCorreo(String email);
}
