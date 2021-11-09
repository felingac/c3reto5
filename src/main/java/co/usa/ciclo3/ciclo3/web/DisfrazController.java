package co.usa.ciclo3.ciclo3.web;
/**
 *
 * Importaciones
 */
import co.usa.ciclo3.ciclo3.model.Disfraz;
import co.usa.ciclo3.ciclo3.service.DisfrazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author xs
 */
/**
 *
 * Controlador  Disfraz
 */ 
@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DisfrazController {
    /**
     *
     * Método para traer los datos desde Servicios hacia la URL
     */ 
    @Autowired
    private DisfrazService costumeService;
    /**
     *
     * Método para mostrar los datos de la base de datos mediante URL
     * @return 
     */ 
    @GetMapping("/all")
    public List<Disfraz> getCostumes(){
        return costumeService.getAll();
    }
    /**
     *
     * Método para mostrar un objeto específico de la base de datos mediante URL
     * @param id
     * @return 
     */    
    @GetMapping("/{id}")
    public Optional<Disfraz> getCostume(@PathVariable("id") int id){
        return costumeService.getCostume(id);
    }
    /**
     *
     * Método para guardar información en la base de datos mediante URL
     * @param costume
     * @return 
     */ 
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz save(@RequestBody Disfraz costume){
        return costumeService.save(costume);
    }
    /**
     *
     * Método para actualizar información en la base de datos mediante URL
     * @param costume
     * @return 
     */ 
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Disfraz update(@RequestBody Disfraz costume){
        return costumeService.update(costume);
    }    
    /**
     *
     * Método para eliminar información en la base de datos mediante URL
     * @param costumeId
     * @return 
     */ 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCostume(@PathVariable("id") int costumeId){
        return costumeService.deleteCostume(costumeId);
    }
}