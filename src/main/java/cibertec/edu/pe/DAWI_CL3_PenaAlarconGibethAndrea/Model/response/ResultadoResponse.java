package cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
    private Boolean respuesta;
    private String mensaje;
}
