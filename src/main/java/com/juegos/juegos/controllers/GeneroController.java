package com.juegos.juegos.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegos.juegos.models.Genero;
import com.juegos.juegos.services.GeneroService;


@RestController
@RequestMapping("/generos")
@CrossOrigin
public class GeneroController {

  @Autowired
  private GeneroService generoService;

  @GetMapping
  public ArrayList<Genero> getGeneros() {
    return generoService.getGeneros();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Genero> getGeneroById(@PathVariable int id) {
    Optional<Genero> genero = generoService.getGeneroById(id);
    return genero.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                 .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<Genero> createGenero(@RequestBody Genero genero) {
    try {
      Genero nuevoGenero = generoService.createGenero(genero);
      return new ResponseEntity<>(nuevoGenero, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Genero> updateGenero(@PathVariable int id, @RequestBody Genero genero) {
    Genero generoActualizado = generoService.updateGenero(id, genero);
    return (generoActualizado != null) ? new ResponseEntity<>(generoActualizado, HttpStatus.OK)
                                      : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteGenero(@PathVariable int id) {
    return generoService.deleteGenero(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                                          : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
