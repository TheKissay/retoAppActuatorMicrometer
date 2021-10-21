package com.example.retoAppActuatorMicrometer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;


@RestController
public class Prometheus {

	
	private Counter counter;
	private Counter fails;
	
	public Prometheus(MeterRegistry registry) {
		this.counter = Counter.builder("invocaciones.ganadas").description("Veces que has ganado").register(registry);
		this.fails = Counter.builder("invocaciones.perdidas").description("Veces que ha fallado").register(registry);
		
	}
	
	@GetMapping(path="/tombola")
	public String tombola() {
		
		double probabilidad = Math.random();
		String mensaje = "";
		
		
		if (probabilidad < 0.5) {
			fails.increment();
			mensaje = "¡Falló!";
		} else {
			counter.increment();
			mensaje = "¡Acertó!";
		}
		
		return mensaje;
	}
	
	
}
