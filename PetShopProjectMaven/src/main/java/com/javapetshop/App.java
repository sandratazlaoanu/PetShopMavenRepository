package com.javapetshop;

import java.io.IOException;
import java.sql.SQLException;

import menu.MenuClass;

/**
 * MainClass for the app
 *
 */
public class App {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {

		MenuClass ob = new MenuClass();
		ob.menu();

	}

}
