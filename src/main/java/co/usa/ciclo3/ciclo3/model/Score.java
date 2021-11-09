package co.usa.ciclo3.ciclo3.model;
/**
 *
 * Importaciones
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
/**
 *
 * @author xs
 */
@Entity
@Table(name="score")
/**
 *
 * Clase Entidad Score
 */
public class Score implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    /**
     *
     * Atributo idScore
     */
    private Integer idScore;
    /**
     *
     * Atributo stars
     */
    private Integer stars;
    /**
     *
     * messageText
     */
    private String messageText;
    /**
     *
     * Relación entre score y reservation
     */
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;
    /**
     *
     * Get para leer los datos y Set para enviar los datos de idScore
     */
    public Integer getIdScore() {
        return idScore;
    }
    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de Starts
     */
    public Integer getStars() {
        return stars;
    }
    public void setStars(Integer stars) {
        this.stars = stars;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de messageText
     */
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase Reservation
     */
    public Reservation getReservation() {
        return reservation;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}