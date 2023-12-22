package ifrn.pi.reservas.reservas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifrn.pi.reservas.reservas.Models.Onibus;
import ifrn.pi.reservas.reservas.Repositories.MotoristaRepository;
import ifrn.pi.reservas.reservas.Repositories.OnibusRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/onibus")
public class OnibusController {
    
    @Autowired
    private MotoristaRepository mr;
    @Autowired
    private OnibusRepository on;


    @GetMapping("/formO")
    public ModelAndView form(Onibus onibus){
        ModelAndView mv = new ModelAndView("cadastro/formOn");
        mv.addObject("motoristas", mr.findAll());
        mv.addObject("onibus", onibus);
        return mv;
    }
    @PostMapping
    public String salvar(Onibus onibus){
        if(onibus.getTipo().equals("Normal")){
            onibus.setCapacidade((long) 64);
        }
        on.save(onibus);
        System.out.println("onibus:"+ onibus);
        return"index";
    }
    
}
