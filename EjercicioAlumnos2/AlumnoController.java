public class AlumnosController {

	public Integer insertarAlumno(String nombre, String apellido, String edad, String DNI, String sexo)
			throws ClassNotFoundException, SQLException {

		return new AlumnoModelo().insertarAlumno(nombre, apellido, edad, DNI, sexo);
	}

	public List<AlumnoDTO> consultaAlumnosConFiltros(String nombre, String apellido, String edad,
			String DNI, String sexo) throws ClassNotFoundException, SQLException {
		return new AlumnoModelo().consultaAlumnoConFiltros(nombre, apellido, edad, DNI, sexo);
	}
	
	public Integer actualizarAlumnos(String nombre, String apellido, String edad, String DNI, String sexo )
			throws ClassNotFoundException, SQLException {
		return new AlumnoModelo().actualizarAlumno(nombre, apellido, edad, DNI, sexo);
	}
	
	public Integer borrarAlumno(String DNI) throws ClassNotFoundException, SQLException{
		return new AlumnoModelo().borrarAlumno(DNI);
	}
}
