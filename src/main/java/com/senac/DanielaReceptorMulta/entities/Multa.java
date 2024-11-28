package com.senac.DanielaReceptorMulta.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "multa")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "multa_id", nullable = false)
    private int id;

    @Column(name = "multa_valor", nullable = false, length = 255)
    private String valor;

    @Column(name = "multa_status", nullable = false)
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}