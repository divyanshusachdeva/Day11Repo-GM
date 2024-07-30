package com.graymatter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;



public class TestCalculator {
	

//	@Test
//	public void testAdd() {
//		assertEquals(5, Calculator.add(3, 2));
//	}
//	
//	@Test
//	public void testSub() {
//		assertEquals(8, Calculator.sub(15, 7));
//	}
//	
//	@Test
//	public void testMul() {
//		assertEquals(15, Calculator.mul(5,3));
//	}
//	
//	@Test
//	public void TestIsEven() {
//		assertTrue(Calculator.isEven(48));
//	}
//	
//	@Test
//	public void testArrayEquals() {
//		int expArray[] = {34, 68, 94, 26, 47};
//		int actArray[] = {34, 618, 94, 26, 47};
//		
//		assertArrayEquals(expArray, Calculator.arrayEquals(actArray));
//	}
//	

	@Test
	@IncludeCategory(TestCalculator.class)
	public void testCheckString() {
		assertNull(Calculator.checkString());
	}

	@Before
	public void printLogBeforeEachMethod() {
		System.out.println("Before Every Test");
		}
	
	@After
	public void printLogAfterEachMethod() {
		System.out.println("After Every Test");
		}
	
	@Before
	public void printBeforeClass() {
		System.out.println("Before Class Execution");
	}
	
	@After
	public void printAfterClass() {
		System.out.println("After Class Execution");
	}
	
	@Test
	@Category(MarkerInterface.class)
	public void testCreateStudent() {
		Student expStudent = new Student (123, "Amit", 21);
		assertEquals(expStudent, Calculator.createStudent());
	}
	
	
	static Connection con = null;
	
	@BeforeClass
	public static void testGetConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/graymatterdb", "root", "password");
		
//		DBConnection dbc = new DBConnection("jdbc:mysql://localhost:3306/graymatterdb", "root", "password");
//		assertEquals(con, DBConnection.getConnection());
	}
	
	@Test
	public void testConnection() {
		assertNotNull(con);
	}
}
