package com.qa.jdbc.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.jdbc.domain.Person;

public class PersonDAO implements Dao<Person> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	// three things we need to connect
	private String connectionURL = "jdbc:mysql://localhost:3306/persondb";
	private String username = "root";
	private String password = "password";
	
	
	

	// model from resultSet method - EVERY DAO HAS ONE OF THESE
	@Override
	public Person modelFromResultsSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		int id = resultSet.getInt("id");
		String firstName = resultSet.getString("firstName");
		String lastName = resultSet.getString("lastName");
		int age = resultSet.getInt("age");
		return new Person(id, firstName, lastName, age);
	}	


	//THIS IS HOW TO GET FULL MARKS
	// CREATE
		public void create(Person person) {
			try(Connection conn = DriverManager.getConnection(connectionURL, username, password); 
					Statement statement = conn.createStatement()) {
				statement.executeUpdate("INSERT INTO people(firstName, lastName, age) VALUES ('" + person.getFirstName() + "', '" + 
						person.getLastName() + "', " + person.getAge() + ");");
				System.out.println("person created");
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}

	//CREATE USING PREPARED STATEMENT (BONUS and applies a lot - it is way better)
	public void createPrepared(Person person) {
		try(Connection conn = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement statement = conn
						.prepareStatement("INSERT INTO people(firstName, lastName, age) VALUES(?,?,?)")) {

			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setInt(3, person.getAge());
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());   // TRY TO ALWAYS USE GET MESSAGE AS MORE READABLE
		}
	}

	// READ ALL
	public List<Person> readAll() {

		try(Connection conn = DriverManager.getConnection(connectionURL, username, password); 
				Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
			List<Person> people = new ArrayList<>();
			while (resultSet.next()) {
				people.add(modelFromResultsSet(resultSet));
			}
			return people;
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	//READ BY ID
	@Override
	public Person readById(int id) {
		// TODO Auto-generated method stub
		try(Connection conn = DriverManager.getConnection(connectionURL, username, password); 
				Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM people WHERE ID=" + id);

			resultSet.next();
			return modelFromResultsSet(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}



	// UPDATE
	public void update(Person person) {
		try(Connection conn = DriverManager.getConnection(connectionURL, username, password);
				PreparedStatement statement = conn
						.prepareStatement("UPDATE people SET firstName = ?, lastName = ?, age = ? WHERE ID = ?")) {

			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setInt(3, person.getAge());
			statement.setInt(4,  person.getId());
			statement.executeUpdate(); // this returns the amount of rows effected, in this case will always be 1 or 0
			System.out.println("Person updated");  
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}

	}

	// DELETE
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try(Connection conn = DriverManager.getConnection(connectionURL, username, password); 
				PreparedStatement statement = conn
						.prepareStatement("DELETE FROM people WHERE id = ?")) {

			statement.setInt(1, id);
			int x = statement.executeUpdate();   //this  = 1 if theres a deleted row, and 0 if nothing has been deleted
			if (x != 0) {
				System.out.println("Person deleted");
			} else {
				System.out.println("Person not found");
				throw new SQLException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			//String string = e.getMessage(); // converts to string
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
