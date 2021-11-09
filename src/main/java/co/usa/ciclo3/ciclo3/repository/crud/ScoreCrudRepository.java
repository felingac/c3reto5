package co.usa.ciclo3.ciclo3.repository.crud;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Score;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author xs
 */
/**
 *
 * Interface Crud repositorio para la entidad Score (calificación)
 */
public interface ScoreCrudRepository extends CrudRepository<Score,Integer>{
    /**
     *
     * Interface Crud repositorio para la entidad Score (calificación) vacío intencionalmente
     */      
}