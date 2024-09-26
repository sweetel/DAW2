package com.bbdd.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static Connection con;
	
	public static Connection obtenerConexionBBDD() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/alumnos";
		String user = "root";
		String pass = "PracticaRoot";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
		
	}
}
