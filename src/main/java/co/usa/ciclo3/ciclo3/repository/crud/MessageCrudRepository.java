package co.usa.ciclo3.ciclo3.repository.crud;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author xs
 */
/**
 *
 * Interface Crud repositorio para la entidad Message (mensaje)
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer>{
    /**
     *
     * Interface Crud repositorio para la entidad Message (mensaje) vacío intencionalmente
     */       
}