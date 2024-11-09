package com.juegos.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.juegos.juegos.models.Juego;

public interface IJuego extends JpaRepository<Juego,Integer>{}