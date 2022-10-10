package com.practica.biblioteca.model.persistance;

import com.practica.biblioteca.model.entitys.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorPersistance extends JpaRepository<Autor, Long> {

}
