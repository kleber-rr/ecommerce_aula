package com.impacta.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impacta.ecommerce.dao.CategoriaDAO;
import com.impacta.ecommerce.domain.Categoria;

@Service
public class CategoriaService{
	
	@Autowired
	private CategoriaDAO dao;
	
	public List<Categoria> findAll(){
		return (List<Categoria>) dao.findAll();
	}
	
	public Optional<Categoria> findById(Integer id){
		return dao.findById(id);
	}
	
	public void save(Categoria categoria) {
		dao.save(categoria);
	}
	
	public void delete(Categoria categoria) {
		dao.delete(categoria);
	}
}
