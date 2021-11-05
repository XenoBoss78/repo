package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	CourseDBStructure database;
	
	/** 
	* Makes a new CourseDBStructure and adds it to the database 
	* 
	* @param The CourseId String, CRN integer, credits integer, roomNum String, instructor String
	*
	*/
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		if (database == null) {
			database = new CourseDBStructure(10);
		}
		CourseDBElement course = new CourseDBElement(id,crn,credits,roomNum,instructor);
		database.add(course);
	}

	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement is in the hashtable, return it
	* If not, throw an IOException
	* 
	* @param the crn of the wanted course
	 * @throws IOException 
	*/
	@Override
	public CourseDBElement get(int crn) {
		try {
			return database.get(crn);
		} catch (IOException e) {
			System.out.println("CDE does not Exist in DB");
		}
		return null;
	}
	
	/** 
	* Reads in the values from a .txt document and makes a new CourseDBElement with the data
	* Then it adds the new element to the database
	* 
	* @param The file to be read from
	* @throws FileNotFoundException 
	*/
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanner = new Scanner(input);
		database = new CourseDBStructure(10);
		while(scanner.hasNextLine()) {
			String[] data = scanner.nextLine().split(" ",5);
			database.add(new CourseDBElement(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], data[4].trim()));
		}
		scanner.close();
	}

	/** 
	* Returns an ArrayList with all the values of the database 
	*/
	@Override
	public ArrayList<String> showAll() {
		ArrayList a = new ArrayList<String>();
		for (LinkedList<CourseDBElement> i: database.hashTable) {
			if (i != null) {
				for (CourseDBElement temp : i) {
						a.add(temp.toString());
					}
			}
		}
		return a;
	}

}
