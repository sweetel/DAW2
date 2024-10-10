

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoModelo {

	public Integer insertarAlumno(String nombre, String apellido, String edad, String DNI, String sexo)
			throws ClassNotFoundException, SQLException {

		Connection con = DBUtils.obtenerConexionBBDD();

		String insertInscripcion = "INSERT INTO alumnos (nombre, apellido, edad, DNI, sexo)" + "VALUES (?, ?, ?, ?, ?)";

		PreparedStatement psInsertInscripcion = con.prepareStatement(insertInscripcion);

		psInsertInscripcion.setString(1, nombre);
		psInsertInscripcion.setString(2, apellido);
		psInsertInscripcion.setString(3, edad);
		psInsertInscripcion.setString(4, DNI);
		psInsertInscripcion.setString(5, sexo);

		Integer resultado = psInsertInscripcion.executeUpdate();

		con.close();

		return resultado;
	}

	public List<AlumnoDTO> consultaAlumnoConFiltros(String nombre, String apellido, String edad, String DNI,
			String sexo) throws ClassNotFoundException, SQLException {

		Connection con = DBUtils.obtenerConexionBBDD();

		String sql = "SELECT a.nombre, a.apellido, a.edad, a.Nombre FROM alumnos a"
				+ "INNER JOIN inscripciones i on e.EstudianteID = i.EstudianteID "
				+ "INNER JOIN cursos c on c.CursoID = i.CursoID " + "WHERE c.CursoID LIKE ? "
				+ "AND c.Nombre_del_Curso LIKE ? " + "AND e.EstudianteID LIKE ? " + "AND e.Nombre LIKE ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, "%" + nombre + "%");
		ps.setString(2, "%" + apellido + "%");
		ps.setString(3, "%" + edad + "%");
		ps.setString(4, "%" + DNI + "%");
		ps.setString(5, "%" + sexo + "%");

		List<AlumnoDTO> listaInscripciones = new ArrayList<>();
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaInscripciones.add(new AlumnoDTO(rs.getString("a.nombre"), rs.getString("a.apellido"),
					rs.getString("a.edad"), rs.getString("a.DNI"), rs.getString("a.sexo")));
		}

		rs.close();
		ps.close();
		con.close();

		return listaInscripciones;
	}

	public Integer actualizarAlumno(String nombre, String apellido, String edad, String DNI, String sexo)
			throws ClassNotFoundException, SQLException {

		Connection con = DBUtils.obtenerConexionBBDD();

		String updateAlumno = "UPDATE alumnos SET nombre = ?, apellido = ?, edad = ?, sexo = ? WHERE DNI = ?";

		PreparedStatement psUpdateAlumno = con.prepareStatement(updateAlumno);

		psUpdateAlumno.setString(1, nombre);
		psUpdateAlumno.setString(2, apellido);
		psUpdateAlumno.setString(3, edad);
		psUpdateAlumno.setString(4, sexo);
		psUpdateAlumno.setString(5, DNI); // Establece el DNI para encontrar el registro específico

		Integer resultado = psUpdateAlumno.executeUpdate();

		psUpdateAlumno.close();
		con.close();

		return resultado;
	}
	
	public Integer borrarAlumno(String DNI) throws ClassNotFoundException, SQLException {

		String sql = "DELETE FROM asignaciones WHERE DNI = ? ";

		Connection con = DBUtils.obtenerConexionBBDD();

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, DNI);

		Integer resultado = ps.executeUpdate();
		con.close();

		return resultado;
	}

}
