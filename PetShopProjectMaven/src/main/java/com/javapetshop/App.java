package com.javapetshop;

import java.io.IOException;
import java.sql.SQLException;

import menu.MenuClass;

/**
 * Hello world!
 *
 */
public class App {


	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {

		MenuClass ob = new MenuClass();
		ob.menu();
		
/*		AngajatController aC = new AngajatController();
		

		aC.createAngajat(17, "Kwon", "Sun", 1000);*/
	}

}
