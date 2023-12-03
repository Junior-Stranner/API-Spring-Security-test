package com.jujubaprojects.springdesk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.springdesk.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    
}
