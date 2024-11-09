package com.juegos.juegos.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.juegos.models.JuegoGenero;
import com.juegos.juegos.repository.IJuegoGenero;

@Service
public class JuegoGeneroService {

  @Autowired
  IJuegoGenero iJuegoGenero;

  public ArrayList<JuegoGenero> getJuegosGenero() {
    return (ArrayList<JuegoGenero>) iJuegoGenero.findAll();
  }

  public JuegoGenero createJuegoGenero(JuegoGenero juegoGenero) {
    return iJuegoGenero.save(juegoGenero);
  }

  public Optional<JuegoGenero> getJuegoGeneroById(int id) {
    return iJuegoGenero.findById(id);
  }

  public JuegoGenero updateJuegoGenero(int id, JuegoGenero juegoGeneroActualizado) {
    Optional<JuegoGenero> juegoGeneroExistente = iJuegoGenero.findById(id);
    
    if (juegoGeneroExistente.isPresent()) {
      JuegoGenero juegoGenero = juegoGeneroExistente.get();
      juegoGenero.setJuego(juegoGeneroActualizado.getJuego());
      juegoGenero.setGenero(juegoGeneroActualizado.getGenero());
      return iJuegoGenero.save(juegoGenero);
    } else {
      return null;
    }
  }

  public boolean deleteJuegoGenero(int id) {
    try {
      iJuegoGenero.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
