package com.jujubaprojects.springdesk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.springdesk.model.Chamado;

public interface ChamadaRepository extends JpaRepository<Chamado , Integer>{
    
}
