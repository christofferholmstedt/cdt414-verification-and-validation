package se.chho.days;

import static org.junit.Assert.*;

import org.junit.Test;

public class DaysTest {


	//******** Test days until last of december
	@Test
	public void testDaysUntilLastOfDecember1() {
		Days d = new Days("2011-01-01", "2013-01-31");
		assertEquals(12, d.daysUntilLastOfDecember(2012, 12, 20));
	}
		
	@Test
	public void testDaysUntilLastOfDecember2() {
		Days d = new Days("2011-01-01", "2013-10-31");
		assertEquals(352, d.daysUntilLastOfDecember(2012, 01, 15));
	}
	
	@Test
	public void testDaysUntilLastOfDecember3() {
		Days d = new Days("2011-01-01", "2013-10-31");
		assertEquals(351, d.daysUntilLastOfDecember(2011, 01, 15));
	}

	//******** Test days from first of january
	@Test
	public void testDaysFromFirstOfJanuary1() {
		Days d = new Days("2011-01-01", "2013-01-31");
		assertEquals(10, d.daysFromFirstOfJanuary(2012, 01, 10));
	}
		
	@Test
	public void testDaysFromFirstOfJanuary2() {
		Days d = new Days("2011-01-01", "2013-10-31");
		assertEquals(289, d.daysFromFirstOfJanuary(2012, 10, 15));
	}
	
	@Test
	public void testDaysFromFirstOfJanuary3() {
		Days d = new Days("2011-01-01", "2013-10-31");
		assertEquals(288, d.daysFromFirstOfJanuary(2011, 10, 15));
	}
	
	//******** Test days in a year
	@Test
	public void testDaysInAYear1() {
		Days d = new Days("2011-01-01", "2013-01-31");
		assertEquals(366, d.daysInYear(2012));
	}
	
	@Test
	public void testDaysInAYear2() {
		Days d = new Days("2012-01-01", "2014-01-31");
		assertEquals(365, d.daysInYear(2013));
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
	
	//******** Invalid dates	
	@Test
	public void testInvalidDate1() {
		Days d = new Days("2011-02-29", "2012-10-23");
		assertTrue(d.validDate(2012, 02, 29));
		assertFalse(d.validDate(2011, 02, 29));
	}
	
	@Test
	public void testInvalidDate2() {
		Days d = new Days("2011-02-29", "2012-10-23");
		assertFalse(d.validDate(2012, 06, 31));
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
