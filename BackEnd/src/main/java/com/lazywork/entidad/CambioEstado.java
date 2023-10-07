package com.lazywork.entidad;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "CambiosEstado")
public class CambioEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CambioEstadoID")
    private Long cambioEstadoID;

    @ManyToOne

    @JoinColumn(name = "IncidenciaID", nullable = false)
    private Incidencia incidencia;

    @ManyToOne
    @JoinColumn(name = "EstadoID", nullable = false)
    private EstadoIncidencia estado;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @Column(name = "FechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    public CambioEstado(Long cambioEstadoID, Incidencia incidencia, EstadoIncidencia estado, String descripcion, LocalDate fechaRegistro) {
        this.cambioEstadoID = cambioEstadoID;
        this.incidencia = incidencia;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public CambioEstado() {
    }
    // Getters y Setters
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======


    public Long getCambioEstadoID() {
        return cambioEstadoID;
    }

    public void setCambioEstadoID(Long cambioEstadoID) {
        this.cambioEstadoID = cambioEstadoID;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "CambioEstado{" +
                "cambioEstadoID=" + cambioEstadoID +
                ", incidencia=" + incidencia +
                ", estado=" + estado +
                ", descripcion='" + descripcion + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }

    public void setId(Long id){

    }
<<<<<<< HEAD
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
}
=======
}
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
