package co.usa.ciclo3.ciclo3.web;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.service.ReservationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author xs
 */
/**
 *
 * Controlador  Reservation
 */ 
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    /**
     *
     * Método para traer los datos desde Servicios hacia la URL
     */ 
    @Autowired
    private ReservationService reservationService;
    /**
     *
     * Método para mostrar los datos de la base de datos mediante URL
     * @return 
     */ 
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }
    /**
     *
     * Método para mostrar un objeto específico de la base de datos mediante URL
     * @param id
     * @return 
     */    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    /**
     *
     * Método para guardar información en la base de datos mediante URL
     * @param reservation
     * @return 
     */ 
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    /**
     *
     * Método para actualizar información en la base de datos mediante URL
     * @param reservation
     * @return 
     */ 
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    /**
     *
     * Método para eliminar información en la base de datos mediante URL
     * @param reservationId
     * @return 
     */      
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationService.deleteReservation(reservationId);
    }   
    /**
     *
     * Método para emitir reporte cantidad de reservas en un tiempo determinado
     * @param sFrom
     * @param sTo
     * @return 
     */   
    @GetMapping("report-dates/{from}/{to}")
    public List<Reservation> getByDate(@PathVariable("from") String sFrom, @PathVariable("to") String sTo){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date from = null;
        Date to = null;
        try {
            from = formato.parse(sFrom);
            to = formato.parse(sTo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reservationService.getByDate(from, to);
    }
    /**
     * Método para obtener el conteo las reservas completas de cada cliente
     * @return
     */
    @GetMapping("report-clients")
    public List<Object> getClientReport(){
        return reservationService.getClientReport();
    }
    /**
     * Método para obtener el mapeo para retornar el conteo de reservas completas vs canceladas
     * @return
     */
    @GetMapping("report-status")
    public LinkedHashMap<String, Integer> getVs(){
        return reservationService.getVs();
    }
}
