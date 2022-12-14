package com.esucomex.mascotas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mascota")
@Data
public class Mascota {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	@Column(name = "nombre")
	private String nombre;
	private Integer edad;
	private String tipo;
}
