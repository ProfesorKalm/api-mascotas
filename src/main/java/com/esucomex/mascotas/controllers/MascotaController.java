package com.esucomex.mascotas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.esucomex.mascotas.daos.IMascotaDao;
import com.esucomex.mascotas.models.Mascota;

@RestController
@RequestMapping("/api/mascota")

//https://192.168.1.126/ <- donde etas montado el front
//http://localhost:8100/
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MascotaController {	
	
	@Autowired
	private IMascotaDao mascotaDao;
		
	@GetMapping("/getAllMascotas")
	public List<Mascota> getAllMascotas() {				
		return (List<Mascota>) mascotaDao.findAll(); // SELECT * FROM MASCOTAS
	}	
	
	@PostMapping("/guardarMascota")
	public Mascota guardarMascota(@RequestBody Mascota masc)  {						
		return mascotaDao.save(masc); // INSERT INTO MASCOTAS		
	}	

	@PutMapping("/actualizarMascota")
	public Mascota actualizarMascota(@RequestBody Mascota masc)  {						
		Mascota mascotaBd = mascotaDao.findById(masc.getId()).orElse(null);		
		if(mascotaBd.equals(null)) {
			return mascotaBd;
		} 		
		return mascotaDao.save(masc); // UPDFATE MASCOTA		
	}
	
	@DeleteMapping("/eliminarMascota")
	public Boolean eliminarMascota(@RequestBody Mascota mascota)  {			
		Boolean respuesta = false;
		try {
			mascotaDao.delete(mascota); // DELETE FROM MASCOTAS
			respuesta = true;
		} catch (Exception e) {
			respuesta = false;
		}
		
		return respuesta;		
	}
	
	
	// url dinamica /eliminar/7
	@DeleteMapping("/eliminar/{id}")
	public Mascota eliminar(@PathVariable Integer id ) {
		Mascota mascota = mascotaDao.findById(id).orElse(new Mascota());
		
		if(mascota.equals(null)) {
			return mascota;
		}					
		try {
			mascotaDao.delete(mascota); // DELETE FROM MASCOTAS			
		} catch (Exception e) {
			return new Mascota();
		}					
		return mascota;		
	}		
	
}
