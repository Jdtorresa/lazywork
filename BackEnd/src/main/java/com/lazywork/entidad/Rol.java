package com.lazywork.entidad;

import jakarta.persistence.*;

@Entity
<<<<<<< HEAD
@Table(name = "Roles")
=======
<<<<<<< HEAD
@Table(name = "Roles")
=======
@Table(name = "Rol")
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
public class Rol {

    @Id
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     */
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    @Column(name = "RolID")
    private Long rolID;

    @Column(name = "NombreRol", nullable = false)
    private String nombreRol;

    // Getters y Setters

<<<<<<< HEAD
=======
=======
    @Column
    private Long rolID;

    @Column(nullable = false, length = 50)
    private String nombreRol;

>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
    public Long getRolID() {
        return rolID;
    }

    public void setRolID(Long rolID) {
        this.rolID = rolID;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}