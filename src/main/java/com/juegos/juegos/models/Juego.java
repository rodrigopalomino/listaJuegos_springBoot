package com.juegos.juegos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Juego {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private int id;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String descripcion;

  @Column(nullable = false)
  private LocalDate fecha;

  @Column(nullable = false)
  private String desarrolladora;

  @Column(nullable = false)
  private String urlImg;

  @Column(nullable = false)
  private Integer cLikes = 0;

  @Column(nullable = false)
  private Integer cDislikes = 0;

  @Column(nullable = false)
  private Integer cComentarios = 0;

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  public LocalDate getFecha() {
    return fecha;
  }
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }
  public String getDesarrolladora() {
    return desarrolladora;
  }
  public void setDesarrolladora(String desarrolladora) {
    this.desarrolladora = desarrolladora;
  }
  public String getUrlImg() {
    return urlImg;
  }
  public void setUrlImg(String urlImg) {
    this.urlImg = urlImg;
  }
  public Integer getCLikes() {
    return cLikes;
  }
  public void setCLikes(Integer cLikes) {
    this.cLikes = cLikes;
  }
  public Integer getCDislikes() {
    return cDislikes;
  }
  public void setCDislikes(Integer cDislikes) {
    this.cDislikes = cDislikes;
  }
  public Integer getCComentarios() {
    return cComentarios;
  }
  public void setCComentarios(Integer cComentarios) {
    this.cComentarios = cComentarios;
  }
}
