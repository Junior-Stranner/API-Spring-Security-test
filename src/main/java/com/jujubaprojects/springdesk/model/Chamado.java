package com.jujubaprojects.springdesk.model;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import com.jujubaprojects.springdesk.enums.Prioridade;
import com.jujubaprojects.springdesk.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chamado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamento;
    private String observacao;
    private Status status;
    private Prioridade prioridade;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

 

    public Chamado(){

    }



    public Chamado(int id, String titulo, LocalDate dataAbertura, LocalDate dataFechamento, String observacao,
            Status status, Prioridade prioridade, Cliente cliente, Tecnico tecnico) {
        this.id = id;
        this.titulo = titulo;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.observacao = observacao;
        this.status = status;
        this.prioridade = prioridade;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public LocalDate getDataAbertura() {
        return dataAbertura;
    }



    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }



    public LocalDate getDataFechamento() {
        return dataFechamento;
    }



    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }



    public String getObservacao() {
        return observacao;
    }



    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }



    public Status getStatus() {
        return status;
    }



    public void setStatus(Status status) {
        this.status = status;
    }



    public Prioridade getPrioridade() {
        return prioridade;
    }



    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }



    public Cliente getCliente() {
        return cliente;
    }



    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public Tecnico getTecnico() {
        return tecnico;
    }



    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }


    
    
}