package se.chho.range;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

public class RangeTest {

	@Test
	public void testInstantiateWithString()
	{
		Range r = new Range("[0,5)");
		assertTrue(true);
	}
	
	@Test
	public void testInstantiateWithTwoRangeObjects()
	{
		Range r1 = new Range("(0,5)");
		Range r2 = new Range("(0,15]");
		Range r3 = new Range(r1,r2); 
		assertTrue(true);
	}
	
	@Test
	public void testValidInput() 
	{
		Range r = new Range("Hej, Svejs");
	}

	// TODO: Fortsätt här 2012-12-29
    @Test
    public void someMethodThatThrowsCustomException() {
        thrown.expect(CustomException.class);
        thrown.expect(CustomMatcher.hasCode("110501"));

        MyObj obj = new MyObj();
        obj.methodThatThrowsCustomException();
    }
}


}
