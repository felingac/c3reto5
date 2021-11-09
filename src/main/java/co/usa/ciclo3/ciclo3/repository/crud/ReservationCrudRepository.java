package co.usa.ciclo3.ciclo3.repository.crud;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author xs
 */
/**
 *
 * Interface Crud repositorio para la entidad Reservation (reserva)
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer>{
    /**
     *
     * Interface Crud repositorio para la entidad Reservation (reserva) vacío intencionalmente
     */    
}