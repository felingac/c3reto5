package co.usa.ciclo3.ciclo3.repository;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.repository.crud.ScoreCrudRepository;
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
 * Repositorio para la entidad Score (calificación)
 */
@Repository
public class ScoreRepository {
    @Autowired
    /**
     *
     * método para traer informacion del crud repository
     */    
    private ScoreCrudRepository scoreCrudRepository;
    /**
     *
     * método para buscar información
     * @return 
     */
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    /**
     *
     * método para buscar dato específico
     * @param id
     * @return 
     */    
    public Optional<Score>getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    /**
     *
     * método para guardar información
     * @param score
     * @return 
     */    
    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }
    /**
     *
     * método para eliminar información
     * @param score
     */
    public void delete (Score score){
        scoreCrudRepository.delete(score);
    }    
}