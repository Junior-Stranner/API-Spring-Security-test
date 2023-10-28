package com.jujubaprojects.springdesk.enums;

public enum Prioridade {
    
    ALTA("Alta"),
    Media("Média"),
    BAIXA("Baixa");

    private String prioridade;

    private Prioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    
}
