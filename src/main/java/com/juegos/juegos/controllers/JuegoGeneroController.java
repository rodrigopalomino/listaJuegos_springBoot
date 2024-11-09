package com.juegos.juegos.controllers;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegos.juegos.models.JuegoGenero;
import com.juegos.juegos.services.JuegoGeneroService;


@RestController
@RequestMapping("/juegosgenero")
@CrossOrigin
public class JuegoGeneroController {

  @Autowired
  private JuegoGeneroService juegoGeneroService;

  @GetMapping
  public ArrayList<JuegoGenero> getJuegosGenero() {
    return juegoGeneroService.getJuegosGenero();
  }

  @GetMapping("/{id}")
  public ResponseEntity<JuegoGenero> getJuegoGeneroById(@PathVariable int id) {
    Optional<JuegoGenero> juegoGenero = juegoGeneroService.getJuegoGeneroById(id);
    if (juegoGenero.isPresent()) {
      return new ResponseEntity<>(juegoGenero.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<JuegoGenero> createJuegoGenero(@RequestBody JuegoGenero juegoGenero) {
    try {
      JuegoGenero nuevoJuegoGenero = juegoGeneroService.createJuegoGenero(juegoGenero);
      return new ResponseEntity<>(nuevoJuegoGenero, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<JuegoGenero> updateJuegoGenero(@PathVariable int id, @RequestBody JuegoGenero juegoGenero) {
    JuegoGenero juegoGeneroActualizado = juegoGeneroService.updateJuegoGenero(id, juegoGenero);
    if (juegoGeneroActualizado != null) {
      return new ResponseEntity<>(juegoGeneroActualizado, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteJuegoGenero(@PathVariable int id) {
    if (juegoGeneroService.deleteJuegoGenero(id)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
