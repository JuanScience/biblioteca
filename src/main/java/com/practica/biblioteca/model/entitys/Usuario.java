package com.practica.biblioteca.model.entitys;

import javax.persistence.*;

@Entity                     //identifica esta clase como entidad
@Table(name = "Usuario")    //Nombra la tabla en la base de datos
public class Usuario {
    @Id                     //Identifica la primary key
    @GeneratedValue()// Indica Identity
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "nombreUsuario", length = 50, unique = true, nullable = false)
    private String nombreUsuario;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
