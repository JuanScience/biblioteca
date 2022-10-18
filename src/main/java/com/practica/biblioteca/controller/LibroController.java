package com.practica.biblioteca.controller;

import com.practica.biblioteca.business.LibroService;
import com.practica.biblioteca.exeption.NoAutorizado;
import com.practica.biblioteca.model.entitys.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//permite que la clase sea un servicio expuesto indicándole el path
@RestController(value = "libro")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.DELETE})
public class LibroController {
    @Autowired
    LibroService libroService;

    //permite que el controlador exponga metodo get para hacer consultas con el path especificado
    @GetMapping("libros")
    public List<Libro> obtenerLibros() {
        return libroService.obtenerLibros();
    }

    @PostMapping("libro/create/{genero}/{editorial}/{isbn}/{year}/{idAutor}")
    public Libro crearLibro(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate year,
            @PathVariable String isbn,
            @PathVariable String editorial,
            @PathVariable String genero,
            @PathVariable Long idAutor,
            @RequestHeader int tipo
    ) throws NoAutorizado {
        return libroService.crearLibro(tipo, isbn, genero, editorial, year, idAutor);
    }

    //permite que el controlador exponga metodo get para hacer consultas con el path especificado
    @GetMapping("id_Autor/{idAutor}")
    public List<Libro> obtenerLibroPorIdAutor(@PathVariable("idAutor") Long idAutor) {
        //aca va el llamado al service que valida y pide a la BD los libros.
        return libroService.obtenerLibroPorIdAutor(idAutor);
    }

    @DeleteMapping("id/{id}")
    public boolean eliminarLibroPorId(@PathVariable("id") Long id, @RequestHeader("tipo") int tipo) throws NoAutorizado {
        return libroService.eliminarLibroPorId(tipo, id);
    }

    @PutMapping("libro/update")
    public Libro actualizarLibro(@RequestBody Libro libro, @RequestHeader() int tipo) throws NoAutorizado {
        return libroService.actualizarLibro(tipo, libro);
    }



}
