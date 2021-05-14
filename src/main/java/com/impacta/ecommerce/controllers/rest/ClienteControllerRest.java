package com.impacta.ecommerce.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.impacta.ecommerce.domain.Cliente;
import com.impacta.ecommerce.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControllerRest {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping("")
	public List<Cliente> getAll() {
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		return ResponseEntity.of(service.findById(id));
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Cliente updatepById(@PathVariable Integer id, @RequestBody Cliente cliente) {
		Optional<Cliente> c = service.findById(id);
		Cliente cat = c.orElse(null);
		if(cat == null) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		cat.setNome(cliente.getNome());
		cat.setEmail(cliente.getEmail());
		cat.setTelefone(cliente.getTelefone());
		service.save(cat);
		return cat;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public List<Cliente> save(@RequestBody Cliente cliente) {
		service.save(cliente);
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public  List<Cliente> delById(@PathVariable Integer id) {
		Optional<Cliente> cat = service.findById(id);
		if(cat.isPresent()) service.delete(cat.get());
		return service.findAll();
	}
	
	
}

