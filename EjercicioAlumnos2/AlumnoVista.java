public class AlumnoVista {

	Scanner sc = new Scanner(System.in);

	public void insertarInscripcion() throws ClassNotFoundException, SQLException {

		String nombre;

		System.out.println("Introduzca el nombre:");
		nombre = sc.nextLine();

		String apellido;

		System.out.println("Introduzca el apellido:");
		apellido = sc.nextLine();

		String edad;

		System.out.println("Introduzca el edad:");
		edad = sc.nextLine();

		String DNI;

		System.out.println("Introduzca el DNI:");
		DNI = sc.nextLine();

		String sexo;

		System.out.println("Introduzca el sexo:");
		sexo = sc.nextLine();

		AlumnoModelo alumno = new AlumnoModelo();
		Integer resultado = alumno.insertarAlumno(nombre, apellido, edad, DNI, sexo);

		if (resultado == 1) {
			System.out.println("alumno introducido con exito");
		} else {
			System.out.println("error");
		}

	}

	public void buscarAlumnoConFiltro() throws ClassNotFoundException, SQLException {

		System.out.println("Digame el nombre del alumno:");
		String nombre = sc.nextLine();
		System.out.println("Digame el apellido:");
		String apellido = sc.nextLine();
		System.out.println("Digame edad:");
		String edad = sc.nextLine();
		System.out.println("Digame el DNI:");
		String DNI = sc.nextLine();
		System.out.println("Digame el sexo:");
		String sexo = sc.nextLine();

		List<AlumnoDTO> listaAlumnos = new AlumnosController().consultaAlumnosConFiltros(nombre, apellido, edad, DNI,
				sexo);

		for (AlumnoDTO p : listaAlumnos) {
			System.out.println(p.toString());
		}
	}
	
	public void actualizarAlumno() throws ClassNotFoundException, SQLException {
		
		System.out.println("nombre alumno:");
		String nombre = sc.nextLine();

		System.out.println("apellido:");
		String apellido = sc.nextLine();
		
		System.out.println("edad:");
		String edad = sc.nextLine();

		System.out.println("DNI:");
		String DNI = sc.nextLine();
		
		System.out.println("sexo:");
		String sexo = sc.nextLine();



		Integer resultado = new AlumnoModelo().actualizarAlumno(nombre, apellido, edad, DNI, sexo);

		if (resultado == 1) {
			System.out.println("Inscripción actualizada con exito");
		} else {
			System.out.println("ERROR: No se actualizo la inscripcion");
		}

	}
	
public void borrarAlumno() throws ClassNotFoundException, SQLException {
		
		System.out.println("Numero de DNI que desea ELIMINAR:");
		String DNI = null;
		Boolean esEmpleadoIDCorrecto = false;
		
		while (!esEmpleadoIDCorrecto) {
			try {
				DNI = sc.nextLine();
				esEmpleadoIDCorrecto = true;
			} catch (NumberFormatException n) {
				System.out.println("Debe introducir un numero entero válido");
			}
		}

		Integer resultado = new AlumnoModelo().borrarAlumno(DNI);
	}
}
