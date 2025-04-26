package br.gov.sp.fatec.prova_springboot_lab5.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.prova_springboot_lab5.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("SELECT u FROM Agendamento u WHERE LOWER (u.instrucoes) AND u.data = :data")
    public List<Agendamento> buscarPorDataEInstrucao(@Param("instrucoes") String instrucoes, @Param("data") LocalDateTime data);
}
