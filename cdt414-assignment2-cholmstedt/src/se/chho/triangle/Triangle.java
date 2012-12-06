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
		
		this.triangleType = decideTriangleType();
		System.out.println(this.toString());
	}
	
	private String decideTriangleType()
	{
		// Validate input data
		if ( (this.sideOne <= 0) || (this.sideTwo <= 0) || (this.sideThree <= 0) ) {
			return "Invalid";
			
		} else if ( (this.sideOne + this.sideTwo <= this.sideThree) || 
					(this.sideOne + this.sideThree <= this.sideTwo) || 
					(this.sideTwo + this.sideThree <= this.sideOne) ) {
			return "Invalid";
		}
		
		// Set Triangle type
		if ( (this.sideOne == this.sideTwo) && (this.sideOne == this.sideThree) ) {
			return "Equilateral";
			
		} else if ( (this.sideOne == this.sideTwo) || (this.sideOne == this.sideThree) || (this.sideTwo == this.sideThree) ) {
			return "Isosceles";
			
		} else if ( (this.sideOne != this.sideTwo) && (this.sideOne != this.sideThree) && (this.sideTwo != this.sideThree) ) {
			return "Scalene";
		}
		return "Not set";
	}
	
	@Override
	/***
	 * Override toString java.lang.Object method
	 */
	public String toString() 
	{
		return this.triangleType;
	}

}
