package com.graymatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class PersonImplementTest {

    private PersonImplement personImplement;

    @Before
    public void setUp() throws Exception {
        personImplement = new PersonImplement();
        // Populate the database with initial data
        try (Connection con = PersonDriver.getConnection()) {
            String insertQuery = "INSERT INTO person (id, name, age, mobile, email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertQuery)) {
                ps.setInt(1, 101);
                ps.setString(2, "Divyanshu");
                ps.setInt(3, 21);
                ps.setString(4, "9868899470");
                ps.setString(5, "divyanshu@gmail.com");
                ps.executeUpdate();

                ps.setInt(1, 102);
                ps.setString(2, "Aman");
                ps.setInt(3, 25);
                ps.setString(4, "0987654321");
                ps.setString(5, "aman@gmail.com");
                ps.executeUpdate();
            }
        }
    }

    @Test
    public void testGetAllPersonsInfo() throws Exception {
        List<PersonClass> persons = personImplement.getAllPersonsInfo();
        assertNotNull(persons);
        assertEquals(2, persons.size());

        PersonClass person1 = persons.get(0);
        assertEquals(101, person1.getId());
        assertEquals("Divyanshu", person1.getName());
        assertEquals(21, person1.getAge());

        PersonClass person2 = persons.get(1);
        assertEquals(102, person2.getId());
        assertEquals("Aman", person2.getName());
        assertEquals(25, person2.getAge());
    }

    @Test
    public void testGetPersonById() throws Exception {
        PersonClass person = personImplement.getPersonById(1);
        assertNotNull(person);
        assertEquals(101, person.getId());
        assertEquals("Divyanshu", person.getName());
        assertEquals(21, person.getAge());
    }

    @Test
    public void testAddPerson() throws Exception {
        PersonClass newPerson = new PersonClass(103, "Priya", 28, "9879879871", "priya@gmail.com");
        PersonClass addedPerson = personImplement.addPerson(newPerson);

        assertNotNull(addedPerson);
        assertEquals("Priya", addedPerson.getName());

        // Verify the person was added
        try (Connection con = PersonDriver.getConnection()) {
            String query = "SELECT * FROM person WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, 103);
                try (ResultSet rs = ps.executeQuery()) {
                    assertTrue(rs.next());
                    assertEquals("Priya", rs.getString("name"));
                }
            }
        }
    }

    @Test
    public void testUpdatePerson() throws Exception {
        PersonClass personToUpdate = new PersonClass(1, "John Smith", 35, "1234567890", "johnsmith@example.com");
        PersonClass updatedPerson = personImplement.updatePerson(personToUpdate, 1);

        assertNotNull(updatedPerson);
        assertEquals("John Smith", updatedPerson.getName());

        // Verify the person was updated
        try (Connection con = PersonDriver.getConnection()) {
            String query = "SELECT * FROM person WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, 1);
                try (ResultSet rs = ps.executeQuery()) {
                    assertTrue(rs.next());
                    assertEquals("John Smith", rs.getString("name"));
                    assertEquals(35, rs.getInt("age"));
                }
            }
        }
    }

    @Test
    public void testDeletePerson() throws Exception {
        PersonClass deletedPerson = personImplement.deletePerson(2);

        assertNotNull(deletedPerson);
        assertEquals(2, deletedPerson.getId());

        // Verify the person was deleted
        try (Connection con = PersonDriver.getConnection()) {
            String query = "SELECT * FROM person WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, 2);
                try (ResultSet rs = ps.executeQuery()) {
                    assertFalse(rs.next()); // No result should be found
                }
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        // Clean up the database after each test
        try (Connection con = PersonDriver.getConnection()) {
            con.createStatement().execute("DROP TABLE person");
        }
    }
}
