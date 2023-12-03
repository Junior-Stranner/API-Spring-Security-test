package com.jujubaprojects.springdesk.Controller.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jujubaprojects.springdesk.Repository.ClienteRepository;
import com.jujubaprojects.springdesk.Util.UploadUtil;
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
   @PostMapping("/cadastro-cliente")
    public ModelAndView cadastro(@ModelAttribute Cliente cliente, @RequestParam("file") MultipartFile imagem){
       ModelAndView mv =  new ModelAndView("cliente/cadastro");


       mv.addObject("usuario", cliente);

       try {
        if(UploadUtil.fazerUploadImagem(imagem)){
            cliente.setImagem(imagem.getOriginalFilename());
        }
        clienteRepository.save(cliente);
        System.out.println("Salvo com sucesso: " + cliente.getNome() + " " + cliente.getImagem());
        return home();
       } catch (Exception e) {
            mv.addObject("msgErro", e.getMessage());
            System.out.println("Erro ao salvar " + e.getMessage());
            return mv;
       }

    }

    @GetMapping("/inicio")
    public ModelAndView home(){
        ModelAndView mv =  new ModelAndView("home/index");
        return mv;
    }

    
}
