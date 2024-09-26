package com.bbdd.utils;
import java.sql.SQLException;
import java.util.Scanner;

import com.bbdd.vista.AlumnoVista;

public class MenuPrincipal {

	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		AlumnoVista av = new AlumnoVista();
		
		
		while (opcion != 6) {
			System.out.println("       MENUuuu PRINCIPAL 2          ");
			System.out.println("===============================================");
			System.out.println("1. Insertar Alumno");
			System.out.println("2. Busqueda por filtros");
			System.out.println("3. Atualizar alumno");
			System.out.println("4. Borrar alumno");
			System.out.println("===============================================");
			System.out.print("Elige una opcion: ");

			opcion = sc.nextInt();
			sc.nextLine();
			
			System.out.println("la opcion es <" + opcion + ">");
			if (opcion >= 1 && opcion <= 5) {
				switch (opcion) {
				case 1:
					System.out.println("Insertar Alumno");
					av.insertarInscripcion();
					break;
				case 2:
					System.out.println("Consultadddds Alumno");
					av.buscarAlumnoConFiltro();
					System.out.println("Consultadddds Alumno222");

					break;
				case 3:
					System.out.println("Actualizdddddar Alumno");
					av.actualizarAlumno();
					break;
				case 4:
					System.out.println("Borrar alumno");
					av.borrarAlumno();
					break;
				case 5:
					System.out.println("Salir seleccionado. Saliendo del programa.");
					break;
				default:
					System.out.println("Opcion no valida. Por favor, intente de nuevo.");
					break;
				}
			} else {
				System.out.println("Opción no válida. Por favor, elige un número entre 1 y 4.");
			}
		}

		sc.close();
	}
}
