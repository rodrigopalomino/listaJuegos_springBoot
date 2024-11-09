package com.juegos.juegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.juegos.models.Usuario;


public interface IUsuario extends JpaRepository<Usuario,Integer>{}