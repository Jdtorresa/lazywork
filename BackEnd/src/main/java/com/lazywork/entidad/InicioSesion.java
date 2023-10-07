package com.lazywork.entidad;
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.persistence.*;
=======
<<<<<<< HEAD
import jakarta.persistence.*;
=======

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
import jakarta.persistence.*;
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
import java.time.LocalDateTime;

@Entity
@Table(name = "IniciosSesion")
public class InicioSesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InicioID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UsuarioID", referencedColumnName = "UsuarioID", nullable = false)
    private Usuario usuario;

<<<<<<< HEAD
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======

>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    @Column(nullable = false)
    private LocalDateTime tiempodesesion;

    @Column(name = "FechaHoraInicio", nullable = false)
    private LocalDateTime fechaHoraInicio;


    @Column(nullable = true)
    private LocalDateTime FechaHoraFin;
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    // Constructor por defecto
    public InicioSesion() {
    }

    // Constructor con parámetros
    public InicioSesion(Usuario usuario, LocalDateTime fechaHoraInicio) {
        this.usuario = usuario;
        this.fechaHoraInicio = fechaHoraInicio;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public void setTiempodesesion(LocalDateTime tiempodesesion) {
        this.tiempodesesion = tiempodesesion;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        FechaHoraFin = fechaHoraFin;
    }
// Puedes agregar otros métodos y personalizar la entidad según tus necesidades

<<<<<<< HEAD
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======

>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    @Override
    public String toString() {
        return "InicioSesion{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", Tiempodesesion=" + tiempodesesion +
                ", fechaHoraInicio=" + fechaHoraInicio +
                ", FechaHoraFin=" + FechaHoraFin +
                '}';
    }
}
