package com.lazywork.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "UsuarioRol")
public class UsuarioRol {

    @Id
<<<<<<< HEAD
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     */
=======

    @GeneratedValue(strategy = GenerationType.IDENTITY)

>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    @Column(name = "UsuarioRolID")
    private Long usuarioRolID;

    @ManyToOne
    @JoinColumn(name = "UsuarioID", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "RolID", nullable = false)
    private Rol rol;

    public UsuarioRol(Long usuarioRolID, Usuario usuario, Rol rol) {
        this.usuarioRolID = usuarioRolID;
        this.usuario = usuario;
        this.rol = rol;
    }

    public UsuarioRol() {
    }

    public Long getUsuarioRolID() {
        return usuarioRolID;
    }

    public void setUsuarioRolID(Long usuarioRolID) {
        this.usuarioRolID = usuarioRolID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioRol{" +
                "usuarioRolID=" + usuarioRolID +
                ", usuario=" + usuario +
                ", rol=" + rol +
                '}';
    }
}