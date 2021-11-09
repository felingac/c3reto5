package co.usa.ciclo3.ciclo3.service;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
/**
 *
 * @author xs
 */
/**
 *
 * Servicios: Reservation
 */
@Service
public class ReservationService {
    /**
     *
     * Método para traer los datos desde el repositorio de reserva
     */     
   @Autowired
    private ReservationRepository reservationRepository;
    /**
     *
     * Método para traer los datos desde el repositorio de cliente
     */     
   @Autowired
    private ClientRepository clientRepository;   
    /**
     *
     * Método para el servicio de mostrar todo
     * @return 
     */ 
    public List<Reservation> getAll(){
        return  reservationRepository.getAll();
    }
    /**
     *
     * Método para el servicio de mostrar dato específico
     * @param idReserva
     * @return 
     */ 
    public Optional<Reservation> getReservation(int idReserva){
        return reservationRepository.getReservation(idReserva);
    }
    /**
     *
     * Método para el servicio de guardar todo
     * @param reservation
     * @return 
     */ 
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> evt=reservationRepository.getReservation(reservation.getIdReservation());
            if(evt == null){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    } 
    /**
     *
     * Método para el servicio de actualizar todo
     * @param reservation
     * @return 
     */
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> actualizar = reservationRepository.getReservation(reservation.getIdReservation());
            if (actualizar != null) {

                if (reservation.getStartDate() != null) {
                    actualizar.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    actualizar.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    actualizar.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(actualizar.get());
                return actualizar.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }    
    /**
     *
     * Método para el servicio de eliminar
     * @param reservationId
     * @return 
     */    
    public boolean deleteReservation(int reservationId){
        return getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
    }
    /**
     *
     * Método para listar cantidad de reservas en un tiempo determinado
     * @param from
     * @param until
     * @return 
     */ 
    public ArrayList<Reservation> getByDate(Date from, Date until) {
        List<Reservation> reservations = reservationRepository.getAll();
        ArrayList<Reservation> dateReservation = new ArrayList<>();
        int count = 0;
        for (Reservation reservation : reservations) {
            if(from.compareTo(until) < 0) {
                if (reservation.getDevolutionDate().compareTo(from) > 0 && reservation.getStartDate().compareTo(until) < 0) {
                    if ((reservation.getStartDate().compareTo(from) <= 0 || reservation.getStartDate().compareTo(from) >= 0) &&
                            reservation.getDevolutionDate().compareTo(until) <= 0 || reservation.getDevolutionDate().compareTo(until) >= 0) {
                        count++;
                        dateReservation.add(reservation);
                        System.out.println(dateReservation.size());
                    }
                }
            }
        }
        return dateReservation;
    }
    /**
     * Método para obtener la cantidad de reservas completadas y canceladas
     * @return
     */
    public LinkedHashMap<String, Integer> getVs(){
        List<Reservation> reservations = reservationRepository.getAll();
        LinkedHashMap<String, Integer> status = new LinkedHashMap<>();
        int completed = 0;
        int cancelled = 0;
        for (Reservation reservation : reservations){
            if ("completed".equals(reservation.getStatus().toLowerCase())){
                completed++;
            }else if ("cancelled".equals(reservation.getStatus().toLowerCase())){
                cancelled++;
            }
        }
        status.put("completed", completed);
        status.put("cancelled", cancelled);
        return  status;
    }
    /**
     * Método para obtener la cantidad de reservas completadas de un cliente
     * @return
     */
    public List<Object> getClientReport(){
        List<Client> clients = clientRepository.getAll();
        LinkedHashMap<String,Object> reportClient = new LinkedHashMap<>();
        List<Object> countClients = new ArrayList<>();
        for (Client client: clients){
            Integer total = 0;
            for (Reservation reservation : client.getReservations()) {
                total++;
            }
            reportClient.put("total", total);
            reportClient.put("client",client);
            countClients.add(reportClient.clone());
            System.out.println(countClients);
            System.out.println(reportClient);
        }
        return countClients;
    }
}