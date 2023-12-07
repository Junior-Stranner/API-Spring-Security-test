package com.jujubaprojects.springdesk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.springdesk.Repository.ChamadoRepository;

@RestController
public class StartController {
    
    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping("/home")
    public ModelAndView start(){
        ModelAndView mv = new ModelAndView("home/index");
        mv.addObject("chamadosList", chamadoRepository.findAll());
        return mv;
    }
}
