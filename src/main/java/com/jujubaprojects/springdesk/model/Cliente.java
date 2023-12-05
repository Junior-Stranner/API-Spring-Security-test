package com.jujubaprojects.springdesk.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa{
    

    @OneToMany(mappedBy = "cliente")
    private List<Chamado>chamados;

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
