package co.usa.ciclo3.ciclo3.repository;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
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
 * Repositorio para la entidad Reservation (reserva)
 */
@Repository
public class ReservationRepository {
    @Autowired
    /**
     *
     * método para traer informacion del crud repository
     */    
    private ReservationCrudRepository reservationCrudRepository;
    /**
     *
     * método para buscar información
     * @return 
     */
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    /**
     *
     * método para buscar dato específico
     * @param id
     * @return 
     */
    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    /**
     *
     * método para guardar información
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    /**
     *
     * método para eliminar información
     * @param reservation
     */
    public void delete (Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }    
}