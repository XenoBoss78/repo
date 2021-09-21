package gradebook;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	
	GradeBook book1,book2,book3;
	@Before
	public void setUp() throws Exception {
		book1 = new GradeBook(1);
		book2 = new GradeBook(10);
	}

	@After
	public void tearDown() throws Exception {
		book1=book2=book3=null;
	}

	@Test
	public void testAddScorePass() {
		assertTrue(book2.addScore(100) == true);
	}

	@Test
	public void testAddScoreFail() {
		book1.addScore(100);
		assertTrue(book1.addScore(20) == false);
	}
	
	@Test
	public void testSum() {
		book2.addScore(29.5);
		book2.addScore(57.5);
		assertTrue(book2.sum() == 87);
	}

	@Test
	public void testMinimum() {
		book2.addScore(29.5);
		book2.addScore(57.5);
		book2.addScore(98.23);
		book2.addScore(12.9);
		book2.addScore(195);
		book2.addScore(0.03);
		book2.addScore(347.9);
		book2.addScore(76.1);
		assertTrue(book2.minimum() == 0.03);
	}

	@Test
	public void testFinalScore() {
		book2.addScore(80);
		book2.addScore(92);
		book2.addScore(100);
		book2.addScore(50);
		book2.addScore(77);
		book2.addScore(93);
		book2.addScore(100);
		book2.addScore(78);
		assertTrue(book2.finalScore() == 620);
	}

}
