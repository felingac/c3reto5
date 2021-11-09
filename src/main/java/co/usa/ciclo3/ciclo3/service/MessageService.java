package co.usa.ciclo3.ciclo3.service;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author xs
 */
/**
 *
 * Servicios: Message
 */
@Service
public class MessageService {
    /**
     *
     * Método para traer los datos desde el repositorio
     */  
    @Autowired
    private MessageRepository messageRepository;
    /**
     *
     * Método para el servicio de mostrar todo
     * @return 
     */ 
    public List<Message> getAll(){
        return  messageRepository.getAll();
    }
    /**
     *
     * Método para el servicio de mostrar dato específico
     * @param id
     * @return 
     */     
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    /**
     *
     * Método para el servicio de guardar todo
     * @param message
     * @return 
     */ 
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> paux=messageRepository.getMessage(message.getIdMessage());
            if(paux == null){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    /**
     *
     * Método para el servicio de actualizar todo
     * @param message
     * @return 
     */  
    public Message update(Message message){
        if (message.getIdMessage() != null) {
            Optional<Message> actualizar = messageRepository.getMessage(message.getIdMessage());
            if (actualizar != null) {
                if (message.getMessageText() != null) {
                    actualizar.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(actualizar.get());
                return actualizar.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }
    /**
     *
     * Método para el servicio de eliminar
     * @param id
     * @return 
     */   
    public boolean deleteMessage(int id){
        Boolean aBoolean = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }     
}