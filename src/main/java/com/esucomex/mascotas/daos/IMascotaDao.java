package com.esucomex.mascotas.daos;

import org.springframework.data.repository.CrudRepository;
import com.esucomex.mascotas.models.Mascota;

public interface IMascotaDao extends CrudRepository<Mascota, Integer> {	
	
	//implementacion meteodos personalizados por campos y entidades
}
