package cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Controller;

import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Service.UsuarioService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private UsuarioService usuarioService;
    @GetMapping("/home")
    public String home(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null ;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        @SuppressWarnings("null")
        String userName = userDetails.getUsername();
        model.addAttribute("nombre",userName);
        return "home";
    }
}
