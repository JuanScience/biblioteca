package com.practica.biblioteca.business;

import com.practica.biblioteca.exeption.NoAutorizado;
import com.practica.biblioteca.model.entitys.Libro;
import com.practica.biblioteca.model.persistance.LibroPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service  //Marca la clase como un proveedor de servicio
public class LibroService {
    @Autowired
    private LibroPersistance libroPersistance;
    @Autowired
    private AutorService autorService;

    public List<Libro> obtenerLibroPorIdAutor(Long idAutor) {
        return libroPersistance.findByIdAutor(idAutor);
    }

    public boolean eliminarLibroPorId(int tipo, Long id) throws NoAutorizado {
        if (tipo == 0) {
            try {
                libroPersistance.deleteById(id);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        throw new NoAutorizado("Usuario no autorizado para eliminar libro");
    }

    public List<Libro> obtenerLibros() {
        return libroPersistance.findAll();
    }

    public Libro actualizarLibro(int tipo, Libro libro) throws NoAutorizado {
        if (tipo == 0)
            return libroPersistance.save(libro);
        throw new NoAutorizado("usuario no autorizado para actualizar el libro");
    }

    public Libro crearLibro(
            int tipo,
            String isbn,
            String genero,
            String editorial,
            LocalDate year,
            Long idAutor
    ) throws NoAutorizado {
        if (tipo == 0) {
            Libro libro = new Libro();
            libro.setIsbn(isbn);
            libro.setGenero(genero);
            libro.setEditorial(editorial);
            libro.setYear(year);
            libro.setIdAutor(idAutor);
            return libroPersistance.save(libro);
        }
        throw new NoAutorizado("Usuario no autorizado para realizar creación");
    }
}
