package co.usa.ciclo3.ciclo3.model;
/**
 *
 * Importaciones
 */
import javax.persistence.*;
import java.io.Serializable;
/**
 *
 * @author xs
 */
@Entity
@Table(name="admin")
/**
 *
 * Clase Entidad Admin
 */
public class Admin implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     *
     * Atributo id Admin
     */
    private Integer idAdmin;
    /**
     *
     * Atributo name Admin
     */
    private String nameAdmin;
    /**
     *
     * Atributo email Admin
     */
    private String emailAdmin;
    /**
     *
     * Atributo password Admin
     */
    private String passwordAdmin;
    /**
     *
     * Get para leer los datos y Set para enviar los datos de IdAdmin
     */
    public Integer getIdAdmin() {
        return idAdmin;
    }
    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de nameAdmin
     */
    public String getNameAdmin() {
        return nameAdmin;
    }
    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de emailAdmin
     */
    public String getEmailAdmin() {
        return emailAdmin;
    }
    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }
    /**
     *
     * Get para leer los datos y Set para enviar los datos de passwordAdmin
     */
    public String getPasswordAdmin() {
        return passwordAdmin;
    }
    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }
}