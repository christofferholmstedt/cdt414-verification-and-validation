package se.chho.days;

/***
 * Days class calculates number of days between two dates.
 * Accepts values from year 1 to year 2999.
 * 
 * @author christoffer
 */
public class Days {
	private int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private int[] daysInMonthLeapYear = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
	
	int date1Year, date2Year, date1Month, date2Month, date1Day, date2Day;
	int totalNumberOfDays = -1;
	boolean errorInCalculation = false;
	String patternValidDate =
			"^(0[0-9]|1[0-9]|2[0-9])\\d([0-9])[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$";
	
	public Days (String date1, String date2)
	{
		if (date1.matches(this.patternValidDate)
				&& date2.matches(this.patternValidDate))
		{
			String[] parsedDate1Strings = date1.split("-");
			String[] parsedDate2Strings = date2.split("-");
			
			// Input date 1
			this.date1Year = Integer.parseInt(parsedDate1Strings[0]);
			this.date1Month = Integer.parseInt(parsedDate1Strings[1]);
			this.date1Day = Integer.parseInt(parsedDate1Strings[2]);
			
			if (!validDate(this.date1Year, this.date1Month, this.date1Day))
				this.errorInCalculation = true;
			
			// Input date 2
			this.date2Year = Integer.parseInt(parsedDate2Strings[0]);
			this.date2Month = Integer.parseInt(parsedDate2Strings[1]);
			this.date2Day = Integer.parseInt(parsedDate2Strings[2]);
			
			if (!validDate(this.date2Year, this.date2Month, this.date2Day))
				this.errorInCalculation = true;
			
			
			// Make sure this.date1XYZ stores the earliest date of the two given as input.
			if (earliestDate() == 0) 
			{
				// Same date given
				setDays(0);
			} 
			else if (earliestDate() == 2)
			{
				// Swap date variables
				int tempIntStorage;
				
				// Day swap
				tempIntStorage = this.date1Day;
				this.date1Day = this.date2Day;
				this.date2Day = tempIntStorage;
				
				// Month swap
				tempIntStorage = this.date1Month;
				this.date1Month = this.date2Month;
				this.date2Month = tempIntStorage;
				
				// Year swap
				tempIntStorage = this.date1Year;
				this.date1Year = this.date2Year;
				this.date2Year = tempIntStorage;
				
				// Run calculation
				calculateDays();
			} else if (earliestDate() == 1) 
			{
				// Run calculation
				calculateDays();
			}
			
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
		int numberOfDays = 0;		
		int tempYear = this.date1Year;
		
		// ************** If more than a complete year is separating the dates 
		if (this.date2Year - this.date1Year > 1)
		{
			// Count days until first last of December.
			numberOfDays += daysUntilLastOfDecember(this.date1Year, this.date1Month, this.date1Day);
			
			// Count all days for complete years.
			while (this.date2Year - tempYear > 1) {
				numberOfDays += daysInYear(tempYear);
				tempYear++;
			}
			
			// Count days from the first of January in the last year
			// Subtract one to not include the last date.
			numberOfDays += daysFromFirstOfJanuary(this.date2Year, this.date2Month, this.date2Day) - 1;
		}
		// ************** If there is no complete year between the dates
		else if (this.date2Year - this.date1Year == 1) 
		{
			// Count days until first last of December.
			numberOfDays += daysUntilLastOfDecember(this.date1Year, this.date1Month, this.date1Day);
			
			// Count days from the first of January in the last year
			// Subtract one to not include the last date.
			numberOfDays += daysFromFirstOfJanuary(this.date2Year, this.date2Month, this.date2Day) - 1;
		}
		// ************** If there is only a few days or months in the same year
		// ************** between the dates
		else if (this.date1Year == this.date2Year) 
		{
			// Count days from the first of January for the last date
			numberOfDays += daysFromFirstOfJanuary(this.date2Year, this.date2Month, this.date2Day);
			
			// Subtract days from the first of January up until the day of the first date
			numberOfDays -= daysFromFirstOfJanuary(this.date1Year, this.date1Month, this.date1Day);
		}

		this.setDays(numberOfDays);
	}
	
	/***
	 * Get days in this object.
	 * @return The number of days between two dates
	 */
	public int getDays() {
		return this.totalNumberOfDays;
	}
	
	/***
	 * Set days in this object.
	 * @param days The number of days between two dates.
	 */
	private void setDays(int days) {
		if (this.errorInCalculation)
		{
			this.totalNumberOfDays = -1;
		} else {
			this.totalNumberOfDays = days;
		}
	}

	/***
	 * Source: http://en.wikipedia.org/wiki/Leap_year#Algorithm
	 * @param year Year as an integer
	 * @return int 1 for true and 0 for false.
	 */
	public boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else if (year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * Checks if the this.date1 is earlier than this.date2
	 * @return
	 */

	public int earliestDate() {
		if (this.date1Year < this.date2Year)
		{
			return 1;
		} 
		else if (this.date1Year <= this.date2Year && this.date1Month < this.date2Month)
		{
			return 1;
		}
		else if (this.date1Year <= this.date2Year && this.date1Month <= this.date2Month && this.date1Day < this.date2Day) 
		{
			return 1;
		}
		else if (this.date1Year == this.date2Year && this.date1Month == this.date2Month && this.date1Day == this.date2Day)
		{
			return 0;
		}
		return 2;
	}
	
	/***
	 * Count the number of days from the first of january until the 
	 * given date, including the first of january and the given date.
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int daysFromFirstOfJanuary(int year, int month, int day)
	{
		int countDays = 0;
		int countMonth = 1;
		
		if (isLeapYear(year)) 
		{
			while (countMonth < month) 
			{
				countDays += this.daysInMonthLeapYear[countMonth];
				countMonth++;
			}
			countDays += day;
		} 
		else 
		{
			while (countMonth < month) 
			{
				countDays += this.daysInMonth[countMonth];
				countMonth++;
			}
			countDays += day;
		}
		return countDays;
	}

	/***
	 * Returns number of days in a year depending on if it's leap year or not.
	 * @param year
	 * @return
	 */
	public int daysInYear(int year) 
	{
		if (isLeapYear(year))
		{
			return 366;
		}
		else
		{
			return 365;
		}
	}

	/***
	 * Count the number of days from given date to the last of december, including
	 * starting and finishing day.
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */

	public int daysUntilLastOfDecember(int year, int month, int day) {
		int countDays = 0;
		int countMonth = month + 1;
		
		if (isLeapYear(year)) 
		{
			countDays += this.daysInMonthLeapYear[month] - day + 1;
			
			while (countMonth > month && countMonth <= 12) 
			{
				countDays += this.daysInMonthLeapYear[countMonth];
				countMonth++;
			}
			
		} 
		else 
		{
			countDays += this.daysInMonth[month] - day + 1;
			
			while (countMonth > month && countMonth <= 12) 
			{
				countDays += this.daysInMonth[countMonth];
				countMonth++;
			}
		}
		return countDays;
	}


	/***
	 * Check if date given is a valid date.
	 * @param year
	 * @param month
	 * @param day
	 * @return boolean 
	 */
	public boolean validDate(int year, int month, int day) {
		
		if (isLeapYear(year)) 
		{
			if (this.daysInMonthLeapYear[month] >= day)
				return true;
		}
		else 
		{		
			if (this.daysInMonth[month] >= day)
				return true;
		}
		
		return false;
	}
	
}
