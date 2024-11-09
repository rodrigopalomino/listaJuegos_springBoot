package com.juegos.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.juegos.juegos.models.JuegoGenero;


public interface IJuegoGenero extends JpaRepository<JuegoGenero,Integer>{}