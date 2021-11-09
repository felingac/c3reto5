package co.usa.ciclo3.ciclo3.model;
/**
 *
 * Importaciones
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author xs
 */
@Entity
@Table(name="reservation")
/**
 *
 * Clase Entidad Reservation
 */
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    /**
     *
     * Atributo idReservation
     */
    private Integer idReservation;
    /**
     *
     * Atributo startDate
     */
    private Date startDate;
    /**
     *
     * Atributo devolutionDate
     */
    private Date devolutionDate;
    /**
     *
     * Atributo status
     */
    private String status="created";
    /**
     *
     * Relacion entre costume y reservation
     */
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"reservations","client"})
    private Disfraz costume;
    /**
     *
     * Relacion entre client y reservation
     */    
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    /**
     *
     * Relacion entre score y reservation
     */
    private String score;
    /**
     *
     * Get para leer los datos y Set para enviar los datos de idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de startDate
     */
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de devolutionDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de status
     */
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase costume
     */
    public Disfraz getCostume() {
        return costume;
    }
    public void setCostume(Disfraz costume) {
        this.costume = costume;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase client
     */
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase score
     */
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
}
