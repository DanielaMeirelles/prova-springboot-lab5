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

import br.gov.sp.fatec.prova_springboot_lab5.entity.Peticao;
import br.gov.sp.fatec.prova_springboot_lab5.service.PeticaoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/peticao")
public class PeticaoController {

    @Autowired
    private PeticaoService service;

    @GetMapping
    public List<Peticao> listartodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Peticao cadastrar(@RequestBody Peticao peticao) {
        return service.cadastrar(peticao);
    }

    @GetMapping("/pri")
    public List<Peticao> buscarPorPrioridade(
        @RequestParam int prioridade) {
            return service.buscarPorPrioridade(prioridade);
        }

    @GetMapping("/buscar-por-data")
    public List<Peticao> buscarPorDataExata(
        @RequestParam("data")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime data) {
            return service.buscarPorDataExata(data);
        }
}
