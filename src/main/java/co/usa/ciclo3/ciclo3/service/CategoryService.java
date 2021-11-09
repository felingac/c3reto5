package co.usa.ciclo3.ciclo3.service;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
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
 * Servicios: Category
 */
@Service
public class CategoryService {
    /**
     *
     * Método para traer los datos desde el repositorio
     */ 
    @Autowired
    private CategoryRepository categoryRepository;
    /**
     *
     * Método para el servicio de mostrar todo
     * @return 
     */
    public List<Category> getAll(){
        return  categoryRepository.getAll();
    }
    /**
     *
     * Método para el servicio de mostrar dato específico
     * @param id
     * @return 
     */ 
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    /**
     *
     * Método para el servicio de guardar todo
     * @param category
     * @return 
     */ 
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> evt=categoryRepository.getCategory(category.getId());
            if(evt == null){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    /**
     *
     * Método para el servicio de actualizar todo
     * @param category
     * @return 
     */  
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>actualizar=categoryRepository.getCategory(category.getId());
            if(actualizar != null){
                if(category.getName()!=null){
                    actualizar.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    actualizar.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(actualizar.get());
            }
        }
        return category;
    }
    /**
     *
     * Método para el servicio de eliminar
     * @param id
     * @return 
     */    
    public boolean deleteCategory(int id){
        Boolean borrar = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return borrar;
    }    
}