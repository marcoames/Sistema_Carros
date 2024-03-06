package com.example.adaptadores.controllers;

import java.util.List;

import com.example.aplicacao.casosDeUso.CadastraCarrosUC;
import com.example.aplicacao.casosDeUso.CadastraEventoUC;
import com.example.aplicacao.casosDeUso.ConsultaCarrosUC;
import com.example.aplicacao.casosDeUso.ConsultaEstatisticasUC;
import com.example.aplicacao.casosDeUso.ConsultaEventosUC;
import com.example.aplicacao.casosDeUso.ConsultaPerformanceUC;
import com.example.aplicacao.dtos.EstatisticasDTO;
import com.example.aplicacao.dtos.PerformanceDTO;
import com.example.negocio.entidades.Carro;
import com.example.negocio.entidades.Evento;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasController {
    private ConsultaCarrosUC consultaCarrosUC;
    private CadastraCarrosUC cadastraCarrosUC;
    private ConsultaEventosUC consultaEventosUC;
    private CadastraEventoUC cadastraEventoUC;
    private ConsultaEstatisticasUC consultaEstatisticasUC;
    private ConsultaPerformanceUC consultaPerformanceUC;

    //@Autowired
    public CtrlCorridasController(ConsultaCarrosUC consultaCarrosUC, CadastraCarrosUC cadastraCarrosUC,
            ConsultaEventosUC consultaEventosUC, CadastraEventoUC cadastraEventoUC,
            ConsultaEstatisticasUC consultaEstatisticasUC, ConsultaPerformanceUC consultaPerformanceUC) {

        this.consultaCarrosUC = consultaCarrosUC;
        this.cadastraCarrosUC = cadastraCarrosUC;

        this.consultaEventosUC = consultaEventosUC;
        this.cadastraEventoUC = cadastraEventoUC;

        this.consultaEstatisticasUC = consultaEstatisticasUC;
        this.consultaPerformanceUC = consultaPerformanceUC;
    }


    @GetMapping("/carro")
    @CrossOrigin(origins = "*")
    public List<Carro> consultaCarro() {
        return consultaCarrosUC.run();
    }

    @PostMapping("/carro")
    @CrossOrigin(origins = "*")
    public boolean cadastraCarro(@RequestBody final Carro carro) {
        cadastraCarrosUC.run(carro);
        return true;
    }
    
    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return consultaEventosUC.run();
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestParam String placa, @RequestBody final Evento evento) {
        cadastraEventoUC.run(placa, evento);
        return true;
    }

    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam final Integer distancia) {
        return consultaEstatisticasUC.run(distancia);
    }

    @GetMapping("/aumentoPerformance")
    @CrossOrigin(origins = "*")
    public PerformanceDTO aumentoPerformance(@RequestParam final Integer distancia, @RequestParam final Integer ano) {
        return consultaPerformanceUC.run(distancia, ano);
    }
}
