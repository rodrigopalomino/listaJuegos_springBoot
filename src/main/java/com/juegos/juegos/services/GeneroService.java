package com.juegos.juegos.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.juegos.models.Genero;
import com.juegos.juegos.repository.IGenero;



@Service
public class GeneroService {

  @Autowired
  IGenero iGenero;

  public ArrayList<Genero> getGeneros() {
    return (ArrayList<Genero>) iGenero.findAll();
  }

  public Genero createGenero(Genero genero) {
    return iGenero.save(genero);
  }

  public Optional<Genero> getGeneroById(int id) {
    return iGenero.findById(id);
  }

  public Genero updateGenero(int id, Genero generoActualizado) {
    Optional<Genero> generoExistente = iGenero.findById(id);
    
    if (generoExistente.isPresent()) {
      Genero genero = generoExistente.get();
      genero.setNombre(generoActualizado.getNombre());
      return iGenero.save(genero);
    } else {
      return null;
    }
  }

  public boolean deleteGenero(int id) {
    try {
      iGenero.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
