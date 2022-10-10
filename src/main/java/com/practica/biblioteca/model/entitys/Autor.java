package com.practica.biblioteca.model.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//identifica esta clase como entidad
@Entity
//genera get set y contructor
public class Autor {
    //identifica la llave de la tabla
    @Id
    @GeneratedValue()
    private Long idAutor;

    //permite restringir el campo en la tabla
    @Column(name = "cedula", length = 10, unique = true, nullable = false)
    private String cedula;

    @Column(name = "nombreCompleto", length = 200, nullable = false)
    private String nombreCompleto;

    @Column(name = "nacionalidad", length = 60, nullable = false)
    private String nacionalidad;


    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
