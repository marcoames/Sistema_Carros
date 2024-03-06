package com.example.aplicacao.casosDeUso;

import com.example.negocio.entidades.Evento;
import com.example.negocio.servicos.ServicoEvento;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraEventoUC {
    private ServicoEvento servicoEvento;

    //@Autowired
    public CadastraEventoUC(ServicoEvento servicoEvento) {
        this.servicoEvento = servicoEvento;
    }
    
    public void run(String placa, Evento evento){
        servicoEvento.cadastra(placa, evento);
    }    
}
