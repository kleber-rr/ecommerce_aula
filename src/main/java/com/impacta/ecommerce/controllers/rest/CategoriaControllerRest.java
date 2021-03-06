package com.impacta.ecommerce.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.impacta.ecommerce.domain.Categoria;
import com.impacta.ecommerce.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaControllerRest {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping("")
	public List<Categoria> getAll() {
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		return ResponseEntity.of(service.findById(id));
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Categoria updatepById(@PathVariable Integer id, @RequestBody Categoria categoria) {
		Optional<Categoria> c = service.findById(id);
		Categoria cat = c.get();
		cat.setNome(categoria.getNome());
		service.save(cat);
		return cat;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public List<Categoria> save(@RequestBody Categoria categoria) {
		service.save(categoria);
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public  List<Categoria> delById(@PathVariable Integer id) {
		Optional<Categoria> cat = service.findById(id);
		if(cat.isPresent()) service.delete(cat.get());
		return service.findAll();
	}
	
	
}

