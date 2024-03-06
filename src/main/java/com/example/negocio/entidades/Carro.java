package com.example.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carro {
    @Id
    private String placa;
    private String modelo;
    @Column(name = "anofabricacao")
    private int anoFabricacao;
    private String equipe;

    public Carro(String placa, String modelo, int anoFabricacao, String equipe) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.equipe = equipe;
        this.eventos = new ArrayList<>();
    }
        // Necessário para JPA
    public Carro() {}

    @OneToMany(fetch = FetchType.EAGER,
               mappedBy = "carro",
               cascade = CascadeType.ALL)
    private List<Evento> eventos;

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getEquipe() {
        return equipe;
    }
}

