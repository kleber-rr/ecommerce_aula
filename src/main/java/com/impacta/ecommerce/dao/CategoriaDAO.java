package com.impacta.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impacta.ecommerce.domain.Categoria;

@Repository
public interface CategoriaDAO extends CrudRepository<Categoria, Integer>{
	
}
