package com.lazywork.estructuraCERS.entidad;

import com.lazywork.User.User;
import jakarta.persistence.*;



import java.time.LocalDate;


@Entity
@Table(name = "Incidencias")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IncidenciaID")
    private Long incidenciaID;

    @ManyToOne
    @JoinColumn(name = "UsuarioID", nullable = false)
    private User usuario;

    @Column(name = "Ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "NombreIncidencia", nullable = false)
    private String nombreIncidencia;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "EstadoID", nullable = false)
    private EstadoIncidencia estado;

    @ManyToOne
    @JoinColumn(name = "PrioridadID", nullable = false)
    private PrioridadIncidencia prioridad;

    @Column(name = "FechaRegistro", nullable = true)
    private LocalDate fechaRegistro;

    // Getters y Setters

    public Long getIncidenciaID() {
        return incidenciaID;
    }

    public void setIncidenciaID(Long incidenciaID) {
        this.incidenciaID = incidenciaID;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreIncidencia() {
        return nombreIncidencia;
    }

    public void setNombreIncidencia(String nombreIncidencia) {
        this.nombreIncidencia = nombreIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
    }

    public PrioridadIncidencia getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadIncidencia prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "incidenciaID=" + incidenciaID +
                ", usuario=" + usuario +
                ", ubicacion='" + ubicacion + '\'' +
                ", nombreIncidencia='" + nombreIncidencia + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", prioridad=" + prioridad +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }

    public void setId(Long id) {
    }
}