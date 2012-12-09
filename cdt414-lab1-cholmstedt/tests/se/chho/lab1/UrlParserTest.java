package se.chho.lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class UrlParserTest {

	@Test
	public void testValidUrl() {
		UrlParser uP1 = new UrlParser("http://www.example.com/test");
		UrlParser uP2 = new UrlParser("http://www.example.com/test/asdf/lkjjh");
		UrlParser uP3 = new UrlParser("http://www.mrtc.mdh.se/~acc01");
		
		assertEquals("http", uP1.getProtocol());
		assertEquals("www.example.com", uP1.getDomain());
		assertEquals("test", uP1.getPath());
		
		assertEquals("http", uP2.getProtocol());
		assertEquals("www.example.com", uP2.getDomain());
		assertEquals("test/asdf/lkjjh", uP2.getPath());
		
		assertEquals("http", uP3.getProtocol());
		assertEquals("www.mrtc.mdh.se", uP3.getDomain());
		assertEquals("~acc01", uP3.getPath());
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
		
		// Whitespaces inbetween
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
	
	@Test
	public void testNoPathDelimiter() {
		UrlParser uP1 = new UrlParser("http://www.example.com");
		UrlParser uP2 = new UrlParser("http://www.example.com/");
		
		assertEquals("Invalid", uP1.getProtocol());
		assertEquals("Invalid", uP1.getDomain());
		assertEquals("Invalid", uP1.getPath());
		
		assertEquals("http", uP2.getProtocol());
		assertEquals("www.example.com", uP2.getDomain());
		assertEquals("", uP2.getPath());
	}
	
	@Test
	public void testValidProtocols() {
		UrlParser uP1 = new UrlParser("http://www.example.com/test");
		UrlParser uP2 = new UrlParser("ftp://www.example.com/test");
		UrlParser uP3 = new UrlParser("smtp://www.example.com/test");
		UrlParser uP4 = new UrlParser("goasd://www.example.com/test");
		
		assertEquals("http", uP1.getProtocol());
		assertEquals("ftp", uP2.getProtocol());
		assertEquals("smtp", uP3.getProtocol());
		assertEquals("Invalid", uP4.getProtocol());
	}
	
	@Test
	public void testValidDomain() {
		UrlParser uP1 = new UrlParser("http://www.example.com/test");
		UrlParser uP2 = new UrlParser("ftp://www./example.com/test");
		UrlParser uP3 = new UrlParser("smtp://www.exampåäöle.com/test");
		UrlParser uP4 = new UrlParser("goasd://www.://://.com/test");
		UrlParser uP5 = new UrlParser("ftp://www.?example.com/test");
		UrlParser uP6 = new UrlParser("ftp://www.exam|ple.com/test");
		
		assertEquals("www.example.com", uP1.getDomain());
		assertEquals("Invalid", uP2.getDomain());
		assertEquals("Invalid", uP3.getDomain());
		assertEquals("Invalid", uP4.getDomain());
		assertEquals("Invalid", uP5.getDomain());
		assertEquals("Invalid", uP6.getDomain());
	}
	
	@Test
	public void testValidPath() {
		UrlParser uP1 = new UrlParser("http://www.example.com/test");
		UrlParser uP2 = new UrlParser("http://www.example.com/test?asdf=tva");
		UrlParser uP3 = new UrlParser("http://www.example.com/test?asdf=tva&sdf=34");
		UrlParser uP4 = new UrlParser("http://www.example.com/test/testAgain/testTwice");
		UrlParser uP5 = new UrlParser("http://www.example.com/teståäö");
		UrlParser uP6 = new UrlParser("http://www.example.com/test*");
		
		assertEquals("test", uP1.getPath());
		assertEquals("test?asdf=tva", uP2.getPath());
		assertEquals("test?asdf=tva&sdf=34", uP3.getPath());
		assertEquals("test/testAgain/testTwice", uP4.getPath());
		assertEquals("Invalid", uP5.getPath());
		assertEquals("Invalid", uP6.getPath());
	}
}
