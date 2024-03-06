package com.example.negocio.servicos;

import java.util.List;

import com.example.negocio.entidades.Evento;
import com.example.negocio.repositorios.IEventoRepository;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEvento {
    private IEventoRepository eventoRep;

    //@Autowired
    public ServicoEvento(IEventoRepository eventoRep){
        this.eventoRep = eventoRep;
    } 

    public List<Evento> todos(){
        return eventoRep.todos();
    }

    public void cadastra(String placa, Evento evento){
        eventoRep.cadastra(placa, evento);
    }
    
}
