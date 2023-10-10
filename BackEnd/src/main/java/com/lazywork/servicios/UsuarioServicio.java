package com.lazywork.servicios;

import com.lazywork.entidad.Usuario;
import com.lazywork.repositorio.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioServicio {
    private static UsuarioCrudRepository usuarioRepository;

    @Autowired
    public UsuarioServicio(UsuarioCrudRepository usuarioRepository) {
        UsuarioServicio.usuarioRepository = usuarioRepository;
    }


    public static boolean existeUsuario(Long usuarioId) {
        // Utiliza el repositorio de usuarios para buscar el usuario por su ID.
        Optional<Usuario> usuarioOptional = usuarioRepository.findById((usuarioId));

        // Verificar si se encontró el usuario
        return usuarioOptional.isPresent();
    }

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }


    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            // Actualiza los campos necesarios del usuario existente con los valores del usuario actualizado.
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setDocumento(usuarioActualizado.getDocumento());
            usuario.setNivelSoporte(usuarioActualizado.getNivelSoporte());

            // Guarda el usuario actualizado en el repositorio.
            return usuarioRepository.save(usuario);
        } else {
            // Maneja el caso en que no se encuentre el usuario.
            throw new NoSuchElementException("No se encontró el usuario con ID: " + id);
        }
    }

    public boolean existsById(Long id) {
        // Lógica para verificar si un usuario existe por su ID
        return usuarioRepository.existsById(id);
    }

    // Puedes agregar más métodos según tus necesidades, como actualización, búsqueda por otros campos, etc.
}