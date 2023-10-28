package com.jujubaprojects.springdesk.enums;

public enum Status {
    
    ABERTO("Aberto"),
    ANDAMENTO("EM ANdamento"),
    FECHADO("Fechado");

    private String status;


  

    private Status(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    
}
