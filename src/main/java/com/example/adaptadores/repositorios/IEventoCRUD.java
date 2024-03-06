package com.example.adaptadores.repositorios;

import java.util.List;

import com.example.negocio.entidades.Evento;

import org.springframework.data.repository.CrudRepository;

public interface IEventoCRUD extends CrudRepository<Evento,Integer> {
    List<Evento> findAll();
    Evento findById(int id);
}
