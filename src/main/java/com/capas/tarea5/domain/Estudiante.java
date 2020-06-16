package com.capas.tarea5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity()
@Table(schema = "public", name = "estudiante")
public class Estudiante {

	@Id()
	@Column(name = "c_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cUsuario;

	@Column(name = "nombre")
	@NotEmpty()
	@Size(message = "El nombre no debe tener mas de 50 de caracteres", max = 50)
	private String nombre;

	@Column(name = "apellido")
	@Size(message = "El apellido no debe tener mas de 50 de caracteres", max = 50)
	@NotEmpty()
	private String apellido;

	@Column(name = "carne")
	@Size(message = "El carne debe tener exactamente 10 caracteres", max = 10 , min = 10)
	@NotEmpty()
	private String carne;

	@Column(name = "carrera")
	@Size(message = "La carrera no debe tener mas de 100 de caracteres", max = 100)
	@NotEmpty()
	private String carrera;

	public Estudiante() {

	}

	
	
	public Integer getcUsuario() {
		return cUsuario;
	}



	public void setcUsuario(Integer cUsuario) {
		this.cUsuario = cUsuario;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}
