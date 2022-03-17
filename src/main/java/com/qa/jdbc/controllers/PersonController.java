package com.qa.jdbc.controllers;

import java.util.List;
import java.util.Scanner;

import com.qa.jdbc.daos.PersonDAO;
import com.qa.jdbc.domain.Person;

public class PersonController {

	private Scanner scanner = new Scanner(System.in);
	private PersonDAO personDAO;


	public PersonController(PersonDAO personDAO) {
		this.personDAO = personDAO;

	}
	public void startUpApp() {
		boolean flag = true;
		while (flag) {
			String restart;
			int input;
			System.out.println("Welcome to the people database, would you like to:\nCreate (1)\nRead all (2)\nRead by person ID (3)\n"
					+ "Update by ID (4)\nDelete by ID (5)\nPlease only use the integer associated with the option.");
			input = scanner.nextInt();
			scanner.nextLine();
			switch (input) {
			case 1: 
				create();
				break;
			case 2: 
				readAll();
				break;
			case 3: 
				readById();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
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
	}

	public void create() {
		System.out.println("Please enter first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Please enter last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Please enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		personDAO.createPrepared(new Person(firstName, lastName, age));
		System.out.println("Person created");
	}

	public void readAll() {
		System.out.println("Database entries line by line below:");
		List<Person> people = personDAO.readAll();
		for (Person person : people) {
			System.out.println(person);
		}
	}

	public void readById() {
		System.out.println("Please enter an ID of the person you would like to read.");
		int input = scanner.nextInt();
		scanner.nextLine();
		System.out.println(personDAO.readByID(input));
	}
	public void update() {
		System.out.println("Please enter the ID of the entry you would like to update");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Please enter the first name");
		String firstName = scanner.nextLine();
		System.out.println("Please enter the last name");
		String lastName = scanner.nextLine();
		System.out.println("Please enter the age using only numbers");
		int age = scanner.nextInt();
		scanner.nextLine();
		personDAO.update(new Person(id, firstName, lastName, age));
		System.out.println("ID " + id + " updated");
	}

	public void delete() {
		System.out.println("Please enter the ID of the entry you would like to delete:");
		int input = scanner.nextInt();
		scanner.nextLine();
		personDAO.delete(input);
		System.out.println("Person with ID " + input + " Deleted");
	}

}
