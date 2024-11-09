package com.juegos.juegos.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.juegos.models.JuegoConsola;
import com.juegos.juegos.repository.IJuegoConsola;

@Service
public class JuegoConsolaService {

  @Autowired
  IJuegoConsola iJuegoConsola;

  

  public ArrayList<JuegoConsola> getJuegosConsola() {
    return (ArrayList<JuegoConsola>) iJuegoConsola.findAll();
  }

  public JuegoConsola createJuegoConsola(JuegoConsola juegoConsola) {
    return iJuegoConsola.save(juegoConsola);
  }

  public Optional<JuegoConsola> getJuegoConsolaById(int id) {
    return iJuegoConsola.findById(id);
  }

  public JuegoConsola updateJuegoConsola(int id, JuegoConsola juegoConsolaActualizado) {
    Optional<JuegoConsola> juegoConsolaExistente = iJuegoConsola.findById(id);
    
    if (juegoConsolaExistente.isPresent()) {
      JuegoConsola juegoConsola = juegoConsolaExistente.get();
      juegoConsola.setJuego(juegoConsolaActualizado.getJuego());
      juegoConsola.setConsola(juegoConsolaActualizado.getConsola());
      return iJuegoConsola.save(juegoConsola);
    } else {
      return null;
    }
  }

  public boolean deleteJuegoConsola(int id) {
    try {
      iJuegoConsola.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
