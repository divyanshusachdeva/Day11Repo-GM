package com.graymatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonImplement implements PersonInterface {

	
	@Override
	public List<PersonClass> getAllPersonsInfo() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM person";
		Connection con = PersonDriver.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<PersonClass> personList = new ArrayList<PersonClass>();
		
		while(rs.next()) {
			personList.add(new PersonClass(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5)));
		}
		
		return personList;
	}
	
	@Override
	public PersonClass getPersonById(int id) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * FROM person WHERE id = ?";
		Connection con = PersonDriver.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		
		PersonClass person = null;
		
		while(rs.next()) {
			person = new PersonClass(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5));
		}
		
		return person;
	}

	@Override
	public PersonClass addPerson(PersonClass person) throws ClassNotFoundException, SQLException {

		String query = "INSERT INTO person(id ,name, age, mobile, email) VALUES (?,?,?,?,?)";
		
		Connection con = PersonDriver.getConnection();

		PreparedStatement ps = con.prepareStatement(query);
    
		ps.setInt(1, person.getId());
		ps.setString(2, person.getName());
		ps.setInt(3, person.getAge());
		ps.setString(4, person.getMobile());
		ps.setString(4, person.getEmail());
		
		ps.executeUpdate();
		
		return person;
	}

	@Override
	public PersonClass updatePerson(PersonClass person, int id) throws ClassNotFoundException, SQLException {

		String query = "UPDATE TABLE person SET name=?, age=? WHERE id=?";
		
		Connection con = PersonDriver.getConnection();

		PreparedStatement ps = con.prepareStatement(query);
    
		ps.setString(1, person.getName());
		ps.setInt(2, person.getAge());
	
		ps.executeUpdate();
		
		return person;
	}

	@Override
	public PersonClass deletePerson(int id) throws ClassNotFoundException, SQLException {
		
		PersonClass person = getPersonById(id);

		String query = "DELETE FROM person WHERE id=?";
		
		Connection con = PersonDriver.getConnection();

		PreparedStatement ps = con.prepareStatement(query);
    
		ps.setInt(1, id);
	
		ps.executeUpdate();
		
		return person;
	}
}
