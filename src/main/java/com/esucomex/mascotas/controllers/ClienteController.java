package com.esucomex.mascotas.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.esucomex.mascotas.models.Cliente;
import com.esucomex.mascotas.daos.IClienteDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;
	
	// cruds
	@GetMapping("/getAllClientes")
	public List<Cliente> getAllClientes() {		
		return (List<Cliente>) clienteDao.findAll();			
	}
	
	@PostMapping("/guardarCliente")
	public Cliente guardarCliente(@RequestBody Cliente cli ) {
		
		return clienteDao.save(cli);
	}
	
	// eliminar 
	@DeleteMapping("eliminar/{id}")
	public Cliente eliminarClienteById(@PathVariable Integer id) {
		// tenemos que ir a buscar el usuario a eliminar
		Cliente cli = clienteDao.findById(id).orElse(new Cliente());
		// validamos que no sea nulo // no 
		if(cli.equals(null)) {
			return cli;			
		}		
		// si existe en la base de datos eliminamos
		try {
			clienteDao.delete(cli);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}		
		return cli;
		
	}
	
	// actualizar
	@PutMapping("/actualizarCliente")
	public Cliente actualizarCliente(@RequestBody Cliente cli ) {
		// por si no viene lo agrega y este comportamiento es del guardarCliente
		// existe en la bd 
		Cliente cliBd = clienteDao.findById(cli.getId()).orElse(new Cliente());
		// si no existe terminamos la ejecucion
		if(cliBd.getId() == null) {
			return cliBd;			
		}		
		
		return clienteDao.save(cli);
	}
	
	//
		
	//Metodo personalizado
	@GetMapping("/cliente/{id}")
	public Cliente clienteById(@PathVariable Integer id) {		
		return  clienteDao.findById(id).orElse(new Cliente());			
	}
	
}
