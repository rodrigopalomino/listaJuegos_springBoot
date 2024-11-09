package com.juegos.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.juegos.models.Comentario;

public interface IComentario extends JpaRepository<Comentario,Integer>{}