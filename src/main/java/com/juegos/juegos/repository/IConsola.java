package com.juegos.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.juegos.models.Consola;

public interface IConsola extends JpaRepository<Consola,Integer>{}