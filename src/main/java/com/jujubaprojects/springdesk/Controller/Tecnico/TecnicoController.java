package com.jujubaprojects.springdesk.Controller.Tecnico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.springdesk.Repository.TecnicoRepository;
import com.jujubaprojects.springdesk.Util.UploadUtil;
import com.jujubaprojects.springdesk.enums.Perfil;
import com.jujubaprojects.springdesk.model.Cliente;
import com.jujubaprojects.springdesk.model.Tecnico;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {
    
    @Autowired
    TecnicoRepository tecnicoRepository;

    
    @GetMapping("/cadastro")
    public ModelAndView cadastrar(Cliente cliente){
        ModelAndView mv = new ModelAndView("tecnico/cadastro");
        mv.addObject("usuario", cliente);
        mv.addObject("perfils", Perfil.values());
        return mv;

    }
   @PostMapping("/cadastro-tecnico")
    public ModelAndView cadastro(@ModelAttribute Tecnico tecnico , @RequestParam("file") MultipartFile imagem){
       ModelAndView mv =  new ModelAndView("tecnico/cadastro");


       mv.addObject("usuario", tecnico);

       try {
        if(UploadUtil.fazerUploadImagem(imagem)){
            tecnico.setImagem(imagem.getOriginalFilename());
        }
        tecnicoRepository.save(tecnico);
        System.out.println("Salvo com sucesso: " + tecnico.getNome() + " " + tecnico.getImagem());
        return home();
       } catch (Exception e) {
            mv.addObject("msgErro", e.getMessage());
            System.out.println("Erro ao salvar " + e.getMessage());
            return mv;
       }

    }

    @GetMapping("/list-tecnicos")
    public ModelAndView tecnicosList(){
        ModelAndView mv = new ModelAndView("/tecnico/tecnico-list");
        mv.addObject("tecnicos", this.tecnicoRepository.findAll());
        return mv;

    }

    @GetMapping("/home-tecnico")
    public ModelAndView home(){
        ModelAndView mv =  new ModelAndView("home/index");
        return mv;
    }

}
