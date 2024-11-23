package com.juegos.juegos.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.juegos.models.Juego;
import com.juegos.juegos.repository.IJuego;
import com.juegos.juegos.repository.IJuegoConsola;
import com.juegos.juegos.repository.IJuegoGenero;


@Service
public class JuegoService {

  @Autowired
  IJuego iJuego;

  @Autowired
  IJuegoConsola iJuegoConsola;

  @Autowired
  IJuegoGenero iJuegoGenero;

  public ArrayList<Juego> getJuegos() {
    return (ArrayList<Juego>) iJuego.findAll();
  }

  public ArrayList<Juego> getJuegosByNombre(String nombre) {
    return (ArrayList<Juego>) iJuego.findByNombreContainingIgnoreCase(nombre);
  }

  public Juego createJuego(Juego juego) {
    return iJuego.save(juego);
  }

  public Optional<Juego> getJuegoById(int id) {
    return iJuego.findById(id);
  }

  public Juego updateJuego(int id, Juego juegoActualizado) {
    Optional<Juego> juegoExistente = iJuego.findById(id);
    
    if (juegoExistente.isPresent()) {
      Juego juego = juegoExistente.get();
      juego.setNombre(juegoActualizado.getNombre());
      juego.setDescripcion(juegoActualizado.getDescripcion());
      juego.setFecha(juegoActualizado.getFecha());
      juego.setDesarrolladora(juegoActualizado.getDesarrolladora());
      juego.setUrlImg(juegoActualizado.getUrlImg());
      juego.setCLikes(juegoActualizado.getCLikes());
      juego.setCDislikes(juegoActualizado.getCDislikes());
      juego.setCComentarios(juegoActualizado.getCComentarios());
      return iJuego.save(juego);
    } else {
      return null; 
    }
  }

  public boolean deleteJuego(int id) {
    try {
      iJuego.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
