package com.juegos.juegos.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.juegos.models.Comentario;
import com.juegos.juegos.repository.IComentario;


@Service
public class ComentarioService {

  @Autowired
  IComentario iComentario;

  public ArrayList<Comentario> getComentarios() {
    return (ArrayList<Comentario>) iComentario.findAll();
  }

  public Comentario createComentario(Comentario comentario) {
    return iComentario.save(comentario);
  }

  public Optional<Comentario> getComentarioById(int id) {
    return iComentario.findById(id);
  }

  public Comentario updateComentario(int id, Comentario comentarioActualizado) {
    Optional<Comentario> comentarioExistente = iComentario.findById(id);
    
    if (comentarioExistente.isPresent()) {
      Comentario comentario = comentarioExistente.get();
      comentario.setTexto(comentarioActualizado.getTexto());
      comentario.setFecha(comentarioActualizado.getFecha());
      comentario.setUsuario(comentarioActualizado.getUsuario());
      comentario.setJuego(comentarioActualizado.getJuego());
      return iComentario.save(comentario);
    } else {
      return null;
    }
  }

  public boolean deleteComentario(int id) {
    try {
      iComentario.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
