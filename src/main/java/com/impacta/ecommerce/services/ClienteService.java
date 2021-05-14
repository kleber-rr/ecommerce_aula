package com.impacta.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impacta.ecommerce.dao.ClienteDAO;
import com.impacta.ecommerce.domain.Cliente;

@Service
public class ClienteService{
	
	@Autowired
	private ClienteDAO dao;
	
	public List<Cliente> findAll(){
		return (List<Cliente>) dao.findAll();
	}
	
	public Optional<Cliente> findById(Integer id){
		return dao.findById(id);
	}
	
	public void save(Cliente Cliente) {
		dao.save(Cliente);
	}
	
	public void delete(Cliente Cliente) {
		dao.delete(Cliente);
	}
}
