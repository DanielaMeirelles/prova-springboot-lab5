package br.gov.sp.fatec.prova_springboot_lab5.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.prova_springboot_lab5.entity.Peticao;

public interface PeticaoRepository extends JpaRepository<Peticao, Long> {


    @Query("select p from Peticao p where p.texto = ?1")
    public Peticao buscarPeloTexto(String texto);

    @Query("SELECT p FROM Peticao p WHERE p.prioridade = :prioridade")
    public List<Peticao> buscarPorPrioridade(int prioridade);

    @Query("select p FROM Peticao p WHERE p.dataHoraCriacao = :data")
    public List<Peticao> buscarPorDataExata(@Param("data") LocalDateTime data);
}
