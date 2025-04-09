package br.gov.sp.fatec.prova_springboot_lab5.controller;

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
