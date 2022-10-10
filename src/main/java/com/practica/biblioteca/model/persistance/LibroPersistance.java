package com.practica.biblioteca.model.persistance;

import com.practica.biblioteca.model.entitys.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LibroPersistance extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.isbn = :isbn")
    public abstract Libro findByIsbn(@Param("isbn") String isbn);

}
