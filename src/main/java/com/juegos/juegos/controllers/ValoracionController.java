package com.juegos.juegos.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.juegos.juegos.models.Valoracion;
import com.juegos.juegos.services.ValoracionService;


@RestController
@RequestMapping("/valoraciones")
@CrossOrigin
public class ValoracionController {

  @Autowired
  private ValoracionService valoracionService;

  @GetMapping
  public ArrayList<Valoracion> getValoraciones() {
    return valoracionService.getValoraciones();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Valoracion> getValoracionById(@PathVariable int id) {
    Optional<Valoracion> valoracion = valoracionService.getValoracionById(id);
    if (valoracion.isPresent()) {
      return new ResponseEntity<>(valoracion.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Valoracion> createValoracion(@RequestBody Valoracion valoracion) {
    try {
      Valoracion nuevaValoracion = valoracionService.createValoracion(valoracion);
      return new ResponseEntity<>(nuevaValoracion, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Valoracion> updateValoracion(@PathVariable int id, @RequestBody Valoracion valoracion) {
    Valoracion valoracionActualizada = valoracionService.updateValoracion(id, valoracion);
    if (valoracionActualizada != null) {
      return new ResponseEntity<>(valoracionActualizada, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteValoracion(@PathVariable int id) {
    if (valoracionService.deleteValoracion(id)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
