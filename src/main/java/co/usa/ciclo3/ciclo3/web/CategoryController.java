package co.usa.ciclo3.ciclo3.web;
import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.service.CategoryService;
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
 * Controlador  Category
 */ 
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {
    /**
     *
     * Método para traer los datos desde Servicios hacia la URL
     */ 
    @Autowired
    private CategoryService categoryService;
    /**
     *
     * Método para mostrar los datos de la base de datos mediante URL
     * @return 
     */ 
    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getAll();
    }
    /**
     *
     * Método para mostrar un objeto específico de la base de datos mediante URL
     * @param id
     * @return 
     */      
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }
    /**
     *
     * Método para guardar información en la base de datos mediante URL
     * @param category
     * @return 
     */ 
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }
    /**
     *
     * Método para actualizar información en la base de datos mediante URL
     * @param category
     * @return 
     */ 
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }
    /**
     *
     * Método para eliminar información en la base de datos mediante URL
     * @param id
     * @return 
     */   
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }
}