package co.usa.ciclo3.ciclo3;
/**
 *
 * Importaciones
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
/**
 *
 * @author xs
 */
@EntityScan(basePackages = {"co.usa.ciclo3.ciclo3.model"})
@SpringBootApplication
@EnableConfigurationProperties
/**
 *
 * Clase de aplicación 
 */ 
public class Ciclo3Application {
    /**
     *
     * Clase Main
     */
	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}
}