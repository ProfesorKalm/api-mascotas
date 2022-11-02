package com.esucomex.mascotas.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@Data
public class Cliente {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer rut; //180736298
	private String digito;		// K
	private String nombre;
	private String apPaterno; 
	private String apMaterno;
	private String email;
	private Integer edad;	
}
