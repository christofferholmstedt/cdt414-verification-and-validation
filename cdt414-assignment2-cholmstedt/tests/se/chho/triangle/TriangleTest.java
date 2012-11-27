package se.chho.triangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

	/***
	 * Test Constructor
	 */
	@Test
	public void testTriangle()
	{
		Triangle t1 = new Triangle(1,2,3);
		assertEquals("Scalene - 1,2,3",t1.toString());
	}
	
	/***
	 * Triangle MUST throw exception when 
	 * non-integer sent to the constructor as any side length.
	 */
	@Test
	public void testIntegerInput() 
	{
		assertTrue(false);
		
		// TODO Create three triangles, each triangle has non-integer in one position.
		// TODO Catch triangle exceptions.
		// The Triangle class should throw exceptions immediatly.
	}
	
	/***
	 * Test that the Triangle class can identify a
	 * Scalene triangle. 
	 */
	@Test
	public void testScaleneTriangle() 
	{
		Triangle t2 = new Triangle(4,6,100);
		assertEquals("Scalene - 4,6,100",t2.toString());
	}

	/***
	 * Test that the Triangle class can identify a
	 * Isosceles triangle. 
	 */
	@Test
	public void testIsoscelesTriangle() 
	{
		Triangle t3 = new Triangle(7,7,13);
		assertEquals("Isosceles - 7,7,100", t3.toString());	
	}

	/***
	 * Test that the Triangle class can identify a
	 * Equilateral triangle. 
	 */
	@Test
	public void testEquilateralTriangle() 
	{		
		Triangle t4 = new Triangle(8,8,8);
		assertEquals("Equilateral - 8,8,8", t4.toString());
	}

}
