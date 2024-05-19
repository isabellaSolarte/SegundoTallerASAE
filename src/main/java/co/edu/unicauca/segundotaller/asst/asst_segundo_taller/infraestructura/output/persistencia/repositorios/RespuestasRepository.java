package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.RespuestaEntity;

@Repository
public interface RespuestasRepository extends CrudRepository<RespuestaEntity, Integer> 
{
    @Query("SELECT count(*) FROM RespuestaEntity r  WHERE r.idRespuesta=?1")
    Integer existeRespuestaCodigo(int codigo);
}
