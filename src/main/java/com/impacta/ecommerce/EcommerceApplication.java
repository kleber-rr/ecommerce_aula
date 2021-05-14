package com.impacta.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.impacta.ecommerce.domain.Categoria;
import com.impacta.ecommerce.services.CategoriaService;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	private CategoriaService service;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		geraCategorias();
	}
	
	private void geraCategorias() {
		service.save(new Categoria("Informatica"));
		service.save(new Categoria("Papelaria"));
		service.save(new Categoria("Mobiliario"));
		
	}
	
	

}
