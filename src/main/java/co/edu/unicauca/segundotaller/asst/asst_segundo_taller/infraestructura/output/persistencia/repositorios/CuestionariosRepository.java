package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.CuestionarioEntity;

@Repository
public interface CuestionariosRepository extends CrudRepository<CuestionarioEntity, Integer> {
    @Query("SELECT count(*) FROM CuestionarioEntity c WHERE c.titulo = ?1")
    Integer existeCuestionarioPorTitulo(String titulo);

    //listar cuestionario utilizando el id del docente
    //listar cuestionario con las KEYS
    List<CuestionarioEntity> findAllByOrderByTituloAsc();
}