package co.usa.ciclo3.ciclo3.repository;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Disfraz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import co.usa.ciclo3.ciclo3.repository.crud.DisfrazCrudRepository;
/**
 *
 * @author IngSB
 */
/**
 *
 * Repositorio para la entidad Disfraz
 */
@Repository
public class DisfrazRepository {
    @Autowired
    /**
     *
     * método para traer informacion del crud repository
     */
    private DisfrazCrudRepository costumeCrudRepository;
    /**
     *
     * método para buscar información
     * @return 
     */
    public List<Disfraz> getAll(){
        return (List<Disfraz>) costumeCrudRepository.findAll();
    }
    /**
     *
     * método para buscar dato específico
     * @param id
     * @return 
     */
    public Optional<Disfraz> getCostume(int id){
        return  costumeCrudRepository.findById(id);
    }
    /**
     *
     * método para guardar información
     * @param costume
     * @return 
     */
    public Disfraz save(Disfraz costume){
        return costumeCrudRepository.save(costume);
    }
    /**
     *
     * método para eliminar información
     * @param costume
     */
    public void delete (Disfraz costume){
        costumeCrudRepository.delete(costume);
    }   
}