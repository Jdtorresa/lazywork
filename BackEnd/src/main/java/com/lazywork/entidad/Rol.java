package com.lazywork.entidad;

import jakarta.persistence.*;

@Entity
<<<<<<< HEAD
<<<<<<< HEAD
@Table(name = "Roles")
=======
<<<<<<< HEAD
@Table(name = "Roles")
=======
@Table(name = "Rol")
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
@Table(name = "Roles")
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
public class Rol {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
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
=======

    @Column(name = "RolID")
>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
    private Long rolID;

    @Column(name = "NombreRol", nullable = false)
    private String nombreRol;

<<<<<<< HEAD
>>>>>>> bdec9b621c30beabc6a2ea5be56e4d02f7a2a424
>>>>>>> bba52aaea7f63d63c62adcd64e0c4870ebba3b20
=======
    // Getters y Setters

>>>>>>> fbb46fbc5a742f773e8d4cc598720ff2a6133e05
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