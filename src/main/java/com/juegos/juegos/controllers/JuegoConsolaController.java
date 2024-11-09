package com.juegos.juegos.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegos.juegos.models.JuegoConsola;
import com.juegos.juegos.services.JuegoConsolaService;

@RestController
@RequestMapping("/juegosconsola")
@CrossOrigin
public class JuegoConsolaController {

  @Autowired
  private JuegoConsolaService juegoConsolaService;

  @GetMapping
  public ArrayList<JuegoConsola> getJuegosConsola() {
    return juegoConsolaService.getJuegosConsola();
  }

  @GetMapping("/{id}")
  public ResponseEntity<JuegoConsola> getJuegoConsolaById(@PathVariable int id) {
    Optional<JuegoConsola> juegoConsola = juegoConsolaService.getJuegoConsolaById(id);
    if (juegoConsola.isPresent()) {
      return new ResponseEntity<>(juegoConsola.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<JuegoConsola> createJuegoConsola(@RequestBody JuegoConsola juegoConsola) {
    try {
      JuegoConsola nuevoJuegoConsola = juegoConsolaService.createJuegoConsola(juegoConsola);
      return new ResponseEntity<>(nuevoJuegoConsola, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<JuegoConsola> updateJuegoConsola(@PathVariable int id, @RequestBody JuegoConsola juegoConsola) {
    JuegoConsola juegoConsolaActualizado = juegoConsolaService.updateJuegoConsola(id, juegoConsola);
    if (juegoConsolaActualizado != null) {
      return new ResponseEntity<>(juegoConsolaActualizado, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteJuegoConsola(@PathVariable int id) {
    if (juegoConsolaService.deleteJuegoConsola(id)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
