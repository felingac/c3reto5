package co.usa.ciclo3.ciclo3.model;
/**
 *
 * Importaciones
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author xs
 */
@Entity
@Table(name="client")
/**
 *
 * Clase Entidad Client
 */
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     *
     * Atributo idCliente
     */
    private Integer idClient;
    /**
     *
     * Atributo email
     */
    private String email;    
    /**
     *
     * Atributo password
     */
    private String password;    
    /**
     *
     * Atributo name
     */
    private String name;    
    /**
     *
     * Atributo age
     */
    private Integer age;
    /**
     *
     * Relacion entre tablas message y client
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Message>messages;
    /**
     *
     * Relacion entre tablas reservation y client
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Reservation>reservations;
    /**
     *
     * Get para leer los datos y Set para enviar los datos de IdClient
     */
    public Integer getIdClient() {
        return idClient;
    }
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de email
     */
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de password
     */
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de name
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de age
     */
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase message
     */
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}