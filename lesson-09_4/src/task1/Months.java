package task1;


/**This is our enumeration constructors of months which have 
 * two parameters : the number of days and the season*/
public enum Months {
	JANUARY(31, Seasons.WINTER), 
	FEBRUARY(28, Seasons.WINTER), 
	MARCH(31, Seasons.SPRING), 
	APRIL(30, Seasons.SPRING),
	MAY(31, Seasons.SPRING), 
	JUNE(30, Seasons.SUMMER), 
	JULY(31, Seasons.SUMMER), 
	AUGUST(31, Seasons.SUMMER),
	SEPTEMBER(30, Seasons.FALL), 
	OCTOBER(31, Seasons.FALL), 
	NOVEMBER(30, Seasons.FALL),
	DECEMBER(31, Seasons.WINTER);

	/*Initializing of enumeration Seasons*/
	Seasons seasons;
	
	/**This is the number of days in a month*/
	private int days;

	/**This is our constructor*/
	Months(int days, Seasons seasons) {
		this.seasons = seasons;
		this.days= days;
	}

	/**This is a function which returns the number of days in a month*/
	public int getDays() {
		return days;
	}

	/**This is function which returns the season of a month type of enum Season*/
	public Seasons getSeasons() {
		return seasons;
	}
}
