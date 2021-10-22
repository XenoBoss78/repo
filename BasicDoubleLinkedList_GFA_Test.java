package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class BasicDoubleLinkedList_GFA_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Books> linkedBook;
	BookComparator comparatorBook;
	
	public Books a =new Books("Fishes", "Fisherman John", 2005);
	public Books b =new Books("Jaguars", "Ron Weasley", 2005);
	public Books c =new Books("Hunters", "Clarks", 2005);
	public Books d =new Books("Sunshine", "Oliver Twist", 2005);
	public Books e =new Books("CherryRed", "Sylvester", 2005);
	public Books f =new Books("Christ", "Patrick Star", 2005);

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedBook= new BasicDoubleLinkedList<Books>();
		linkedBook.addToEnd(b);
		linkedBook.addToEnd(c);
		comparatorBook = new BookComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedBook = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedBook.getSize());
	}	
	
	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		
		assertEquals(c,linkedBook.getLast());
		linkedBook.addToEnd(d);
		assertEquals(d,linkedBook.getLast());
	}
	
	@Test
	public void testAddToFront() {
		
		assertEquals(b,linkedBook.getFirst());
		linkedBook.addToFront(a);
		assertEquals(a,linkedBook.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		
		assertEquals(b,linkedBook.getFirst());
		linkedBook.addToFront(a);
		assertEquals(a,linkedBook.getFirst());
	}

	@Test
	public void testGetLast() {
		
		assertEquals(c,linkedBook.getLast());
		linkedBook.addToEnd(d);
		assertEquals(d,linkedBook.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Books> list;
		linkedBook.addToFront(a);
		linkedBook.addToEnd(d);
		list = linkedBook.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {

		
		linkedBook.addToFront(a);
		linkedBook.addToEnd(d);
		ListIterator<Books> iteratorBook = linkedBook.iterator();
		assertEquals(true, iteratorBook.hasNext());
		assertEquals(a, iteratorBook.next());
		assertEquals(b, iteratorBook.next());
		assertEquals(c, iteratorBook.next());
		assertEquals(true, iteratorBook.hasNext());
		assertEquals(d, iteratorBook.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedBook.addToFront(a);
		linkedBook.addToEnd(d);
		ListIterator<Books> iteratorBook = linkedBook.iterator();
		assertEquals(true, iteratorBook.hasNext());
		assertEquals(a, iteratorBook.next());
		assertEquals(b, iteratorBook.next());
		assertEquals(c, iteratorBook.next());
		assertEquals(d, iteratorBook.next());
		assertEquals(true, iteratorBook.hasPrevious());
		assertEquals(d, iteratorBook.previous());
		assertEquals(c, iteratorBook.previous());
		assertEquals(b, iteratorBook.previous());
		assertEquals(a, iteratorBook.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedBook.addToFront(a);
		linkedBook.addToEnd(d);
		ListIterator<Books> iteratorBook = linkedBook.iterator();		
		assertEquals(true, iteratorBook.hasNext());
		assertEquals(a, iteratorBook.next());
		assertEquals(b, iteratorBook.next());
		assertEquals(c, iteratorBook.next());
		assertEquals(true, iteratorBook.hasNext());
		assertEquals(d, iteratorBook.next());
		
		try{
			
			iteratorBook.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedBook.addToFront(a);
		linkedBook.addToEnd(d);
		ListIterator<Books> iteratorBook = linkedBook.iterator();		
		assertEquals(true, iteratorBook.hasNext());
		assertEquals(a, iteratorBook.next());
		assertEquals(b, iteratorBook.next());
		assertEquals(c, iteratorBook.next());
		assertEquals(d, iteratorBook.next());
		assertEquals(true, iteratorBook.hasPrevious());
		assertEquals(d, iteratorBook.previous());
		assertEquals(c, iteratorBook.previous());
		assertEquals(b, iteratorBook.previous());
		assertEquals(a, iteratorBook.previous());
		
		try{
			//no more elements in list
			iteratorBook.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedBook.addToFront(a);
		linkedBook.addToEnd(d);
		ListIterator<Books> iteratorBook = linkedBook.iterator();		
		assertEquals(true, iteratorBook.hasNext());
		assertEquals(a, iteratorBook.next());
		assertEquals(b, iteratorBook.next());
		assertEquals(c, iteratorBook.next());
		assertEquals(true, iteratorBook.hasNext());
		assertEquals(d, iteratorBook.next());
		
		try{
			iteratorBook.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		
		assertEquals(b, linkedBook.getFirst());
		assertEquals(c, linkedBook.getLast());
		linkedBook.addToFront(a);
		assertEquals(a, linkedBook.getFirst());
		linkedBook.remove(a, comparatorBook);
		assertEquals(b, linkedBook.getFirst());
		
		linkedBook.addToEnd(d);
		assertEquals(d, linkedBook.getLast());
		linkedBook.remove(d, comparatorBook);
		assertEquals(c, linkedBook.getLast());
		
		linkedBook.addToFront(a);
		assertEquals(a, linkedBook.getFirst());
		assertEquals(c, linkedBook.getLast());
		linkedBook.remove(b, comparatorBook);
		assertEquals(a, linkedBook.getFirst());
		assertEquals(c, linkedBook.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkedBook.getFirst());
		linkedBook.addToFront(a);
		assertEquals(a, linkedBook.getFirst());
		assertEquals(a, linkedBook.retrieveFirstElement());
		assertEquals(b,linkedBook.getFirst());
		assertEquals(b, linkedBook.retrieveFirstElement());
		assertEquals(c,linkedBook.getFirst());
		
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedBook.getLast());
		linkedBook.addToEnd(d);
		assertEquals(d, linkedBook.getLast());
		assertEquals(d, linkedBook.retrieveLastElement());
		assertEquals(c,linkedBook.getLast());
		
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}
	
	public class Books {
		String Title,Author;
		double price;
		public Books(String title, String author, double amt) {
			Title = title;
			Author = author;
			price = amt;
		}
		
		public String getTitle() {
			return Title;
		}

		public double getPrice() {
			return price;
		}
	}
	
	private class BookComparator implements Comparator<Books> {

		@Override
		public int compare(Books arg0, Books arg1) {
			return arg0.getTitle().compareTo(arg1.getTitle());
		}		
	}
}