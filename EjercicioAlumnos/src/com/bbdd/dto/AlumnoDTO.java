package com.bbdd.dto;

public class AlumnoDTO {

	private String nombre;
	private String apellido;
	private String edad;
	private String DNI;
	private String sexo;
	
	public AlumnoDTO(String nombre, String apellido, String edad, String dNI, String sexo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		DNI = DNI;
		this.sexo = sexo;
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		DNI = DNI;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "AlumnoDTO [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", DNI=" + DNI + ", sexo="
				+ sexo + "]";
	}
	
	
	
}
