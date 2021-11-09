package co.usa.ciclo3.ciclo3.web;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author xs
 */
/**
 *
 * Controlador  Message
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {
    /**
     *
     * Método para traer los datos desde Servicios hacia la URL
     */     
    @Autowired
    private MessageService messageService;
    /**
     *
     * Método para mostrar los datos de la base de datos mediante URL
     * @return 
     */ 
    @GetMapping("/all")
    public List<Message> getMessage(){
        return messageService.getAll();
    }
    /**
     *
     * Método para mostrar un objeto específico de la base de datos mediante URL
     * @param id
     * @return 
     */      
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }
    /**
     *
     * Método para guardar información en la base de datos mediante URL
     * @param message
     * @return 
     */ 
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }
    /**
     *
     * Método para actualizar información en la base de datos mediante URL
     * @param message
     * @return 
     */     
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }    
    /**
     *
     * Método para eliminar información en la base de datos mediante URL
     * @param id
     * @return 
     */  
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable("id") int id){
        return messageService.deleteMessage(id);
    }    
}