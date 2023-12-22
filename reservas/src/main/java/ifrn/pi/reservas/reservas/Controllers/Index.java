package ifrn.pi.reservas.reservas.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Index {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    
}
