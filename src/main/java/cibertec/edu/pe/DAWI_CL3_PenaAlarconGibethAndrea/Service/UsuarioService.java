package cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Service;

import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Model.bd.Rol;
import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Model.bd.Usuario;
import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Model.response.ResultadoResponse;
import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Repository.RolRepository;
import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder();
    public Usuario findByNomusuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }
    public Usuario saveUser(Usuario usuario){
        usuario.setPassword(
                bCryptPasswordEncoder.encode(usuario.getPassword())
        );
        Rol usuarioRol = rolRepository.findByNomrol("USER");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUser(int idusuario){
        return usuarioRepository.findByIdusuario(idusuario);
    }

    public ResultadoResponse actualizarclave(Usuario user){
        Usuario nuevoUsuario =new Usuario();
        nuevoUsuario.setIdusuario(user.getIdusuario());
        nuevoUsuario.setNomusuario(user.getNomusuario());
        nuevoUsuario.setEmail(user.getEmail());
        nuevoUsuario.setNombres(user.getNombres());
        nuevoUsuario.setApellidos(user.getApellidos());
        nuevoUsuario.setActivo(user.isActivo());
        user.setPassword(
                bCryptPasswordEncoder.encode(user.getPassword())
        );
        Rol usuarioRol = rolRepository.findByNomrol("USER");
        user.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        user.setActivo(true);
        String mensaje = "Clave actualizada";
        Boolean respuesta = true;

        try {
            usuarioRepository.save(nuevoUsuario);
        }catch (Exception ex){
            mensaje= "Usuario NO actualizado";
            respuesta = false;
        }

        return ResultadoResponse.builder().respuesta(respuesta).mensaje(mensaje).build();
    }
}
