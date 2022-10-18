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
@RestController(value = "/libro")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LibroController {
    @Autowired
    LibroService libroService;

    //permite que el controlador exponga metodo get para hacer consultas con el path especificado
    @GetMapping("/id_Autor/{idAutor}")
    public List<Libro> obtenerLibroPorIdAutor(@PathVariable("idAutor") Long idAutor) {
        //aca va el llamado al service que valida y pide a la BD los libros.
        return libroService.obtenerLibroPorIdAutor(idAutor);
    }

    //permite que el controlador exponga metodo get para hacer consultas con el path especificado
    @GetMapping("/libro/{nombre}")
    public List<Libro> obtenerLibroPorAuthor(@PathVariable("nombre") String nombre, @RequestHeader("tipo") int tipo) {
        //aca va el llamado al service que valida y pide a la BD el libro.
        return null;
    }

    @DeleteMapping("id/{id}")
    public boolean eliminarLibroPorId(@PathVariable("id") Long id, @RequestHeader("tipo") int tipo) throws NoAutorizado {
        return libroService.eliminarLibroPorId(tipo, id);
    }

    @PostMapping("libro/create/{genero}/{editorial}/{isbn}/{year}/{autor}")
    public Libro crearLibro(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate year,
            @PathVariable("isbn") String ibns,
            @PathVariable String editorial,
            @PathVariable String genero,
            @PathVariable Long autor,
            @RequestHeader("tipo") int tipo
    ) throws NoAutorizado {
        return libroService.crearLibro(tipo, ibns, genero, editorial, year, autor);
    }

    @PutMapping("libro/update")
    public Libro actualizarLibro(@RequestBody Libro libro, @RequestHeader() int tipo) throws NoAutorizado {
        return libroService.actualizarLibro(tipo, libro);
    }

    //permite que el controlador exponga metodo get para hacer consultas con el path especificado
    @GetMapping("/libros")
    public List<Libro> obtenerLibros() {
        return libroService.obtenerLibros();
    }

}
