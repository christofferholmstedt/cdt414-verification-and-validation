package se.chho.days;

import static org.junit.Assert.*;

import org.junit.Test;

public class DaysTest {

	//******** General testing	
	@Test
	// Positive testing, basic case, only few days between
	public void testDayCalculation() {
		Days d = new Days("2012-01-12", "2012-01-14");
		assertEquals(2, d.getDays());
	}
	
	@Test
	// String input must match format yyyy-MM-dd
	public void testInvalidStringInput() {
		Days d = new Days("20120112", "2012-01-14");
		assertEquals(-1, d.getDays());
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
		Days d = new Days("2012-01-12", "0000-02-23");
		assertEquals(-1, d.getDays());
	}

}
