package se.chho.lab1;

/***
 * Regex help from link below
 * http://www.vogella.com/articles/JavaRegularExpressions/article.html
 * 
 * @author Christoffer Holmstedt
 *
 */
public class UrlParser {
	private String input;
	private String protocol = "Invalid";
	private String domain = "Invalid";
	private String path = "Invalid";

	public UrlParser(String url) {
		this.input = url;
		
		urlDecompose(this.input);
		validateProtocol();
		validateDomain();
		validatePath();
	}

	/***
	 * Validates whether the Protocol in this instance is valid or not.
	 * If invalid this.Protocol is set to "invalid".
	 */
	private void validateProtocol() {
		// TODO Auto-generated method stub
		
	}
	
	/***
	 * Validates whether the Domain in this instance is valid or not.
	 * If invalid this.domain is set to "invalid".
	 */
	private void validateDomain() {
		// TODO Auto-generated method stub
		
	}
	
	/***
	 * Validates whether the Path in this instance is valid or not.
	 * If invalid this.path is set to "invalid".
	 */
	private void validatePath() {
		
	}
	/***
	 * Decompose the supplied url into three different parts.
	 * @param var1
	 */
	private void urlDecompose(String var1) {
		
		// Empty string OR whitespaces in the input string
		if (var1.matches("") || var1.matches("(.*)(\\s)(.*)"))
		{
			// Do nothing default values are Invalid for all subcomponents
			// in the url.

		// No protocol delimiter
		
		//*************** CONTINUE HERE **************
		//*************** CONTINUE HERE **************
		//*************** CONTINUE HERE **************
		// Try to exclude all strings which don't have the
		// protocol delimiter.
		} else if (var1.matches("(.*)?!(://)(.*)")) {
			// Do nothing default values are Invalid for all subcomponents
			// in the url.
			System.out.println(this.protocol);
			
		} else {
			String[] subStrings = var1.split("(://)",2);
			this.protocol = subStrings[0];
	
			String[] subStrings2 = subStrings[1].split("/",2);
			this.domain = subStrings2[0];
			this.path = subStrings2[1];
		}
	}

	/***
	 * getProtocol method
	 * @return String The protocol part of the supplied URL.
	 */
	public String getProtocol() {
		return this.protocol;
	}
	
	/***
	 * getDomain method
	 * @return String The domain part of the supplied URL.
	 */
	public String getDomain() {
		return this.domain;
	}

	/***
	 * getPath method
	 * @return String The path part of the supplied URL.
	 */
	public String getPath() {
		return this.path;
	}

}

