package ifrn.pi.reservas.reservas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.reservas.reservas.Enum.Perfil;
import ifrn.pi.reservas.reservas.Models.Aluno;
import ifrn.pi.reservas.reservas.Models.PasswordUtil;
import ifrn.pi.reservas.reservas.Repositories.AlunoRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
	private AlunoRepository al;
	
	@GetMapping("/formA")
	public ModelAndView form(Aluno aluno) {
		ModelAndView mv= new ModelAndView("cadastro/formA");
		 mv.addObject("aluno", aluno);
        Perfil[] profiles = {Perfil.ALUNO};
        mv.addObject("perfils", profiles);
		return mv;
	}
	
	@PostMapping("/cadastro")
public String salvar(@Valid Aluno aluno, BindingResult result) {
    if (result.hasErrors()) {
        // Tratar erros de validação, se necessário
        return "cadastro/admin";
    }
    
    String hashSenha = PasswordUtil.encoder(aluno.getSenha());
    aluno.setSenha(hashSenha);
    
    al.save(aluno);
    return "redirect:/onibus/home";
}
}
