package com.lazywork.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadosIncidencia")
public class EstadoIncidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstadoID")
    private Long estadoID;

    @Column(name = "TipoEstado", nullable = false)
    private String tipoEstado;

    // Getters y Setters
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    public EstadoIncidencia() {
    }
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05

    public Long getEstadoID() {
        return estadoID;
    }

    public void setEstadoID(Long estadoID) {
        this.estadoID = estadoID;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    @Override
    public String toString() {
        return "EstadoIncidencia{" +
                "estadoID=" + estadoID +
                ", tipoEstado='" + tipoEstado + '\'' +
                '}';
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    public void setId(Long id){

    }
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
}