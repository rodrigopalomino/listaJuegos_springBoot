package com.juegos.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.juegos.models.Valoracion;


public interface IValoracion extends JpaRepository<Valoracion,Integer>{}