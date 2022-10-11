package com.practica.biblioteca.model.persistance;

import com.practica.biblioteca.model.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioPersistance extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.password = :passWord")
    public abstract Usuario login(@Param("nombreUsuario") String nombreUsuario, @Param("passWord") String passWord);
}
