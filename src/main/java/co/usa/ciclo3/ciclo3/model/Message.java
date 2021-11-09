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
@Table(name="message")
/**
 *
 * Clase Entidad Message
 */
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     *
     * Atributo idMessage
     */
    private Integer idMessage;
    /**
     *
     * Atributo messageText
     */
    private String messageText;
    /**
     *
     * Relacion entre tablas message y costume
     */
    @ManyToOne
    @JoinColumn(name="idCostume")
    @JsonIgnoreProperties({"messages","client", "reservations"})
    private Disfraz costume;
    /**
     *
     * Relacion entre tablas message y client
     */
    @ManyToOne
    @JoinColumn(name="idCliente")
    @JsonIgnoreProperties({"messages", "reservations","client"}) 
    private Client client;
    /**
     *
     * Get para leer los datos y Set para enviar los datos de idMessage
     */
    public Integer getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
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
     * Get para leer los datos y Set para enviar de la clase Disfraz
     */
    public Disfraz getCostume() {
        return costume;
    }
    public void setCostume(Disfraz costume) {
        this.costume = costume;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase Client
     */
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}