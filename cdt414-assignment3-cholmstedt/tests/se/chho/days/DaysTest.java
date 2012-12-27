package se.chho.days;

import static org.junit.Assert.*;

import org.junit.Test;

public class DaysTest {


	//******** Test earliest date and equal dates.
	@Test
	public void testDaysInAYear1() {
		Days d = new Days("2011-01-01", "2013-01-31");
		assertEquals(366, d.numberOfDaysInYear(2012));
	}
	
	@Test
	public void testDaysInAYear2() {
		Days d = new Days("2012-01-01", "2014-01-31");
		assertEquals(365, d.numberOfDaysInYear(2013));
	}
	
	//******** Test earliest date and equal dates.
	@Test
	public void testEarliestDate1() {
		Days d = new Days("2012-01-01", "2012-01-31");
		assertEquals(1, d.earliestDate());
	}
	
	@Test
	// Input has the second date as earliest
	// but constructor will swap them and earliestDate()
	// will return 1.
	public void testEarliestDate2() {
		Days d = new Days("2012-01-01", "1999-01-31");
		assertEquals(1, d.earliestDate());
	}
	
	@Test
	public void testEqualDates() {
		Days d = new Days("2012-01-01", "2012-01-01");
		assertEquals(0, d.earliestDate());
	}
		
	//******** Number of days between known intervals
	@Test
	public void testDayCalculation1() {
		Days d = new Days("2012-01-01", "2012-01-31");
		assertEquals(30, d.getDays());
	}
	
	@Test
	public void testDayCalculation2() {
		Days d = new Days("2012-01-01", "2012-02-29");
		assertEquals(59, d.getDays());
	}
	
	@Test
	public void testDayCalculation3() {
		Days d = new Days("2012-01-01", "2013-03-01");
		assertEquals(425, d.getDays());
	}
	
	@Test
	public void testDayCalculation4() {
		Days d = new Days("2012-01-01", "2213-03-01");
		assertEquals(73473, d.getDays());
	}
	
	@Test
	// Reversed order of previous calculation
	public void testDayCalculation5() {
		Days d = new Days("2213-03-01", "2012-01-01");
		assertEquals(73473, d.getDays());
	}
	//******** General testing	
	@Test
	// Basic case, only few days between
	public void testBasicDayCalculation() {
		Days d = new Days("2012-01-12", "2012-01-14");
		assertEquals(2, d.getDays());
	}
	
	@Test
	// String input must match format yyyy-MM-dd
	public void testInvalidStringInput() {
		Days d = new Days("20120112", "2012-01-14");
		assertEquals(-1, d.getDays());
	}
	
	@Test
	// Year value below 1
	public void testLeapYear() {
		Days d = new Days("2001-01-12", "2012-02-23");
		assertTrue(d.isLeapYear(2000));
		assertTrue(d.isLeapYear(2004));
		assertFalse(d.isLeapYear(1900));
		assertFalse(d.isLeapYear(2013));
	}
	
	//******** Day values	
	@Test
	// Day value above 31
	public void testInvalidDayInput1() {
		Days d = new Days("2012-01-32", "2012-10-23");
		assertEquals(-1, d.getDays());
	}
	
	@Test
	// Day value below 1
	public void testInvalidDayInput2() {
		Days d = new Days("2012-01-12", "2012-10-00");
		assertEquals(-1, d.getDays());
	}
	
	//******** Month values	
	@Test
	// Month value above 12
	public void testInvalidMonthInput1() {
		Days d = new Days("2012-13-25", "2012-10-23");
		assertEquals(-1, d.getDays());
	}
	
	@Test
	// Month value below 1
	public void testInvalidMonthInput2() {
		Days d = new Days("2012-01-12", "2012-00-23");
		assertEquals(-1, d.getDays());
	}
	//******** Year values	
	@Test
	// Year value above 2999
	public void testInvalidYearInput1() {
		Days d = new Days("3000-01-25", "2012-10-23");
		assertEquals(-1, d.getDays());
	}
	
	@Test
	// Year value below 1
	public void testInvalidYearInput2() {
		Days d = new Days("2012-01-12", "4000-02-23");
		assertEquals(-1, d.getDays());
	}

}
