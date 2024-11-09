package com.juegos.juegos.models;

import jakarta.persistence.*;

@Entity
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    
    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private int usuarioId;

    @ManyToOne
    @JoinColumn(name = "usuarioId", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private int juegoId;

    @ManyToOne
    @JoinColumn(name = "juegoId", insertable = false, updatable = false)
    private Juego juego;

    // Constructores
    public Valoracion() {
    }

    public Valoracion(String tipo, int usuarioId, int juegoId) {
        this.tipo = tipo;
        this.usuarioId = usuarioId;
        this.juegoId = juegoId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
}
