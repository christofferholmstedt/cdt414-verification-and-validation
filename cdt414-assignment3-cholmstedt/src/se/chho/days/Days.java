package se.chho.days;

/***
 * Days class calculates number of days between two dates.
 * Accepts values from year 1 to year 2999.
 * 
 * @author christoffer
 *
 */
public class Days {
	int date1Year, date2Year, date1Month, date2Month, date1Day, date2Day;
	int days = -1;
	Boolean errorInCalculation = false;
	String patternValidDate =
			"^(0[0-9]|1[0-9]|2[0-9])\\d([1-9])[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$";
	
	public Days (String date1, String date2)
	{
		if (date1.matches(this.patternValidDate)
				&& date2.matches(this.patternValidDate))
		{
			String[] parsedDate1Strings = date1.split("-");
			String[] parsedDate2Strings = date2.split("-");
			
			// Date 1
			this.date1Year = Integer.parseInt(parsedDate1Strings[0]);
			this.date1Month = Integer.parseInt(parsedDate1Strings[1]);
			this.date1Day = Integer.parseInt(parsedDate1Strings[2]);
			
			// Date 2
			this.date2Year = Integer.parseInt(parsedDate2Strings[0]);
			this.date2Month = Integer.parseInt(parsedDate2Strings[1]);
			this.date2Day = Integer.parseInt(parsedDate2Strings[2]);
			
			// Run calculation
			calculateDays();
		} else {
			this.errorInCalculation = true;
			setDays(-1);
		}
	}
	

	/***
	 * Calculate the number of days between two days.
	 * Date values to use available in object as integers.
	 */
	private void calculateDays() 
	{
		int k = -1;
		k = Math.abs(this.date1Day - this.date2Day);
		
		this.setDays(k);
	}
	
	/***
	 * Get days in this object.
	 * @return The number of days between two dates
	 */
	public int getDays() {
		return this.days;
	}
	
	/***
	 * Set days in this object.
	 * @param days The number of days between two dates.
	 */
	private void setDays(int days) {
		if (this.errorInCalculation)
		{
			this.days = -1;
		} else {
			this.days = days;
		}
	}
	
}
