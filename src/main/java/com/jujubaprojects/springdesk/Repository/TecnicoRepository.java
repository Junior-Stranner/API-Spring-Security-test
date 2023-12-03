package com.jujubaprojects.springdesk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.springdesk.model.Tecnico;

public interface TecnicoRepository extends JpaRepository <Tecnico,Integer>{
    
}
