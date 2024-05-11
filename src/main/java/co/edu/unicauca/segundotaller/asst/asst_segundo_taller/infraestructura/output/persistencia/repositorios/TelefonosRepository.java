package co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.repositorios;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import co.edu.unicauca.segundotaller.asst.asst_segundo_taller.infraestructura.output.persistencia.entities.Telefono;

@Repository
public interface TelefonosRepository extends CrudRepository<Telefono, Integer> {
}
