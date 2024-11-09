package com.juegos.juegos.DTO;

import java.util.ArrayList;

import com.juegos.juegos.models.Juego;

public class JuegoRequestDTO {
  private Juego juego;
  private ArrayList<Integer> consolas;
  private ArrayList<Integer> generos;

  // Getters y setters
  public Juego getJuego() {
      return juego;
  }

  public void setJuego(Juego juego) {
      this.juego = juego;
  }

  public ArrayList<Integer> getConsolas() {
      return consolas;
  }

  public void setConsolas(ArrayList<Integer> consolas) {
      this.consolas = consolas;
  }

  public ArrayList<Integer> getGeneros() {
      return generos;
  }

  public void setGeneros(ArrayList<Integer> generos) {
      this.generos = generos;
  }
}
