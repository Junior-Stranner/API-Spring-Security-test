package com.jujubaprojects.springdesk.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Tecnico extends Pessoa{
    
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado>chamados;

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }


    
}
