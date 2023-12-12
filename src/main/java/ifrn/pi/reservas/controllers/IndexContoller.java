package ifrn.pi.reservas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexContoller {
	
	@RequestMapping("/")
	public String index() {
		System.out.println("Chamou o método index");
;		return "home";
	}

}
