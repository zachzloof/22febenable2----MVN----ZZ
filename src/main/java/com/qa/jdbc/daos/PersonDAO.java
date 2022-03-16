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

public class PersonDAO {

	public static final Logger LOGGER = LogManager.getLogger();
	// three things we need to connect
	private String connectionURL = "jdbc:mysql://localhost:3306/persondb";
	private String username = "root";
	private String password = "password";
	
	// model from resultSet method
	public Person personFromResultsSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String firstName = resultSet.getString("firstName");
		String lastName = resultSet.getString("lastName");
		int age = resultSet.getInt("age");
		return new Person(id, firstName, lastName, age);
	}
	
	
	//THIS IS HOW TO GET FULL MARKS
	// CREATE
//	public void create(Person person) {
//		try(Connection conn = DriverManager.getConnection(connectionURL, username, password); 
//				Statement statement = conn.createStatement()) {
//			statement.executeUpdate("INSERT INTO people(firstName, lastName, age) VALUES ('" + person.getFirstName() + "', '" + 
//					person.getLastName() + "', " + person.getAge() + ");");
//			System.out.println("person created");
//		} catch (SQLException e) {
//			LOGGER.error(e);
//		}
//	}
	
	//CREATE USING PREPARED STATEMENT (BONUS and applies a lot)
	public void createPrepared(Person person) {
		    try(Connection conn = DriverManager.getConnection(connectionURL, username, password);
		        PreparedStatement statement = conn.prepareStatement("INSERT INTO people(firstName, lastName, age) VALUES(?,?,?)")) {

		        statement.setString(1, person.getFirstName());
		        statement.setString(2, person.getLastName());
		        statement.setInt(3, person.getAge());
		        statement.executeUpdate();
		    } catch (SQLException e) {
		        LOGGER.error(e);
		    }
		}

	// READ ALL
	public List<Person> readAll() {
		
		try(Connection conn = DriverManager.getConnection(connectionURL, username, password); 
				Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
			List<Person> people = new ArrayList<>();
			while (resultSet.next()) {
				people.add(personFromResultsSet(resultSet));
			}
			return people;
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return null;
		
}

	//READ BY ID
	public Person readByID(int id) {
		try(Connection conn = DriverManager.getConnection(connectionURL, username, password); 
				Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM people WHERE ID=" + id);
			resultSet.next();
			return personFromResultsSet(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return null;

	}

	

	// UPDATE
	public void update() {}

	// DELETE
	public void delete() {}

}
