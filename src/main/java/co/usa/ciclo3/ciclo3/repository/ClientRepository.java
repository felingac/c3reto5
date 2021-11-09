package co.usa.ciclo3.ciclo3.repository;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author xs
 */
/**
 *
 * Repositorio para la entidad Client (cliente)
 */
@Repository
public class ClientRepository {
    @Autowired
    /**
     *
     * método para traer informacion del crud repository
     */
    private ClientCrudRepository clientCrudRepository;
    /**
     *
     * método para buscar información
     * @return 
     */
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    /**
     *
     * método para buscar dato específico
     * @param id
     * @return 
     */    
    public Optional<Client>getClient(int id){
        return clientCrudRepository.findById(id);
    }
    /**
     *
     * método para guardar información
     * @param client
     * @return 
     */
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    /**
     *
     * método para eliminar información
     * @param client
     */
    public void delete (Client client){
        clientCrudRepository.delete(client);
    }
}