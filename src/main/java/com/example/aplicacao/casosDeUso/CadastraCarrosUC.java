package com.example.aplicacao.casosDeUso;

import com.example.negocio.entidades.Carro;
import com.example.negocio.servicos.ServicoCarro;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraCarrosUC {
    private ServicoCarro servicoCarro;

    //@Autowired
    public CadastraCarrosUC(ServicoCarro servicoCarro) {
        this.servicoCarro = servicoCarro;
    }
    
    public void run(Carro carro){
        servicoCarro.cadastraCarro(carro);
    }
    
}
