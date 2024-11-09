package com.juegos.juegos.models;

import jakarta.persistence.*;

@Entity
public class JuegoGenero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private int juegoId;

    @ManyToOne
    @JoinColumn(name = "juegoId", insertable = false, updatable = false)
    private Juego juego;

    @Column(nullable = false)
    private int generoId;

    @ManyToOne
    @JoinColumn(name = "generoId", insertable = false, updatable = false)
    private Genero genero;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJuegoId() {
        return juegoId;
    }

    public void setJuegoId(int juegoId) {
        this.juegoId = juegoId;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
