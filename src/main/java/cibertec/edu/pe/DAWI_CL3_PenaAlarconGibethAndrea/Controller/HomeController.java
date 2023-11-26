package cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
