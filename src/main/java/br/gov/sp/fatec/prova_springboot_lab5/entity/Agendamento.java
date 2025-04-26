package br.gov.sp.fatec.prova_springboot_lab5.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "age_agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "age_id")
    private Long id;

    @Column(name = "age_instrucoes", length = 150)
    private String instrucoes;

    @Column(name = "age_valor")
    private Float valor;

    @Column(name = "age_data_hora_inicio", nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(name = "age_duracao_prevista")
    private Integer duracaoPrevista;

    public Agendamento() {
    }

    public Agendamento(Long id, String instrucoes, Float valor, LocalDateTime dataHoraInicio, Integer duracaoPrevista) {
        this.id = id;
        this.instrucoes = instrucoes;
        this.valor = valor;
        this.dataHoraInicio = dataHoraInicio;
        this.duracaoPrevista = duracaoPrevista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Integer getDuracaoPrevista() {
        return duracaoPrevista;
    }

    public void setDuracaoPrevista(Integer duracaoPrevista) {
        this.duracaoPrevista = duracaoPrevista;
    }

        
}
