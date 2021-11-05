package application;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class CourseDBStructure implements CourseDBStructureInterface{
	int size;
	LinkedList<CourseDBElement>[] hashTable;
	
	public CourseDBStructure(int i) {
		this.size = i;
		hashTable = new LinkedList[size];
	}
	
	public CourseDBStructure(String s, int i) {
		this.size = i;
		hashTable = new LinkedList[size];
	}

	@Override
	public void add(CourseDBElement element) {

		if (hashTable[element.hashCode() % getTableSize()] != null) {
			hashTable[element.hashCode() % getTableSize()].addLast(element);
		} else {
			LinkedList<CourseDBElement> newList = new LinkedList<CourseDBElement>();
			hashTable[element.hashCode() % getTableSize()] = newList;
			hashTable[element.hashCode() % getTableSize()].add(element);
		}
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {

		int hash = Objects.hash(Integer.toString(crn));
		CourseDBElement course = null;
		
		if (hashTable[hash % getTableSize()] != null) {
			for (CourseDBElement temp : hashTable[hash % getTableSize()]) {
			    if (temp.getCRN() == crn) {
			    	course = temp;
			    	break;
			    }
			}
			 if (course == null) {
				 throw new IOException();
			 }
			 
		} else {
			throw new IOException();
		}
		return course;
	}

	@Override
	public int getTableSize() {
		return size;
	}


}
