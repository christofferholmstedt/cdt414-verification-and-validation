package se.chho.range;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest {

	@Test
	public void testInstantiateWithString()
	{
		@SuppressWarnings("unused")
		Range r = new Range("[0,5)");
		assertTrue(true);
	}
	
	@Test
	public void testInstantiateWithTwoRangeObjects()
	{
		Range r1 = new Range("(0,5)");
		Range r2 = new Range("(0,15]");
		@SuppressWarnings("unused")
		Range r3 = new Range(r1,r2); 
		assertTrue(true);
	}
	
	@Test(expected = InvalidInputException.class)
	public void testValidInput1() 
	{
		@SuppressWarnings("unused")
		Range r = new Range("Text string, Invalid input.");
		fail("Invalid input exception should have been thrown before this.");
	}
	
	@Test(expected = InvalidRangeException.class)
	public void testValidInput2() 
	{
		@SuppressWarnings("unused")
		Range r = new Range("(0,1)");
		fail("Invalid range exception should have been thrown before this.");
	}
	
	@Test(expected = InvalidRangeException.class)
	public void testValidInput3() 
	{
		@SuppressWarnings("unused")
		Range r = new Range("[10,9]");
		fail("Invalid range exception should have been thrown before this.");
	}
	
	@Test
	public void testGetLowerBoundary1()
	{
		Range r1 = new Range("(0,5)");
		assertEquals(1,r1.getLowerBoundary());
	}
	
	@Test
	public void testGetLowerBoundary2()
	{
		Range r1 = new Range("[14,20)");
		assertEquals(14,r1.getLowerBoundary());
	}
	
	@Test
	public void testGetUpperBoundary1()
	{
		Range r1 = new Range("(0,5)");
		assertEquals(4,r1.getUpperBoundary());
	}
	
	@Test
	public void testGetUpperBoundary2()
	{
		Range r1 = new Range("[14,20]");
		assertEquals(20,r1.getUpperBoundary());
	}
	
	@Test
	public void testInRange1()
	{
		Range r1 = new Range("[14,20]");
		assertTrue(r1.inRange(16));
	}
	
	@Test
	public void testInRange2()
	{
		Range r1 = new Range("[14,20]");
		assertTrue(r1.inRange(20));
	}
	
	@Test
	public void testInRange3()
	{
		Range r1 = new Range("(14,20]");
		assertFalse(r1.inRange(14));
	}
	
	@Test
	public void testMergeTwoRangeObjects1()
	{
		Range r1 = new Range("[10,20]");
		Range r2 = new Range("[15,25]");
		Range r3 = new Range(r1,r2);
		assertEquals(15, r3.getLowerBoundary());
		assertEquals(20, r3.getUpperBoundary());
	}
	
	@Test
	public void testMergeTwoRangeObjects2()
	{
		Range r1 = new Range("[10,20]");
		Range r2 = new Range("[30,40]");
		Range r3 = new Range(r1,r2);
		assertTrue(r3.isEmptyRange());
	}
	
	@Test
	public void testMergeTwoRangeObjects3()
	{
		Range r1 = new Range("[10,20]");
		Range r2 = new Range("[5,15]");
		Range r3 = new Range(r1,r2);
		assertEquals(10, r3.getLowerBoundary());
		assertEquals(15, r3.getUpperBoundary());
	}
	
	@Test
	public void testMergeTwoRangeObjects4()
	{
		Range r1 = new Range("[10,20]");
		Range r2 = new Range("[5,7]");
		Range r3 = new Range(r1,r2);
		assertTrue(r3.isEmptyRange());
	}
	
	@Test
	public void testMergeTwoRangeObjects5()
	{
		Range r1 = new Range("[10,20]");
		Range r2 = new Range("[12,17]");
		Range r3 = new Range(r1,r2);
		assertEquals(10, r3.getLowerBoundary());
		assertEquals(20, r3.getUpperBoundary());
	}
	
	@Test
	public void testMergeTwoRangeObjects6()
	{
		Range r1 = new Range("[12,17]");
		Range r2 = new Range("[10,20]");
		Range r3 = new Range(r1,r2);
		assertEquals(10, r3.getLowerBoundary());
		assertEquals(20, r3.getUpperBoundary());
	}
	
	@Test
	public void testMergeTwoRangeObjects7()
	{
		Range r1 = new Range("[10,10]");
		Range r2 = new Range("[10,10]");
		Range r3 = new Range(r1,r2);
		assertEquals(10, r3.getLowerBoundary());
		assertEquals(10, r3.getUpperBoundary());
	}
}
