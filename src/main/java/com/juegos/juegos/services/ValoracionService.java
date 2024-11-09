package com.juegos.juegos.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.juegos.models.Valoracion;
import com.juegos.juegos.repository.IValoracion;


@Service
public class ValoracionService {

  @Autowired
  IValoracion iValoracion;

  public ArrayList<Valoracion> getValoraciones() {
    return (ArrayList<Valoracion>) iValoracion.findAll();
  }

  public Valoracion createValoracion(Valoracion valoracion) {
    return iValoracion.save(valoracion);
  }

  public Optional<Valoracion> getValoracionById(int id) {
    return iValoracion.findById(id);
  }

  public Valoracion updateValoracion(int id, Valoracion valoracionActualizada) {
    Optional<Valoracion> valoracionExistente = iValoracion.findById(id);
    
    if (valoracionExistente.isPresent()) {
      Valoracion valoracion = valoracionExistente.get();
      valoracion.setTipo(valoracionActualizada.getTipo());
      valoracion.setUsuario(valoracionActualizada.getUsuario());
      valoracion.setJuego(valoracionActualizada.getJuego());
      return iValoracion.save(valoracion);
    } else {
      return null;
    }
  }

  public boolean deleteValoracion(int id) {
    try {
      iValoracion.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
