package com.esucomex.mascotas.daos;

import org.springframework.data.repository.CrudRepository;

import com.esucomex.mascotas.models.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {	

}
