package ifrn.pi.reservas.reservas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import ifrn.pi.reservas.reservas.Enum.Perfil;
import ifrn.pi.reservas.reservas.Models.Aluno;
import ifrn.pi.reservas.reservas.Models.Motorista;
import ifrn.pi.reservas.reservas.Models.PasswordUtil;
import ifrn.pi.reservas.reservas.Repositories.MotoristaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
	private MotoristaRepository mr;
	
	@GetMapping("/formM")
	public ModelAndView form(Motorista motorista, Model model) {
	ModelAndView mv= new ModelAndView("cadastro/formM");
		 mv.addObject("motorista", motorista);
        Perfil[] profiles = {Perfil.MOTORISTA};
        mv.addObject("perfils", profiles);
		return mv;
	}
	
	@PostMapping("/cadastro")
public String salvar(@Valid Motorista motorista, BindingResult result) {
    if (result.hasErrors()) {
        return "cadastro/formM";
    }
    
    String hashSenha = PasswordUtil.encoder(motorista.getSenha());
    motorista.setSenha(hashSenha);
    
    mr.save(motorista);
    return "redirect:/onibus/home";
}

    
}
