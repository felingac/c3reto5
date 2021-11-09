package co.usa.ciclo3.ciclo3.web;

import java.util.Collections;
import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author xs
 */
/**
 *
 * Controlador User:Login
 */ 
@SpringBootApplication
@RestController
public class UserController {
    @GetMapping("/user")
	public Map<String, Object> user (@AuthenticationPrincipal OAuth2User principal) {
	return Collections.singletonMap("name", principal.getAttribute("name"));
	}
}