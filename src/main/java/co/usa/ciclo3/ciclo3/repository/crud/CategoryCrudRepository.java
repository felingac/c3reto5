package co.usa.ciclo3.ciclo3.repository.crud;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Category;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author xs
 */
/**
 *
 * Interface Crud repositorio para la entidad Category (categoría)
 */
public interface CategoryCrudRepository extends CrudRepository<Category,Integer>{
    /**
     *
     * Interface Crud repositorio para la entidad Category (categoría) vacío intencionalmente
     */
}