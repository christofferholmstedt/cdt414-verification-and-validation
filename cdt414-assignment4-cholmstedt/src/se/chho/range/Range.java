package se.chho.range;

public class Range {
	private int lowerBoundary = 0, upperBoundary = 0;
	private boolean emptyRange = true;
	
	String patternValidInput =
			"^[\\(\\[]\\d*\\,\\d*[\\)\\]]$";
	
	public Range(String range)
	{
		if (!range.matches(this.patternValidInput)) {
			throw new InvalidInputException("Input must be on the format (x,y), [x,y] or any combination of brackets.");
		} else {
			parseLowerBoundary(range);
			parseUpperBoundary(range);
			
			if (this.lowerBoundary > this.upperBoundary) {
				throw new InvalidRangeException("The upper boundary (second integer) must be higher than the lower boundary (first integer).");
			} else {
				this.emptyRange = false;
			}
		}
	}
	
	/***
	 * Takes a range as string as input and sets
	 * the upper boundary for this range.
	 * @param range
	 */
	private void parseUpperBoundary(String range) {
		if (range.matches("(.*)\\]$")) {
			range = range.replace("]", "");
			String[] parsedRange = range.split(",");
			this.upperBoundary = Integer.parseInt(parsedRange[1]);
		} else if (range.matches("(.*)\\)$")) {
			range = range.replace(")", "");
			String[] parsedRange = range.split(",");
			this.upperBoundary = Integer.parseInt(parsedRange[1]) - 1;
		}
	}

	/***
	 * Takes a range as string as input and sets
	 * the lower boundary for this range.
	 * @param range
	 */
	private void parseLowerBoundary(String range) 
	{
		if (range.matches("^\\[(.*)")) {
			range = range.replace("[", "");
			String[] parsedRange = range.split(",");
			this.lowerBoundary = Integer.parseInt(parsedRange[0]);
		} else if (range.matches("^\\((.*)")) {
			range = range.replace("(", "");
			String[] parsedRange = range.split(",");
			this.lowerBoundary = Integer.parseInt(parsedRange[0]) + 1;
		}
	}

	public Range(Range r1, Range r2) 
	{
		if (r1.getUpperBoundary() < r2.getLowerBoundary() ||
			r1.getLowerBoundary() > r2.getUpperBoundary()) {
			this.emptyRange = true;
		
		} else if (r1.getLowerBoundary() <= r2.getLowerBoundary() &&
					r1.getUpperBoundary() >= r2.getUpperBoundary()) {
			this.emptyRange = false;
			this.lowerBoundary = r1.getLowerBoundary();
			this.upperBoundary = r1.getUpperBoundary();
			
		} else if (r2.getLowerBoundary() <= r1.getLowerBoundary() &&
					r2.getUpperBoundary() >= r1.getUpperBoundary()) {
			this.emptyRange = false;
			this.lowerBoundary = r2.getLowerBoundary();
			this.upperBoundary = r2.getUpperBoundary();
			
		} else if (r1.getUpperBoundary() >= r2.getLowerBoundary() &&
					r1.getLowerBoundary() <= r2.getLowerBoundary() && 
					r1.getUpperBoundary() < r2.getUpperBoundary()) {
			this.emptyRange = false;
			this.lowerBoundary = r2.getLowerBoundary();
			this.upperBoundary = r1.getUpperBoundary();
		} else if (r2.getUpperBoundary() >= r1.getLowerBoundary() &&
					r2.getLowerBoundary() <= r1.getLowerBoundary() && 
					r2.getUpperBoundary() < r1.getUpperBoundary()) {
			this.emptyRange = false;
			this.lowerBoundary = r1.getLowerBoundary();
			this.upperBoundary = r2.getUpperBoundary();
	}
	}

	/***
	 * Returns the lower boundary in this object's range
	 * @return int The lower boundary in this object's range
	 */
	public int getLowerBoundary() 
	{
		return this.lowerBoundary;
	}

	/***
	 * Returns the upper boundary in this object's range
	 * @return int The upper boundary in this object's range
	 */
	public int getUpperBoundary() 
	{
		return this.upperBoundary;
	}

	/***
	 * Returns boolean whether the given integer is within the range in current object or not.
	 * @param i integer to verify if it's within range
	 * @return true if the integer is within range.
	 */
	public boolean inRange(int i) 
	{
		if (i >= this.lowerBoundary && i <= this.upperBoundary && !this.emptyRange) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * Returns the status true or false if the object has an empty range or not.
	 * @return boolean
	 */
	public boolean isEmptyRange() 
	{
		return this.emptyRange;
	}

}
