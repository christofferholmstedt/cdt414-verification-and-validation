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
	 * If invalid this.Protocol is set to "Invalid".
	 */
	private void validateProtocol() {
		if (!this.protocol.matches("(http|ftp|smtp)")) {
			this.protocol = "Invalid";
		}
	}
	
	/***
	 * Validates whether the Domain in this instance is valid or not.
	 * If invalid this.domain is set to "Invalid".
	 */
	private void validateDomain() {
		// Regex found from http://rubular.com/r/yP6dHFEhrl
		// by Brian Ray at "http://stackoverflow.com/questions/1128168/validation-for-url-domain-using-regex-rails"
		// Slightly modified.
		if (!this.domain.matches("[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,6}")) {
			this.domain = "Invalid";
		}
	}
	
	/***
	 * Validates whether the Path in this instance is valid or not.
	 * If invalid this.path is set to "Invalid".
	 */
	private void validatePath() {
		if (!this.path.matches("(\\s)|[a-z0-9]*|((?=.*[/~?=]).*)")) {
			this.path = "Invalid";
		}
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
		} else if (var1.matches("((?!://).)*")) {
			// Do nothing default values are Invalid for all subcomponents
			// in the url.
		
		} else {
			String[] subStrings = var1.split("(://)",2);
			this.protocol = subStrings[0];
	
			// No path delimiter
			if (subStrings[1].matches("(?=.*[/]).*")) {
				String[] subStrings2 = subStrings[1].split("/",2);
				
				
				this.domain = subStrings2[0];
				this.path = subStrings2[1];
				
			} else {
				this.path = "Invalid";
				this.domain = "Invalid";
				this.protocol = "Invalid";
			}
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

