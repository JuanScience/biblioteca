package com.practica.biblioteca.model.persistance;

import com.practica.biblioteca.model.entitys.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroPersistance extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.idAutor = :idAutor")
    public abstract List<Libro> findByIdAutor(@Param("idAutor") Long idAutor);

}
