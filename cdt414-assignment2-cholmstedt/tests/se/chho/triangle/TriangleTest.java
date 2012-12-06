package se.chho.triangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

	/***
	 * Test Constructor
	 */
	@Test
	public void testTriangleConstructor()
	{
		Triangle t1 = new Triangle(2,4,5);
		assertEquals("Scalene",t1.toString());
	}
	
	/***
	 * Test that the Triangle class can identify a
	 * Equilateral triangle. 
	 */
	@Test
	public void testEquilateralTriangle() 
	{		
		Triangle t2 = new Triangle(8,8,8);
		assertEquals("Equilateral", t2.toString());
	}
	
	/***
	 * Test that the Triangle class can identify a
	 * Isosceles triangle. 
	 */
	@Test
	public void testIsoscelesTriangle() 
	{	
		Triangle t3 = new Triangle(13,7,7);
		Triangle t4 = new Triangle(7,13,7);
		Triangle t5 = new Triangle(7,7,13);
		assertEquals("Isosceles", t3.toString());
		assertEquals("Isosceles", t4.toString());	
		assertEquals("Isosceles", t5.toString());	
	}
	
	/***
	 * Test for invalid Triangles
	 */
	@Test
	public void testInvalidTriangle() 
	{
		// Wrong dimensions
		Triangle t6 = new Triangle(4,6,100);
		Triangle t7 = new Triangle(4,100,6);
		Triangle t8 = new Triangle(100,6,4);
		// Zero input
		Triangle t9 = new Triangle(0,0,0);
		Triangle t10 = new Triangle(0,1,1);
		Triangle t11 = new Triangle(1,0,1);
		Triangle t12 = new Triangle(1,1,0);
		// Negative input
		Triangle t13 = new Triangle(-13,7,7);
		Triangle t14 = new Triangle(13,-7,7);
		Triangle t15 = new Triangle(13,7,-7);
		
		assertEquals("Invalid",t6.toString());
		assertEquals("Invalid",t7.toString());
		assertEquals("Invalid",t8.toString());
		
		assertEquals("Invalid",t9.toString());
		assertEquals("Invalid",t10.toString());
		assertEquals("Invalid",t11.toString());
		assertEquals("Invalid",t12.toString());
		
		assertEquals("Invalid",t13.toString());
		assertEquals("Invalid",t14.toString());
		assertEquals("Invalid",t15.toString());
	}
	
	/***
	 * Test that the Triangle class can identify a
	 * Scalene triangle. 
	 */
	@Test
	public void testScaleneTriangle() 
	{
		Triangle t16 = new Triangle(4,6,5);
		assertEquals("Scalene",t16.toString());
	}

}
