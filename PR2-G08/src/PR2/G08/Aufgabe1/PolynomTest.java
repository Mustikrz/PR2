package PR2.G08.Aufgabe1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomTest {
	Polynom polynom1 = new Polynom(3,5,0,1);	//x^3 + 5x + 3
		
	@Test
	public void berechneTest() throws Exception {
		assertEquals(3,polynom1.berechne(0),0.000001);
		assertEquals(9,polynom1.berechne(1),0.000001);
		assertEquals(-3,polynom1.berechne(-1),0.000001);
	}
		
	@Test
	public void integriereTest() throws Exception{
		//Stammfunktion von x^3+5x+3 = ((1/4)*(x^4)) + ((5/2)*x^2) + 3x + c
		//assertEquals((new double[]{3,(5/2),0,(1/4)}),polynom1.integriere(),0.0001);	
	}

	
	

}
