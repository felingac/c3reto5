package co.usa.ciclo3.ciclo3.repository.crud;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Client;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author xs
 */
/**
 *
 * Interface Crud repositorio para la entidad Client (cliente)
 */
public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
    /**
     *
     * Interface Crud repositorio para la entidad Client (cliente) vacío intencionalmente
     */    
}