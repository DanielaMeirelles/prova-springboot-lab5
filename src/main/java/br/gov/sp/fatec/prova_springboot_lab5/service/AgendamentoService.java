package br.gov.sp.fatec.prova_springboot_lab5.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.gov.sp.fatec.prova_springboot_lab5.entity.Agendamento;
import br.gov.sp.fatec.prova_springboot_lab5.repository.AgendamentoRepository;


@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repo;

    public AgendamentoService (AgendamentoRepository repo) {
        this.repo = repo;
    }

    public List<Agendamento> listarTodos() {
        return repo.findAll();
    }

    public Agendamento cadastrar(Agendamento agendamento) {
        if (!StringUtils.hasText(agendamento.getInstrucoes())) {
            throw new IllegalArgumentException("Instruções é obrigatório.");
        }

        if (agendamento.getDataHoraInicio() == null) {
            agendamento.setDataHoraInicio(LocalDateTime.now());
        }

        return repo.save(agendamento);
    }

    public List<Agendamento> buscarPorDataEInstrucao(String instrucoes, LocalDateTime data) {
        return repo.buscarPorDataEInstrucao(instrucoes, data);
    }
}

