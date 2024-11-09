package com.juegos.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.juegos.models.Genero;

public interface IGenero extends JpaRepository<Genero,Integer>{}