package br.gov.sp.fatec.prova_springboot_lab5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.prova_springboot_lab5.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    @Query("SELECT t FROM Trabalho t WHERE LOWER(t.titulo) LIKE LOWER(CONCAT('%', :palavra, '%')) AND t.nota > :nota")
    public List<Trabalho> buscarPorTituloENotaMinima(String palavra, int nota);

}
