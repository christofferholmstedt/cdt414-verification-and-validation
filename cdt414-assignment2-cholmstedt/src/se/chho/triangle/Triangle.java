package se.chho.triangle;

public class Triangle {

	private int sideOne;
	private int sideTwo;
	private int sideThree;
	private String triangleType;  
	
	/***
	 * Constructor
	 * @param i
	 * @param j
	 * @param k
	 */
	public Triangle(int i, int j, int k)
	{
		this.sideOne = i;
		this.sideTwo = j;
		this.sideThree = k;
		this.triangleType = "Not set";
		
		decideTriangleType();
		this.toString();
	}
	
	private void decideTriangleType()
	{

	}
	
	@Override
	/***
	 * Override toString java.lang.Object metod
	 */
	public String toString() 
	{
		return this.triangleType;
	}

}
