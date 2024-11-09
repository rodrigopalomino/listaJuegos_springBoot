package com.juegos.juegos.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegos.juegos.models.Juego;
import com.juegos.juegos.services.JuegoService;



@RestController
@RequestMapping("/juegos")
@CrossOrigin
public class JuegoController {

  @Autowired
  private JuegoService juegoService;

  @GetMapping
  public ArrayList<Juego> getJuegos() {
    return juegoService.getJuegos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Juego> getJuegoById(@PathVariable int id) {
    Optional<Juego> juego = juegoService.getJuegoById(id);
    return juego.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<Juego> createJuego(@RequestBody Juego juego) {
    try {
      Juego nuevoJuego = juegoService.createJuego(juego);
      return new ResponseEntity<>(nuevoJuego, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Juego> updateJuego(@PathVariable int id, @RequestBody Juego juego) {
    Juego juegoActualizado = juegoService.updateJuego(id, juego);
    return (juegoActualizado != null) ? new ResponseEntity<>(juegoActualizado, HttpStatus.OK)
                                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteJuego(@PathVariable int id) {
    return juegoService.deleteJuego(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                                        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
