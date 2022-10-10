package com.practica.biblioteca.business;

import com.practica.biblioteca.exeption.NoAutorizado;
import com.practica.biblioteca.model.entitys.Usuario;
import com.practica.biblioteca.model.persistance.UsuarioPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Marca la clase como un proveedor de servicio
public class UsuarioService {
    @Autowired
    private UsuarioPersistance usuarioPersistance;

    public List<Usuario> obtenerUsuarios() {
        return usuarioPersistance.findAll();
    }

    public Usuario crearUsuario(int tipo, String username, String password, int tipoUsuario) throws NoAutorizado {
        if (tipo == 0) {
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(username);
            usuario.setPassword(password);
            usuario.setTipo(tipoUsuario);
            return usuarioPersistance.save(usuario);
        }
        throw new NoAutorizado("Usuario no autorizado para realizar creación");
    }

    public Usuario actualizarUsuario(int tipo, Usuario usuario) throws NoAutorizado {
        if (tipo == 0)
            return usuarioPersistance.save(usuario);
        throw new NoAutorizado("Usuario no autorizado para actualizar el usuario");
    }


    public boolean eliminarUsuarioPorId(int tipo, Long id) throws NoAutorizado {
        if (tipo == 0) {
            try {
                usuarioPersistance.deleteById(id);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        throw new NoAutorizado("Usuario no autorizado para eliminar usuario");
    }
}
