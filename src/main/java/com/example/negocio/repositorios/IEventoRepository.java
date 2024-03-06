package com.example.negocio.repositorios;

import java.util.List;

import com.example.negocio.entidades.Evento;

public interface IEventoRepository {
    List<Evento> todos();
    boolean cadastra(String placa, Evento evento);
}   
