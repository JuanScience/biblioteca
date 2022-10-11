package com.practica.biblioteca.controller;

import com.practica.biblioteca.business.UsuarioService;
import com.practica.biblioteca.exeption.NoAutorizado;
import com.practica.biblioteca.model.entitys.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//permite que la clase sea un servicio expuesto indicándole el path
@RestController(value = "usuario")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    //permite que el controlador exponga metodo get para hacer consultas con el path especificado
    @GetMapping("usuarios")
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping("usuario/create/{username}/{password}/{tipoUsuario}")
    public Usuario crearUsuario(
            @PathVariable String username,
            @PathVariable String password,
            @PathVariable int tipoUsuario,
            @RequestHeader int tipo
    ) throws NoAutorizado {
            return usuarioService.crearUsuario(tipo, username, password, tipoUsuario);
    }

    @PutMapping("usuario/update")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario, @RequestHeader() int tipo) throws NoAutorizado {
        return usuarioService.actualizarUsuario(tipo, usuario);
    }

    @DeleteMapping("usuario/delete/{id}")
    public boolean eliminarUsuarioPorId(@PathVariable("id") Long id, @RequestHeader("tipo") int tipo) throws NoAutorizado {
        return usuarioService.eliminarUsuarioPorId(tipo, id);
    }

    @CrossOrigin(origins = "http://localhost:5500")
    @PostMapping ("index.html/{nombreUsuario}/{passWord}")
    public Usuario login(@PathVariable("nombreUsuario") String nombreUsuario, @PathVariable("passWord") String passWord) {
        return usuarioService.login(nombreUsuario, passWord);
    }

}
