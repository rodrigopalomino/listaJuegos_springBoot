package com.juegos.juegos.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.juegos.models.Consola;
import com.juegos.juegos.repository.IConsola;

@Service
public class ConsolaService {

  @Autowired
  IConsola iConsola;

  public ArrayList<Consola> getConsolas() {
    return (ArrayList<Consola>) iConsola.findAll();
  }

  public Consola createConsola(Consola consola) {
    return iConsola.save(consola);
  }

  public Optional<Consola> getConsolaById(int id) {
    return iConsola.findById(id);
  }

  public Consola updateConsola(int id, Consola consolaActualizada) {
    Optional<Consola> consolaExistente = iConsola.findById(id);
    
    if (consolaExistente.isPresent()) {
      Consola consola = consolaExistente.get();
      consola.setNombre(consolaActualizada.getNombre());
      return iConsola.save(consola);
    } else {
      return null;
    }
  }

  public boolean deleteConsola(int id) {
    try {
      iConsola.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
