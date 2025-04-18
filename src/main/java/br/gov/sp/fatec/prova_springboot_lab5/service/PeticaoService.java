package br.gov.sp.fatec.prova_springboot_lab5.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.gov.sp.fatec.prova_springboot_lab5.entity.Peticao;
import br.gov.sp.fatec.prova_springboot_lab5.repository.PeticaoRepository;

@Service
public class PeticaoService {

    @Autowired
    private PeticaoRepository repo;

    public PeticaoService(PeticaoRepository repo) {
        this.repo = repo;
    }

    public List<Peticao> listarTodos() {
        return repo.findAll();
    }

    public Peticao cadastrar(Peticao peticao) {
        // Validação: texto e status obrigatórios
        if (!StringUtils.hasText(peticao.getTexto())) {
            throw new IllegalArgumentException("Texto é obrigatório.");
        }

        if (!StringUtils.hasText(peticao.getStatus())) {
            throw new IllegalArgumentException("Status é obrigatório.");
        }

        // Se não vier data de entrega, define como agora
        if (peticao.getDataHoraCriacao() == null) {
            peticao.setDataHoraCriacao(LocalDateTime.now());
        }

        return repo.save(peticao);
    }

    public List<Peticao> buscarPorPrioridade(int prioridade) {
        return repo.buscarPorPrioridade(prioridade);
    }

    public List<Peticao> buscarPorDataExata(LocalDateTime data) {
        return repo.buscarPorDataExata(data);
    }
}

