package ifrn.pi.reservas.reservas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ifrn.pi.reservas.reservas.Models.Motorista;
import ifrn.pi.reservas.reservas.Repositories.MotoristaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
	private MotoristaRepository mr;
	
	@GetMapping("/formM")
	public String form(Motorista motorista) {
		return "cadastro/formM";
	}
	
	@PostMapping
	public String salvar( @Valid Motorista motorista) {
		System.out.println("Motorista:"+ motorista);
		mr.save(motorista);
		return "index";
	
	}
    
}
