package com.example.adaptadores.repositorios;

import java.util.List;

import com.example.negocio.entidades.Carro;
import com.example.negocio.entidades.Evento;
import com.example.negocio.repositorios.IEventoRepository;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EventoRepository implements IEventoRepository {
    private IEventoCRUD eventoCRUD;
    private ICarroCRUD carroCRUD;
    
    //@Autowired
    public EventoRepository(IEventoCRUD eventoCRUD, 
                            ICarroCRUD carroCRUD) {
        this.eventoCRUD = eventoCRUD;
    }

    public List<Evento> todos() {
        return eventoCRUD.findAll();
    }

    public boolean cadastra(String placa, Evento evento){
        Carro carro = carroCRUD.findByPlaca(placa);
        evento.setCarro(carro);
        eventoCRUD.save(evento);
        return true;
    }
}
