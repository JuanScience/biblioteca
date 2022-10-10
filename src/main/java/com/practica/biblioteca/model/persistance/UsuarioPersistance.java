package com.practica.biblioteca.model.persistance;

import com.practica.biblioteca.model.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPersistance extends JpaRepository<Usuario, Long> {

}
