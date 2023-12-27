package ifrn.pi.reservas.reservas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.reservas.reservas.Enum.Perfil;
import ifrn.pi.reservas.reservas.Models.Admin;
import ifrn.pi.reservas.reservas.Models.Aluno;
import ifrn.pi.reservas.reservas.Models.PasswordUtil;
import ifrn.pi.reservas.reservas.Repositories.AdminRepository;
import jakarta.validation.Valid;


@Controller
public class Index {

    @Autowired
    private AdminRepository ad;

    @GetMapping("/")
    public String index() {
        return "redirect:/onibus/home";
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

     @GetMapping("/admin")
    public ModelAndView admin(Admin admin){
        ModelAndView mv= new ModelAndView("cadastro/admin");
		 mv.addObject("admin", admin);
        Perfil[] profiles = {Perfil.ADMIN};
        mv.addObject("perfils", profiles);
		return mv;
    }

    @PostMapping
    public String admin(@Valid Admin admin, BindingResult result) {
    if (result.hasErrors()) {
        // Tratar erros de validação, se necessário
        return "cadastro/formA";
    }
    
    String hashSenha = PasswordUtil.encoder(admin.getSenha());
    admin.setSenha(hashSenha);
    
    ad.save(admin);
    System.out.println(admin);
    return "redirect:/onibus/home";
}


    
    
}
