package cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Repository;

import cibertec.edu.pe.DAWI_CL3_PenaAlarconGibethAndrea.Model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, Integer>
{
    Usuario findByNomusuario(String nomusuario);
}
