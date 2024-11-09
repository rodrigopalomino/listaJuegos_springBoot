package com.juegos.juegos.controllers;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegos.juegos.models.Consola;
import com.juegos.juegos.services.ConsolaService;


@RestController
@RequestMapping("/consolas")
@CrossOrigin
public class ConsolaController {

  @Autowired
  private ConsolaService consolaService;

  @GetMapping
  public ArrayList<Consola> getConsolas() {
    return consolaService.getConsolas();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Consola> getConsolaById(@PathVariable int id) {
    Optional<Consola> consola = consolaService.getConsolaById(id);
    return consola.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<Consola> createConsola(@RequestBody Consola consola) {
    try {
      Consola nuevaConsola = consolaService.createConsola(consola);
      return new ResponseEntity<>(nuevaConsola, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Consola> updateConsola(@PathVariable int id, @RequestBody Consola consola) {
    Consola consolaActualizada = consolaService.updateConsola(id, consola);
    return (consolaActualizada != null) ? new ResponseEntity<>(consolaActualizada, HttpStatus.OK)
                                        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteConsola(@PathVariable int id) {
    return consolaService.deleteConsola(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                                            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
