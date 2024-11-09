package com.juegos.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.juegos.models.JuegoConsola;


public interface IJuegoConsola extends JpaRepository<JuegoConsola,Integer>{}