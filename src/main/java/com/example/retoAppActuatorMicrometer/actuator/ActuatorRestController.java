package com.example.retoAppActuatorMicrometer.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorRestController {

	@GetMapping("comida")
	public String getSomething() {
		return "Comida work!";
	}
	
	@GetMapping("comida/{id}")
	public String getUser(@PathVariable final int id) {
		return "El código de la comida es: "+id;
	}
	
	@GetMapping("comida/{id}/{nombre}")
	public String getUser(@PathVariable final int id, @PathVariable final String nombre) {
		return "El código de la comida es: "+id+" y su nombre es:"+nombre;
	}

	

}

