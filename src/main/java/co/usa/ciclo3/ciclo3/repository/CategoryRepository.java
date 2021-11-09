package co.usa.ciclo3.ciclo3.repository;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;
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
 * Repositorio para la entidad Category (categoría)
 */
@Repository
public class CategoryRepository {
    @Autowired
    /**
     *
     * método para traer informacion del crud repository
     */
    private CategoryCrudRepository categoryCrudRepository;
    /**
     *
     * método para buscar información
     * @return 
     */
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    /**
     *
     * método para buscar dato específico
     * @param id
     * @return 
     */    
    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    /**
     *
     * método para guardar información
     * @param category
     * @return 
     */    
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
    /**
     *
     * método para eliminar información
     * @param category
     */      
    public void delete (Category category){
        categoryCrudRepository.delete(category);
    }
}