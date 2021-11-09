package co.usa.ciclo3.ciclo3.repository;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author xs
 */
/**
 *
 * Repositorio para la entidad Admin (administrador)
 */
@Repository
public class AdminRepository {
    @Autowired
    /**
     *
     * método para traer informacion del crud repository
     */
    private AdminCrudRepository adminCrudRepository;
    /**
     *
     * método para buscar información
     * @return 
     */
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    /**
     *
     * método para buscar dato específico
     * @param id
     * @return 
     */
    public Optional<Admin>getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    /**
     *
     * método para guardar información
     * @param admin
     * @return 
     */
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
    /**
     *
     * método para eliminar información
     * @param admin
     */
    public void delete (Admin admin){
        adminCrudRepository.delete(admin);
    }
}
