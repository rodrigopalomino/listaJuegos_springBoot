package com.juegos.juegos.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.juegos.models.Usuario;
import com.juegos.juegos.repository.IUsuario;


@Service
public class UsuarioService {

  @Autowired
  IUsuario iUsuario;

  public ArrayList<Usuario> getUsuarios() {
    return (ArrayList<Usuario>) iUsuario.findAll();
  }

  public Usuario createUsuario(Usuario usuario) {
    return iUsuario.save(usuario);
  }

  public Optional<Usuario> getUsuarioById(int id) {
    return iUsuario.findById(id);
  }

  public Usuario updateUsuario(int id, Usuario usuarioActualizado) {
    Optional<Usuario> usuarioExistente = iUsuario.findById(id);
    
    if (usuarioExistente.isPresent()) {
      Usuario usuario = usuarioExistente.get();
      usuario.setUsername(usuarioActualizado.getUsername());
      usuario.setPassword(usuarioActualizado.getPassword());
      return iUsuario.save(usuario);
    } else {
      return null;
    }
  }

  public boolean deleteUsuario(int id) {
    try {
      iUsuario.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public Usuario login(String username, String password) {
    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) iUsuario.findAll();
    
    for (Usuario usuario : usuarios) {
      if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
        return usuario;
      }
    }
    
    return null;
  }
}
