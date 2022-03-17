package com.qa.jdbc;

import java.util.Scanner;

import com.qa.jdbc.controllers.PersonController;
import com.qa.jdbc.daos.PersonDAO;

public class Menu {
	private PersonController pControl;
	
	
	public Menu(PersonController pControl) {
		// TODO Auto-generated constructor stub
		this.pControl = pControl;
	}

	public void startUpApp() {
		boolean flag = true;
		
		Scanner scanner = new Scanner(System.in);
		
		while (flag) {
			String restart;
			int input;
			System.out.println("Welcome to the people database, would you like to:\nCreate (1)\nRead all (2)\nRead by person ID (3)\n"
					+ "Update by ID (4)\nDelete by ID (5)\nPlease only use the integer associated with the option.");
			input = scanner.nextInt();
			scanner.nextLine();
			switch (input) {
			case 1: 
				pControl.create();
				break;
			case 2: 
				pControl.readAll();
				break;
			case 3: 
				pControl.readById();
				break;
			case 4:
				pControl.update();
				break;
			case 5:
				pControl.delete();
				break;
			default: 
				System.out.println("You have picked an invalid input, please try again");
				break;
			}
			System.out.println("Would you like to continue using the app? (y/n)");
			restart = scanner.nextLine();
			if (restart.equalsIgnoreCase("y")) {     // this piece of code allows the user to control if the app keeps running or 
				continue;							// allows the user to keep the program running if an invalid value is inputted

			} else if (restart.equalsIgnoreCase("n")) {
				flag = false;
				continue;
			} else {
				System.out.println("You entered an invalid value. Restarting app");
			}
		}
		scanner.close();
	}

}
