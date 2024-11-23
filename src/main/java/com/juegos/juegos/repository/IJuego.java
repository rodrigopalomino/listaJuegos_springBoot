package com.juegos.juegos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.juegos.models.Juego;

public interface IJuego extends JpaRepository<Juego,Integer>{

  List<Juego> findByNombreContainingIgnoreCase(String nombre);

}