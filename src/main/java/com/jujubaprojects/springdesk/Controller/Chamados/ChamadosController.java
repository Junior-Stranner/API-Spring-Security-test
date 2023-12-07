package com.jujubaprojects.springdesk.Controller.Chamados;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.springdesk.Repository.ChamadoRepository;
import com.jujubaprojects.springdesk.Repository.TecnicoRepository;
import com.jujubaprojects.springdesk.enums.Prioridade;
import com.jujubaprojects.springdesk.model.Chamado;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/ticket")
public class ChamadosController {

   @Autowired
   private TecnicoRepository tecnicoRepository;

   @Autowired
   private ChamadoRepository chamadoRepository;
    
    @GetMapping("/criar")
    public ModelAndView ticket(){
        ModelAndView mv = new ModelAndView("chamados/ticket");
        mv.addObject("StatusChamado",Status.values());
        mv.addObject("Prioridade", Prioridade.values());
        mv.addObject("Tecnicos", this.tecnicoRepository.findAll());
        mv.addObject("ticket", new Chamado());
        return mv;
    }

   @PostMapping("/new-ticket")
   public ModelAndView newticket(Chamado chamado){
    ModelAndView mv = new ModelAndView("home");
    this.chamadoRepository.save(chamado);
    return mv;
   }
    
}
