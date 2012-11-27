package se.chho.triangle;

public class Triangle {

	private int sideOne;
	private int sideTwo;
	private int sideThree;

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
	}
	
	@Override
	/***
	 * Override toString java.lang.Object metod
	 */
	public String toString() 
	{
		if (this.sideOne < this.sideTwo) {
			if (this.sideTwo < this.sideThree) {
				return "Scalene - " + this.sideOne + ","
						+ this.sideTwo + ","
						+ this.sideThree;
			}
		}
		return "hej";
	}

}
