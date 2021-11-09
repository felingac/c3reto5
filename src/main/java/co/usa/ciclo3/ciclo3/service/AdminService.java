package co.usa.ciclo3.ciclo3.service;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author xs
 */
/**
 *
 * Servicios: Admin
 */
@Service
public class AdminService {
    /**
     *
     * Método para traer los datos desde el repositorio
     */      
    @Autowired
    private AdminRepository adminRepository;
    /**
     *
     * Método para el servicio de mostrar todo
     * @return 
     */ 
    public List<Admin> getAll(){
        return  adminRepository.getAll();
    }
    /**
     *
     * Método para el servicio de mostrar dato específico
     * @param id
     * @return 
     */     
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    /**
     *
     * Método para el servicio de guardar todo
     * @param admin
     * @return 
     */ 
    public Admin save(Admin admin){
        if(admin.getIdAdmin()==null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> evt=adminRepository.getAdmin(admin.getIdAdmin());
            if(evt == null){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }
    }
    /**
     *
     * Método para el servicio de actualizar todo
     * @param admin
     * @return 
     */ 
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin>actualizar=adminRepository.getAdmin(admin.getIdAdmin());
            if (actualizar != null){
                if(admin.getNameAdmin()!=null){
                    actualizar.get().setNameAdmin(admin.getNameAdmin());
                }
                if(admin.getPasswordAdmin()!=null){
                    actualizar.get().setPasswordAdmin(admin.getPasswordAdmin());
                }
                return adminRepository.save(actualizar.get());
            }
        }
        return admin;
    }
    /**
     *
     * Método para el servicio de eliminar
     * @param idAdmin
     * @return 
     */    
    public boolean deleteAdmin(int idAdmin){
        Boolean borrar = getAdmin(idAdmin).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return borrar;
    }
}