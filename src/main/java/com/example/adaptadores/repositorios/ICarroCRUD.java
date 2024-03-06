package com.example.adaptadores.repositorios;

import java.util.List;

import com.example.negocio.entidades.Carro;

import org.springframework.data.repository.CrudRepository;

public interface ICarroCRUD extends CrudRepository<Carro,String> {
    List<Carro> findAll();
    Carro findByPlaca(String placa);
}
