package co.usa.ciclo3.ciclo3.repository;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.crud.MessageCrudRepository;
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
 * Repositorio para la entidad Message (mensaje)
 */
@Repository
public class MessageRepository {
    @Autowired
    /**
     *
     * método para traer informacion del crud repository
     */
    private MessageCrudRepository messageCrudRepository;
    /**
     *
     * método para buscar información
     * @return 
     */
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
        /**
     *
     * método para buscar dato específico
     * @param id
     * @return 
     */
    public Optional<Message>getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    /**
     *
     * método para guardar información
     * @param message
     * @return 
     */    
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    /**
     *
     * método para eliminar información
     * @param message
     */
    public void delete (Message message){
        messageCrudRepository.delete(message);
    }    
}