package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.DocenteEntity;

public interface DocentesRepository extends CrudRepository<DocenteEntity, Integer> 
{
    @Query("SELECT count(*) FROM Docente d  WHERE d.iddocente=?1")
    Integer existeUsuarioPorCodigo(Integer codigo);
}
