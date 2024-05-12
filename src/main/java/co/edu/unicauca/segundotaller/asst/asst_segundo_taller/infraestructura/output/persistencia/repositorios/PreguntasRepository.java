package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.PreguntaEntity;

@Repository
public interface PreguntasRepository extends CrudRepository<PreguntaEntity, Integer> {
}