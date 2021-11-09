package co.usa.ciclo3.ciclo3.service;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
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
 * Servicios: Client
 */
@Service
public class ClientService {
    /**
     *
     * Método para traer los datos desde el repositorio
     */ 
    @Autowired
    private ClientRepository clientRepository;
    /**
     *
     * Método para el servicio de mostrar todo
     * @return 
     */
    public List<Client> getAll(){
        return  clientRepository.getAll();
    }
    /**
     *
     * Método para el servicio de mostrar dato específico
     * @param id
     * @return 
     */ 
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    /**
     *
     * Método para el servicio de guardar todo
     * @param client
     * @return 
     */ 
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> evt=clientRepository.getClient(client.getIdClient());
            if(evt == null){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    /**
     *
     * Método para el servicio de actualizar todo
     * @param client
     * @return 
     */    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> actualizar = clientRepository.getClient(client.getIdClient());
            if (actualizar != null) {
                if (client.getName() != null) {
                    actualizar.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    actualizar.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    actualizar.get().setPassword(client.getPassword());
                }
                clientRepository.save(actualizar.get());
                return actualizar.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }
    /**
     *
     * Método para el servicio de eliminar
     * @param clientId
     * @return 
     */      
    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }  
}