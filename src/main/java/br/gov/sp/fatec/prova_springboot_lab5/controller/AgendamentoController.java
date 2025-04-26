package br.gov.sp.fatec.prova_springboot_lab5.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.prova_springboot_lab5.entity.Agendamento;
import br.gov.sp.fatec.prova_springboot_lab5.service.AgendamentoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping
    public List<Agendamento> listartodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Agendamento cadastrar(@RequestBody Agendamento agendamento) {
        return service.cadastrar(agendamento);
    }

    @GetMapping("/buscar-data-intrucao")
    public List<Agendamento> buscarPorDataInstrucao(
        @RequestParam String instrucoes,
        @RequestParam("data")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime data) {
            return service.buscarPorDataEInstrucao(instrucoes, data);
        }
}
