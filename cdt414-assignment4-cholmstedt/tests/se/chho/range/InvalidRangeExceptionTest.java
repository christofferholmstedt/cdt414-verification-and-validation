package se.chho.range;

import static org.junit.Assert.*;

import org.junit.Test;

public class InvalidRangeExceptionTest {

	@Test
	public void testInstantiateWithErrorCode()
	{
		InvalidInputException e = new InvalidInputException("Test this exception.");
		assertEquals("Test this exception.", e.getErrorCode());
	}

}
