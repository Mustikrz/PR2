package WS18.PR2.G8.PU1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomTest {
		Polynom polynom0 = new Polynom(5,0,-2,0,9.5,-8,5);
		Polynom polynom1 = new Polynom(5,4,-2,3,9.5,-8);
		Polynom polynom2 = new Polynom(3,7,6,-6,0,4,7,11);
		Polynom polynom3 = new Polynom(-10,0,0.5,-1,2);
		Polynom polynom4 = new Polynom(0,1,-3,8);
		
	@Test
	public void berechneTest() throws Exception {
		
		assertEquals(9.5,polynom0.berechne(1),0.000001);
		assertEquals(25.5,polynom0.berechne(-1),0.000001);
		assertEquals(59017.5,polynom0.berechne(5),0.000001);
	}
	
	@Test
	public void addiereTest() throws Exception{
		Polynom istErgebnis = new Polynom(polynom1.addiere(polynom2));
		Polynom sollErgebnis = new Polynom(8,11,4,-3,9.5,-4,7,11);
		assertTrue(sollErgebnis.equals(istErgebnis));	
	}
	
	@Test
	public void subtrahiereTest() throws Exception{
		Polynom istErgebnis = new Polynom(polynom1.subtrahiere(polynom2));
		Polynom sollErgebnis = new Polynom(2,-3,-8,9,9.5,-12,-7,-11);
		assertTrue(sollErgebnis.equals(istErgebnis));
	}
	
	@Test
	public void differenziereTest() throws Exception{
		Polynom istErgebnis = new Polynom(polynom3.differenziere());
		Polynom sollErgebnis = new Polynom(0,1,-3,8);
		assertTrue(sollErgebnis.equals(istErgebnis));
	}

	@Test
	public void integriereTest() throws Exception{
		Polynom istErgebnis = new Polynom(polynom4.integriere());
		Polynom sollErgebnis = new Polynom(0,0,0.5,-1,2);
		assertTrue(sollErgebnis.equals(istErgebnis));
	}
}
