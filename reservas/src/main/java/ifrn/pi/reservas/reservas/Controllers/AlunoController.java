package ifrn.pi.reservas.reservas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ifrn.pi.reservas.reservas.Models.Aluno;
import ifrn.pi.reservas.reservas.Repositories.AlunoRepository;


@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
	private AlunoRepository al;
	
	@GetMapping("/formA")
	public String form(Aluno aluno) {
		return "cadastro/formA";
	}
	
	@PostMapping
	public String salvar(Aluno aluno) {
		
		System.out.println(aluno);
		al.save(aluno);
		
		return "index";
	}
    
}
