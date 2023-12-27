package ifrn.pi.reservas.reservas.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifrn.pi.reservas.reservas.Models.Fila;
import ifrn.pi.reservas.reservas.Models.Onibus;
import ifrn.pi.reservas.reservas.Repositories.FilaRepository;
import ifrn.pi.reservas.reservas.Repositories.MotoristaRepository;
import ifrn.pi.reservas.reservas.Repositories.OnibusRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;




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
        if(onibus.getTipo().equals("normal")){
            onibus.setCapacidade((long) 60);
        }else{
            onibus.setCapacidade((long) 25);   
        }
        on.save(onibus);
        System.out.println("onibus:"+ onibus);
       return "redirect:/onibus/home";
    }


    @GetMapping("/home")
	public ModelAndView listagem(){
		 LocalDate hoje = LocalDate.now();

    List<Onibus> onibus = on.findAllByData(hoje);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("onibus", onibus);

		return mv;
	}
    @Autowired
    private FilaRepository fl;

    @GetMapping("/fila/{id}")
    public ModelAndView listafila(@PathVariable Long id, Fila fila){
     ModelAndView mv = new ModelAndView("cadastro/formI");
    Optional<Onibus> opt = on.findById(id);
    Onibus onibus = opt.get();
     List<Fila> filas = fl.findByOnibus(onibus);
     mv.addObject("filas", filas);
     return mv; 
    }

    @PostMapping("/fila/{idOnibus}")
    private String fila(@PathVariable Long idOnibus, Fila fila){
        Optional<Onibus> opt = on.findById(idOnibus);
        System.out.println(fila);

        Onibus onibus = opt.get();
        fila.setOnibus(onibus);
        fl.save(fila);
        System.out.println("fila:"+ fila);

        return "redirect:/onibus/home";

    }
    
}
