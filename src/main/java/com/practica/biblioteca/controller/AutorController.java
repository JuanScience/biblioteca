package com.practica.biblioteca.controller;


import com.practica.biblioteca.business.AutorService;
import com.practica.biblioteca.exeption.NoAutorizado;
import com.practica.biblioteca.model.entitys.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "autor")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.DELETE})
public class AutorController {
    @Autowired
    AutorService autorService;

    //permite que el controlador exponga metodo get para hacer consultas con el path especificado
    @GetMapping("autores")
    public List<Autor> obtenerAutores() {
        return autorService.obtenerAutores();
    }

    @PostMapping("autor/create/{nombre}/{nacionalidad}/{documento}")
    public Autor crearAutor(
            @PathVariable String nombre,
            @PathVariable String nacionalidad,
            @PathVariable String documento,
            @RequestHeader int tipo
    ) {
        return autorService.crearAutor(tipo, nombre, nacionalidad, documento);
    }

    @PutMapping("autor/update")
    public Autor actualizarAutor(@RequestBody Autor autor, @RequestHeader int tipo) throws NoAutorizado {
        return autorService.actualizarAutor(tipo, autor);
    }

    @DeleteMapping("autor/delete/{id}")
    public boolean eliminarAutorPorId(@PathVariable("id") Long id, @RequestHeader("tipo") int tipo) throws NoAutorizado {
        return autorService.eliminarAutorPorId(tipo, id);
    }

    //permite que el controlador exponga metodo get para hacer consultas con el path especificado
    @GetMapping("autor/buscar/{cedula}")
    public Autor obtenerAutorPorCedula(@PathVariable("cedula") String cedula) {
        //aca va el llamado al service que valida y pide a la BD el libro.
        return autorService.obtenerAutorPorCedula(cedula);
    }
}
