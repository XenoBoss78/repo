package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student test for the CourseDBManager
 * 
 * @author Faadil A. Shaikh
 *
 */
public class CourseDBManager_STUDENT_Test {
	
	private CourseDBManagerInterface manager = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */ 
	@After
	public void tearDown() throws Exception {
		manager = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			manager.add("CMSC204",32452,4,"SC450","Farnaz Eivazi");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		manager.add("CHEM131",21301,4,"SC321","Bill Nye");
		manager.add("PSYC111",12341,3,"WB211","Sherlock Holmes");
		manager.add("MATH101",11192,4,"MC192","James Jonah-Jameson");
		ArrayList<String> list = manager.showAll();
		
		assertEquals(list.get(0),"Course:CHEM131 CRN:21301 Credits:4 Instructor:Bill Nye Room:SC321");
		assertEquals(list.get(1),"Course:PSYC111 CRN:12341 Credits:3 Instructor:Sherlock Holmes Room:WB211");
		assertEquals(list.get(2),"Course:MATH101 CRN:11192 Credits:4 Instructor:James Jonah-Jameson Room:MC192");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CHEM131 21301 4 SC321 Bill Nye");
			inFile.print("MATH101 11192 4 MC192 James Jonah-Jameson");
			
			inFile.close();
			manager.readFile(inputFile);

		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
