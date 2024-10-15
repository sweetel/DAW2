package com.cbs.proyecto1.dto;


	public class PersonaDTO {

		private String nombre;
		private String apellido;
		private String edad;
		private String DNI;
		private String sexo;
		
		public PersonaDTO(String nombre, String apellido, String edad, String DNI, String sexo) {
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

		public void setDNI(String dNI) {
			DNI = dNI;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		@Override
		public String toString() {
			return "PersonaDTO [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", DNI=" + DNI
					+ ", sexo=" + sexo + "]";
		}

		
		

	
}
