package com.jujubaprojects.springdesk.Controller.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.springdesk.Repository.ClienteRepository;
import com.jujubaprojects.springdesk.enums.Perfil;
import com.jujubaprojects.springdesk.model.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/cadastro")
    public ModelAndView cadastrar(Cliente cliente){
        ModelAndView mv = new ModelAndView("cliente/cadastro");
        mv.addObject("usuario", cliente);
        mv.addObject("perfils", Perfil.values());
        return mv;

    }

    
}
