package br.gov.sp.fatec.prova_springboot_lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public Peticao cadastrar(Peticao peticao) {
        return service.cadastrar(peticao);
    }
}
