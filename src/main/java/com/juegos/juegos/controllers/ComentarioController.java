package com.juegos.juegos.controllers;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegos.juegos.models.Comentario;
import com.juegos.juegos.services.ComentarioService;


@RestController
@RequestMapping("/comentarios")
@CrossOrigin
public class ComentarioController {

  @Autowired
  private ComentarioService comentarioService;

  @GetMapping
  public ArrayList<Comentario> getComentarios() {
    return comentarioService.getComentarios();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Comentario> getComentarioById(@PathVariable int id) {
    Optional<Comentario> comentario = comentarioService.getComentarioById(id);
    if (comentario.isPresent()) {
      return new ResponseEntity<>(comentario.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Comentario> createComentario(@RequestBody Comentario comentario) {
    try {
      Comentario nuevoComentario = comentarioService.createComentario(comentario);
      return new ResponseEntity<>(nuevoComentario, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Comentario> updateComentario(@PathVariable int id, @RequestBody Comentario comentario) {
    Comentario comentarioActualizado = comentarioService.updateComentario(id, comentario);
    if (comentarioActualizado != null) {
      return new ResponseEntity<>(comentarioActualizado, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteComentario(@PathVariable int id) {
    if (comentarioService.deleteComentario(id)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
