package com.example.demo.Servicio;

import com.example.demo.Entidad.Usuario;
import com.example.demo.Repositorio.UsuarioCrudRepository;
import com.example.demo.Repositorio.usuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class usuarioServicio {

    private usuarioRepositorio repositorio;
    private UsuarioCrudRepository repoUsu;

    public usuarioServicio(usuarioRepositorio repositorio, UsuarioCrudRepository repoUsu) {
        this.repositorio = repositorio;
        this.repoUsu = repoUsu;
    }

    public Usuario crear(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public Usuario buscarEmail(String email) {
        return repositorio.findById(email).orElse(null);
    }

    public Usuario getCrearUsuario(Map<String, Object> dataUser) {
        if (dataUser == null) {
            return null;
        }

        String email = (String) dataUser.get("email");
        Usuario user = buscarEmail(email);

        if (user == null) {
            String name = (String) dataUser.get("nickname");
            String imag = (String) dataUser.get("picture");
            String auth_id = (String) dataUser.get("sub");
            String rol = (String) dataUser.get("rol");

            Usuario nuevoUsuario = new Usuario(email, name, imag, auth_id, rol);
            return this.crear(nuevoUsuario);
        } else {
            return user;
        }
    }
}
