package com.practica.biblioteca.model.entitys;

import javax.persistence.*;
import java.time.LocalDate;

//identifica esta clase como entidad
@Entity
//genera get set y contructor
public class Libro {
    //identifica la llave de la tabla
    @Id
    @GeneratedValue()
    private Long idLibro;

    //permite restringir el campo en al tabla
    @Column(name = "isbn", length = 13, unique = true, nullable = false)
    private String isbn;

    @Column(name = "editorial", length = 50, nullable = false)
    private String editorial;

    @Column(name = "genero", length = 10, nullable = false)
    private String genero;

    @Column(name = "year", nullable = false)
    private LocalDate year;

    //permite relación entre tablas

    @Column(nullable = false)
    private Long idAutor;

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }
}
