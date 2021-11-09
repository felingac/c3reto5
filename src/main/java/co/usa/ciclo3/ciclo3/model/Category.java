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
@Table(name="category")
/**
 *
 * Clase Entidad Category
 */
public class Category implements Serializable{
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
     * Atributo description
     */
    private String description;
    /**
     *
     * Relación entre tablas costume y category
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    public List<Disfraz> costumes;
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
     * Get para leer los datos y Set para enviar los datos de la clase costume
     */
    public List<Disfraz> getCostumes() {
        return costumes;
    }
    public void setCostumes(List<Disfraz> costumes) {
        this.costumes = costumes;
    }
}