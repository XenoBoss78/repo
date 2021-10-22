package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;





public class SortedDoubleLinkedList_GFA_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator = new StringComparator();
	SortedDoubleLinkedList<Books> sortedLinkedBook;
	BookComparator comparatorBook;
	
	public Books a=new Books("Fishes", "Fisherman John", 2005);
	public Books b=new Books("Jaguars", "Ron Weasley", 2005);
	public Books c=new Books("Hunters", "Clarks", 2005);
	public Books d=new Books("Sunshine", "Oliver Twist", 2005);
	public Books e=new Books("CherryRed", "Sylvester", 2005);
	public Books f=new Books("Christ", "Patrick Star", 2005);

	@Before
	public void setUp() throws Exception {
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		comparatorBook = new BookComparator();
		sortedLinkedBook = new SortedDoubleLinkedList<Books>(comparatorBook);
	}

	@After
	public void tearDown() throws Exception {
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
		}
		catch (UnsupportedOperationException e)
		{
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
		}
	}
	
	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Goodbye");
		}
		catch (UnsupportedOperationException e)
		{
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
		}
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedBook.add(a);
		sortedLinkedBook.add(b);
		sortedLinkedBook.add(c);
		sortedLinkedBook.add(d);
		ListIterator<Books> iterator = sortedLinkedBook.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
	}
	
	@Test
	public void testIteratorSuccessfulBookPrevious() {
		sortedLinkedBook.add(e);
		sortedLinkedBook.add(c);
		sortedLinkedBook.add(b);
		sortedLinkedBook.add(d);
		ListIterator<Books> iterator = sortedLinkedBook.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(d, iterator.previous());
		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedBook.add(e);
		sortedLinkedBook.add(c);
		sortedLinkedBook.add(b);
		sortedLinkedBook.add(d);
		ListIterator<Books> iterator = sortedLinkedBook.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		try{
			//no more elements in list
			iterator.next();
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedBook.add(e);
		sortedLinkedBook.add(c);
		sortedLinkedBook.add(b);
		sortedLinkedBook.add(d);
		//ArrayList<Car> carList = sortedLinkedBook.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Books> iterator = sortedLinkedBook.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
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
	public void testAddBook() {
		sortedLinkedBook.add(a);
		sortedLinkedBook.add(b);
		sortedLinkedBook.add(c);
		assertEquals(a, sortedLinkedBook.getFirst());
		assertEquals(b, sortedLinkedBook.getLast());
		sortedLinkedBook.add(d);
		sortedLinkedBook.add(e);
		assertEquals(e, sortedLinkedBook.getFirst());
		assertEquals(d, sortedLinkedBook.getLast());
		//deletes Elephant from linked list
		assertEquals(d,sortedLinkedBook.retrieveLastElement());
		assertEquals(b, sortedLinkedBook.getLast());
	}

	@Test
	public void testRemoveFirstBook() {

		sortedLinkedBook.add(b);
		sortedLinkedBook.add(c);
		assertEquals(c, sortedLinkedBook.getFirst());
		assertEquals(b, sortedLinkedBook.getLast());
		sortedLinkedBook.add(a);
		assertEquals(a, sortedLinkedBook.getFirst());
		sortedLinkedBook.remove(a, comparatorBook);
		assertEquals(c, sortedLinkedBook.getFirst());
	}
	
	@Test
	public void testRemoveEndBook() {
		sortedLinkedBook.add(b);
		sortedLinkedBook.add(f);
		assertEquals(f, sortedLinkedBook.getFirst());
		assertEquals(b, sortedLinkedBook.getLast());
		sortedLinkedBook.add(d);
		assertEquals(d, sortedLinkedBook.getLast());
		sortedLinkedBook.remove(d, comparatorBook);
		assertEquals(b, sortedLinkedBook.getLast());
	}

	@Test
	public void testRemoveMiddleBook() {
		sortedLinkedBook.add(a);
		sortedLinkedBook.add(b);
		assertEquals(a, sortedLinkedBook.getFirst());
		assertEquals(b, sortedLinkedBook.getLast());
		sortedLinkedBook.add(f);
		assertEquals(f, sortedLinkedBook.getFirst());
		assertEquals(b, sortedLinkedBook.getLast());
		assertEquals(3,sortedLinkedBook.getSize());
		sortedLinkedBook.remove(a, comparatorBook);
		assertEquals(f, sortedLinkedBook.getFirst());
		assertEquals(b, sortedLinkedBook.getLast());
		assertEquals(2,sortedLinkedBook.getSize());
	}
	
	private class Books {
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
			// TODO Auto-generated method stub
			return price;
		}
	}
	private class BookComparator implements Comparator<Books>
	{

		@Override
		public int compare(Books arg0, Books arg1) {
			// Just put cars in alphabetic order by make
			return arg0.getTitle().compareTo(arg1.getTitle());
		}		
	}
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
	}
	
}