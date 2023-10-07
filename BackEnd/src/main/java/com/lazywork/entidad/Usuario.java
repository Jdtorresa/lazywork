package com.lazywork.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
<<<<<<< HEAD
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioID")
    private Long id;

    @Column(name = "Nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "Apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name = "Documento", length = 50, nullable = false)
    private String documento;

<<<<<<< HEAD
    @Column(name = "nivel_soporte")
    private String nivelSoporte;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InicioSesion> iniciosSesion = new ArrayList<>();

=======
    @NotNull
    private String nivelSoporte;

>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    // Constructor por defecto
    public Usuario() {
    }

    // Constructor con parámetros
<<<<<<< HEAD
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    public Usuario(Long id, String nombre, String apellido, String documento, String nivelSoporte) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.nivelSoporte = nivelSoporte;
    }
<<<<<<< HEAD
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNivelSoporte() {
        return nivelSoporte;
    }

    public void setNivelSoporte(String nivelSoporte) {
        this.nivelSoporte = nivelSoporte;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", nivelSoporte='" + nivelSoporte + '\'' +
                '}';
    }
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
}
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
// Ge
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
}
>>>>>>> 17438130d6ae7a17ebb9d93a3b93206300c4f7c3
