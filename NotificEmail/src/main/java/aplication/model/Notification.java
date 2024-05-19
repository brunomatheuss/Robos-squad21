package aplication.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String responsavel;
    private String meioDeNotificacao;
    private String evento;
    private String mensagem;
    private String dadosDoRegistroDeExecucao;

    public Notification() {
    }

    public Notification(String responsavel, String meioDeNotificacao, String evento, String mensagem, String dadosDoRegistroDeExecucao) {
        this.responsavel = responsavel;
        this.meioDeNotificacao = meioDeNotificacao;
        this.evento = evento;
        this.mensagem = mensagem;
        this.dadosDoRegistroDeExecucao = dadosDoRegistroDeExecucao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getMeioDeNotificacao() {
        return meioDeNotificacao;
    }

    public void setMeioDeNotificacao(String meioDeNotificacao) {
        this.meioDeNotificacao = meioDeNotificacao;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDadosDoRegistroDeExecucao() {
        return dadosDoRegistroDeExecucao;
    }

    public void setDadosDoRegistroDeExecucao(String dadosDoRegistroDeExecucao) {
        this.dadosDoRegistroDeExecucao = dadosDoRegistroDeExecucao;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", responsavel='" + responsavel + '\'' +
                ", meioDeNotificacao='" + meioDeNotificacao + '\'' +
                ", evento='" + evento + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", dadosDoRegistroDeExecucao='" + dadosDoRegistroDeExecucao + '\'' +
                '}';
    }
}