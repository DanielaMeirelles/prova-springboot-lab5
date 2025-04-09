package br.gov.sp.fatec.prova_springboot_lab5.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "pet_peticao")
public class Peticao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;

    @Column(name = "pet_texto", nullable = false, length = 150)
    private String texto;

    @Column(name = "pet_data_hora_criacao", nullable = false)
    private LocalDateTime dataHoraCriacao;

    @Column(name = "pet_data_hora_submissao")
    private LocalDateTime dataHoraSubmissao;

    @Column(name = "pet_prioridade")
    private Integer prioridade;
    
    @Column(name = "pet_status", nullable = false, length = 5)
    private String status;


    public Peticao(Long id, String texto, LocalDateTime dataHoraCriacao, LocalDateTime dataHoraSubmissao,
            Integer prioridade, String status) {
        this.id = id;
        this.texto = texto;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraSubmissao = dataHoraSubmissao;
        this.prioridade = prioridade;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraSubmissao() {
        return dataHoraSubmissao;
    }

    public void setDataHoraSubmissao(LocalDateTime dataHoraSubmissao) {
        this.dataHoraSubmissao = dataHoraSubmissao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
