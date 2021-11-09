package co.usa.ciclo3.ciclo3.service;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Disfraz;
import co.usa.ciclo3.ciclo3.repository.DisfrazRepository;
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
 * Servicios: Disfraz
 */
@Service
public class DisfrazService {
    /**
     *
     * Método para traer los datos desde el repositorio
     */ 
    @Autowired
    private DisfrazRepository costumeRepository;
    /**
     *
     * Método para el servicio de mostrar todo
     * @return 
     */ 
    public List<Disfraz> getAll(){
        return costumeRepository.getAll();
    }
    /**
     *
     * Método para el servicio de mostrar dato específico
     * @param id
     * @return 
     */ 
    public Optional<Disfraz> getCostume(int id){
        return costumeRepository.getCostume(id);
    }
    /**
     *
     * Método para el servicio de guardar todo
     * @param costume
     * @return 
     */ 
    public Disfraz save(Disfraz costume){
        if(costume.getId()==null){
            return costumeRepository.save(costume);
        }else{
            Optional<Disfraz> evt=costumeRepository.getCostume(costume.getId());
            if(evt == null){
                return costumeRepository.save(costume);
            }else{
                return costume;
            }
        }
    }/**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return /**
     *
     * Método para el servicio de actualizar todo
     * @param costume
     * @return 
     */ 
    public Disfraz update(Disfraz costume){
        if (costume.getId() != null) {
            Optional<Disfraz> actualizar = costumeRepository.getCostume(costume.getId());
            if (actualizar != null) {
                if (costume.getName() != null) {
                    actualizar.get().setName(costume.getName());
                }
                if (costume.getBrand() != null) {
                    actualizar.get().setBrand(costume.getBrand());
                }
                if (costume.getYear() != null) {
                    actualizar.get().setYear(costume.getYear());
                }
                if (costume.getDescription() != null) {
                    actualizar.get().setDescription(costume.getDescription());
                }

                costumeRepository.save(actualizar.get());
                return actualizar.get();
            } else {
                return costume;
            }
        } else {
            return costume;
        }
    }
    /**
     *
     * Método para el servicio de eliminar
     * @param costumeId
     * @return 
     */    
    public boolean deleteCostume(int costumeId){
        Boolean aBoolean = getCostume(costumeId).map(costume -> {
            costumeRepository.delete(costume);
            return true;
        }).orElse(false);
        return aBoolean;
    } 
}