package com.impacta.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.impacta.ecommerce.domain.Cliente;

@Repository
public interface ClienteDAO extends CrudRepository<Cliente, Integer>{

}
