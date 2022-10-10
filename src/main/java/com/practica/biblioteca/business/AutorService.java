package com.practica.biblioteca.business;

import com.practica.biblioteca.exeption.NoAutorizado;
import com.practica.biblioteca.model.entitys.Autor;
import com.practica.biblioteca.model.persistance.AutorPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  //Marca la clase como un proveedor de servicio
public class AutorService {
    @Autowired
    private AutorPersistance autorPersistance;

    public List<Autor> obtenerAutores() {
        return autorPersistance.findAll();
    }

    public Optional<Autor> findById(Long id) {
        return autorPersistance.findById(id);
    }

    public Autor crearAutor(int tipo, String nombre, String nacionalidad, String documento) {
        if (tipo == 0) {
            Autor autor = new Autor();
            autor.setCedula(documento);
            autor.setNacionalidad(nacionalidad);
            autor.setNombreCompleto(nombre);
            return autorPersistance.save(autor);
        }
        return null;
    }

    public Autor actualizarAutor(int tipo, Autor autor) throws NoAutorizado {
        if (tipo == 0)
            return autorPersistance.save(autor);
        throw new NoAutorizado("Usuario no autorizado para actualizar el autor");
    }

    public boolean eliminarAutorPorId(int tipo, Long id) throws NoAutorizado {
        if (tipo == 0) {
            try {
                autorPersistance.deleteById(id);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        throw new NoAutorizado("Usuario no autorizado para eliminar autor");
    }
}