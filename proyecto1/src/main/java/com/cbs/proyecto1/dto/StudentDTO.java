package com.cbs.proyecto1.dto;

public class StudentDTO {


		private String nombre;
		private String apellido;

		public StudentDTO(String nombre, String apellido) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;

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

		

		@Override
		public String toString() {
			return "StudentDTO [nombre=" + nombre + ", apellido=" + apellido + "]";
		}
		
		
		


}
