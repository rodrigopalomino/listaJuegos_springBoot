package com.juegos.juegos.models;

import jakarta.persistence.*;

@Entity
public class JuegoConsola {

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
    private int consolaId;

    @ManyToOne
    @JoinColumn(name = "consolaId", insertable = false, updatable = false)
    private Consola consola;

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

    public int getConsolaId() {
        return consolaId;
    }

    public void setConsolaId(int consolaId) {
        this.consolaId = consolaId;
    }

    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }
}
