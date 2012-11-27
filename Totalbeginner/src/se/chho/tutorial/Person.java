package se.chho.tutorial;

public class Person 
{
	/***
	 * String name
	 * 
	 */
	private String name;
	private int maximumBooks;
	
	/***
	 * Construct
	 */
	public Person() 
	{
		name = "unknown name";
		maximumBooks = 3;
	}

	/***
	 * getName
	 * @return
	 */
	public String getName() {
		return name;
	}

	/***
	 * setName
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/***
	 * getMaximumBooks
	 * @return
	 */
	public int getMaximumBooks() {
		return maximumBooks;
	}

	/***
	 * setMaximumBooks
	 * @param maximumBooks
	 */
	public void setMaximumBooks(int maximumBooks) {
		this.maximumBooks = maximumBooks;
	}
	
	/***
	 * Override toString java.lang.Object metod
	 */
	public String toString() 
	{
		return this.getName() + " (" + this.getMaximumBooks() + " books)";
	}
}
