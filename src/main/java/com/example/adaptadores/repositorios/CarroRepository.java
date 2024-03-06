package com.example.adaptadores.repositorios;

import java.util.List;

import com.example.negocio.entidades.Carro;
import com.example.negocio.repositorios.ICarroRepository;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarroRepository implements ICarroRepository {
    private ICarroCRUD carroCRUD;

    //@Autowired
    public CarroRepository(ICarroCRUD carroCRUD) {
        this.carroCRUD = carroCRUD;

    }
    
    public List<Carro> todos() {
        List<Carro> resp = carroCRUD.findAll();
        return resp;
    }

    public void removeTodos(){
        carroCRUD.deleteAll();
    }

    public boolean cadastra(Carro carro){
        carroCRUD.save(carro);
        return true;
    }
}
