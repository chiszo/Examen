package cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Model.bd.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Integer idusuario;
    private String nomusuario;
    private String email;
    private String password;
    private String nombres;
    private String apellidos;
    private boolean activo;
}
