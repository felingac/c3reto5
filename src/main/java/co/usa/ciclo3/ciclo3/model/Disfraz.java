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
@Table(name="costume")
/**
 *
 * Clase Entidad Costume
 */
public class Disfraz implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     *
     * Atributo id
     */
    private Integer id;
    /**
     *
     * Atributo name
     */
    private String name;    
    /**
     *
     * Atributo brand
     */
    private String brand;    
    /**
     *
     * Atributo year
     */
    private Integer year;    
    /**
     *
     * Atributo description
     */
    private String description;
    /**
     *
     * Relacion entre category y costume
     */
    @ManyToOne
    @JoinColumn(name="categoriaId")
    @JsonIgnoreProperties("costumes")
    private Category category;
    /**
     *
     * Relacion entre message y costume
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="costume")
    @JsonIgnoreProperties({"costume","client"})
    public List<Message>messages;
    /**
     *
     * Relacion entre reservation y costume
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="costume")
    @JsonIgnoreProperties({"costume"})
    public List<Reservation>reservations;
    /**
     *
     * Get para leer los datos y Set para enviar los datos de Id 
     */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
     * Get para leer los datos y Set para enviar los datos de brand
     */
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de year
     */
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de description
     */
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase Category
     */
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de la clase Message
     */
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de Reservation
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}