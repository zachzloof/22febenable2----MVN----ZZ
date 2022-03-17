package com.qa.jdbc;

import java.util.List;
import java.util.Scanner;

import com.qa.jdbc.controllers.PersonController;
import com.qa.jdbc.daos.PersonDAO;
import com.qa.jdbc.domain.Person;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		TestConnection object = new TestConnection();
		//		object.testConnection();

		// CRUD functionality (CREATE, READ, UPDATE, DELETE)
		// USING DAO - DATA ACCESS OBJECT


		//THIS PERSON GETS ADDED TO DATABSE CORRECTLY
		//CREATE
		PersonDAO pDAO = new  PersonDAO();
		//		Person p = new Person("Tom", "Smith", 30);
		//		pDAO.createPrepared(p); //AND THIS FOR PREPARED CREAte

		//		THIS WILL READ BY ID
		//		System.out.println(pDAO.readByID(3));

		//THIS WILL PRINT ALL / READ ALL AND PRINT LINE BY LIUNE
		//		List<Person> people = pDAO.readAll();
		//		for (Person person : people) {
		//			System.out.println(person);
		//		}



		// update
		//		Person update = new Person();
		//		pDAO.update(update);
		//		
		//		//delete 
		//		pDAO.delete(4);
		
			
		
		PersonController pControl = new PersonController(pDAO);
		Menu menu = new Menu(pControl);						//RUSSIAN DOLLS
		//CRUDS NOW 
		
//		pControl.create();
//		pControl.readAll();
//		pControl.readById();
//		pControl.update();
//		pControl.delete();
//		
		menu.startUpApp();
//		pControl.startUpApp();
		
	}

}
