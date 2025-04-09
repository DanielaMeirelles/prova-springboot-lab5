package br.gov.sp.fatec.prova_springboot_lab5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.prova_springboot_lab5.entity.Peticao;

public interface PeticaoRepository extends JpaRepository<Peticao, Long> {

    @Query("SELECT t FROM Peticao t WHERE LOWER(t.texto) LIKE LOWER(CONCAT('%', :texto, '%')) AND t.prioridade > :prioridade")
    public List<Peticao> buscarPorPeticao(String texto, int prioridade);

}
