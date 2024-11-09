package com.juegos.juegos.controllers;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegos.juegos.models.Usuario;
import com.juegos.juegos.services.UsuarioService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping
  public ArrayList<Usuario> getUsuarios() {
    return usuarioService.getUsuarios();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
    Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
    if (usuario.isPresent()) {
      return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
    try {
      Usuario nuevoUsuario = usuarioService.createUsuario(usuario);
      return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
    Usuario usuarioActualizado = usuarioService.updateUsuario(id, usuario);
    if (usuarioActualizado != null) {
      return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable int id) {
    if (usuarioService.deleteUsuario(id)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
