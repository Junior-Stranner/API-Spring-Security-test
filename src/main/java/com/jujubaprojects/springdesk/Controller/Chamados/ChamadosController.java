package com.jujubaprojects.springdesk.Controller.Chamados;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.springdesk.enums.Prioridade;

@RestController
@RequestMapping("/ticket")
public class ChamadosController {
    
    @GetMapping("/criar")
    public ModelAndView ticket(){
        ModelAndView mv = new ModelAndView("/chamados/ticket");
        mv.addObject("StatusChamado",Status.values());
        mv.addObject("Prioridade", Prioridade.values());
        return mv;
    }
}
