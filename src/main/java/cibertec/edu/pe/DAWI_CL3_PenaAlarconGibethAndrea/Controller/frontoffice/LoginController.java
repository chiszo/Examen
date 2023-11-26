package cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Controller.frontoffice;

import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Model.bd.Usuario;
import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Model.response.ResultadoResponse;
import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(){
    return "frontoffice/auth/login";
    }

    @GetMapping("/registrar")
    public String registro(){
        return "frontoffice/auth/registro";
    }

    @PostMapping("/guardarusuario")
    public String guardarusuario(@ModelAttribute Usuario usuario){
        usuarioService.saveUser(usuario);
        return "redirect:/auth/login";
    }

    @GetMapping("/actualizar")
    public String actualizar(String id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null ;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        @SuppressWarnings("null")
        String userName = userDetails.getUsername();
        id= userName;
        usuarioService.findByNomusuario(id);
        return "frontoffice/auth/frmmanteuser";
    }

    @PostMapping("/actualizarusuario")
    @ResponseBody
    public ResultadoResponse actualizarusuario(@RequestBody Usuario objUsuario, Model model){
        model.addAttribute("msj",usuarioService.actualizarclave(objUsuario));
        return usuarioService.actualizarclave(objUsuario);
    }

    @GetMapping("/login-success")
    public String loginsuccess(){
        return "frontoffice/auth/dashboard";
    }
}
