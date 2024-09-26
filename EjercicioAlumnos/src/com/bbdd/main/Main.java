package com.bbdd.main;
import java.sql.SQLException;

import com.bbdd.utils.MenuPrincipal;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		MenuPrincipal mp = new MenuPrincipal();
		mp.menuPrincipal();
	}

}
