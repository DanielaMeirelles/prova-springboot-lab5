package br.gov.sp.fatec.prova_springboot_lab5.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import br.gov.sp.fatec.prova_springboot_lab5.entity.Trabalho;
import br.gov.sp.fatec.prova_springboot_lab5.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repo;

    public TrabalhoService(TrabalhoRepository repo) {
        this.repo = repo;
    }

    public List<Trabalho> listarTodos() {
        return repo.findAll();
    }

    public Trabalho cadastrar(Trabalho trabalho) {
        // Validação: título e grupo obrigatórios
        if (!StringUtils.hasText(trabalho.getTitulo())) {
            throw new IllegalArgumentException("Título é obrigatório.");
        }

        if (!StringUtils.hasText(trabalho.getGrupo())) {
            throw new IllegalArgumentException("Grupo é obrigatório.");
        }

        // Se não vier data de entrega, define como agora
        if (trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }

        return repo.save(trabalho);
    }

    public List<Trabalho> buscarPorTituloENotaMinima(String palavra, int nota) {
        return repo.buscarPorTituloENotaMinima(palavra, nota);
    }

}

