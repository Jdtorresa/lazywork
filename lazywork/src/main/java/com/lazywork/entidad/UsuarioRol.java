package com.lazywork.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "UsuarioRoles")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioRolID")
    private Long usuarioRolID;

    @ManyToOne
    @JoinColumn(name = "UsuarioID", nullable = false)
    private UsuarioSistema usuario;

    @ManyToOne
    @JoinColumn(name = "RolID", nullable = false)
    private Rol rol;

    // Getters y Setters

    public Long getUsuarioRolID() {
        return usuarioRolID;
    }

    public void setUsuarioRolID(Long usuarioRolID) {
        this.usuarioRolID = usuarioRolID;
    }

    public UsuarioSistema getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSistema usuario) {
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