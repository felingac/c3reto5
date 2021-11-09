package co.usa.ciclo3.ciclo3.service;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.repository.ScoreRepository;
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
 * Servicios: Score
 */
@Service
public class ScoreService {
    /**
     *
     * Método para traer los datos desde el repositorio
     */   
    @Autowired
    private ScoreRepository scoreRepository;
    /**
     *
     * Método para el servicio de mostrar todo
     * @return 
     */ 
    public List<Score> getAll(){
        return  scoreRepository.getAll();
    }
    /**
     *
     * Método para el servicio de mostrar dato específico
     * @param id
     * @return 
     */     
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    /**
     *
     * Método para el servicio de guardar todo
     * @param score
     * @return 
     */ 
    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> evt=scoreRepository.getScore(score.getIdScore());
            if(evt == null){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }
    /**
     *
     * Método para el servicio de actualizar todo
     * @param score
     * @return 
     */ 
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score>actualizar=scoreRepository.getScore(score.getIdScore());
            if(actualizar != null){
                if(score.getStars()!=null){
                    actualizar.get().setStars(score.getStars());
                }
            }
        }
        return score;
    }
    /**
     *
     * Método para el servicio de eliminar
     * @param id
     * @return 
     */   
    public boolean deleteScore(int id){
        Optional<Score> c=getScore(id);
        if(c != null){
            scoreRepository.delete(c.get());
            return true;
        }
        return false;
    }    
}