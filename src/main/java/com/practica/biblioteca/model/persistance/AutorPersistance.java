package com.practica.biblioteca.model.persistance;

import com.practica.biblioteca.model.entitys.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AutorPersistance extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.cedula = :cedula")
    public abstract Autor findByCedula(@Param("cedula") String cedula);
}
