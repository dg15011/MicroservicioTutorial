package com.carro.service.carroservice.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String marca;
    private String modelo;
    private int usuarioId;

    public Carro() {
    }

    public Carro(int id, String marca, String modelo, int usuarioid) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.usuarioId=usuarioid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getUsuarioid() {
        return usuarioId;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioId = usuarioid;
    }
}
