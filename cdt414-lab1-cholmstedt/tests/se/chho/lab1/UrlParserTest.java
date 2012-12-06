package se.chho.lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class UrlParserTest {

	@Test
	public void testValidUrl() {
		UrlParser uP1 = new UrlParser("http://www.example.com/test");
		assertEquals("http", uP1.getProtocol());
		assertEquals("www.example.com", uP1.getDomain());
		assertEquals("test", uP1.getPath());
	}

	@Test
	public void testEmptyInput() {
		UrlParser uP1 = new UrlParser("");
		assertEquals("Invalid", uP1.getProtocol());
		assertEquals("Invalid", uP1.getDomain());
		assertEquals("Invalid", uP1.getPath());
	}
	
	@Test
	public void testNoWhitespace() {
		UrlParser uP1 = new UrlParser("http:/ /www.example .com/te st");
		UrlParser uP2 = new UrlParser("http://www.example.com/test ");
		UrlParser uP3 = new UrlParser(" http://www.example.com/test");
		
		// Whitespaces inbetween characters
		assertEquals("Invalid", uP1.getProtocol());
		assertEquals("Invalid", uP1.getDomain());
		assertEquals("Invalid", uP1.getPath());
		
		// Whitespaces in the end
		assertEquals("Invalid", uP2.getProtocol());
		assertEquals("Invalid", uP2.getDomain());
		assertEquals("Invalid", uP2.getPath());
		
		// Whitespaces in the beginning
		assertEquals("Invalid", uP3.getProtocol());
		assertEquals("Invalid", uP3.getDomain());
		assertEquals("Invalid", uP3.getPath());
	}
	
	@Test
	public void testNoProtocolDelimiter() {
		UrlParser uP1 = new UrlParser("www.example.com/test");
		assertEquals("Invalid", uP1.getProtocol());
		assertEquals("Invalid", uP1.getDomain());
		assertEquals("Invalid", uP1.getPath());
	}
}
