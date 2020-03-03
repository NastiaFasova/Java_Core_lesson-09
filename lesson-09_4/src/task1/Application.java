/*
 * Logos IT Academy
 * */

package task1;

import java.util.Scanner;

/**
 * @since java 13
 * @author Nastia Fasova
 * @version 11.30 03 March 2020
 */

public class Application {

	public static void main(String[] args) throws WrongInputConsoleParametersException {

		/* declaring the massive of all the values of enumerations */
		Months[]  m = Months.values();
		Seasons[] s = Seasons.values();

		Scanner scan = new Scanner(System.in);

		/* endless while() loop */
		while (true) {
			menu();
			String choice = scan.next();

			/* This try-block checks whether the user entered a number */
			try {
				Integer.parseInt(choice);
			} catch (Exception e) {
				System.out.println("You haven't entered a number!");
			}

			/* switch-block which depicts an example of a simple menu */
			switch (choice) {
			case "1": {
				System.out.println("¬вед≥ть назву м≥с€ц€: ");

				/* The user enters a month */
				String month = scan.next().toUpperCase();

				/* the checking of the accuracy of the input */
				checking(month);

				boolean flag = isMonthExisted(m, month);
				catchProblem(flag);
				break;

			}
			case "2": {
				System.out.println("¬вед≥ть назву м≥с€ц€: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				String season = Months.valueOf(month).getSeasons().toString();
				System.out.println("ћ≥с€ц≥ т≥Їњ ж самоњ пори року: ");

				/*
				 * for-each loop which looks for the month of the same season with help of
				 * getSeason() function
				 */
				for (Months months : m) {
					if (Months.valueOf(months.toString()).getSeasons().toString().equals(season)) {
						System.out.println(months.toString());
					}
				}
				catchProblem(flag);
				break;
			}
			case "3": {
				System.out.println("¬вед≥ть назву м≥с€ц€: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				int daysNumber = Months.valueOf(month).getDays();
				System.out.println("ћ≥с€ц≥ з такою ж самою к≥льк≥стю дн≥в: ");

				/*
				 * for-each loop which looks for the month with the same number of days with
				 * help of getDays() function
				 */
				for (Months months : m) {
					if (months.getDays() == daysNumber) {
						System.out.println(months.toString());
					}
				}
				catchProblem(flag);
				break;
			}
			case "4": {
				System.out.println("¬вед≥ть назву м≥с€ц€: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				int daysNumber = Months.valueOf(month).getDays();
				System.out.println("ћ≥с€ц≥ з меншою к≥льк≥стю дн≥в: ");
				
				for (Months mon : m) {
					if (mon.getDays() < daysNumber) {
						System.out.println(mon.toString());
					}
				}
				catchProblem(flag);
				break;
			}
			case "5": {
				System.out.println("¬вед≥ть назву м≥с€ц€: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				int daysNumber = Months.valueOf(month).getDays();
				System.out.println("ћ≥с€ц≥ з б≥льшою к≥льк≥стю дн≥в: ");
				
				for (Months mon : m) {
					if (mon.getDays() > daysNumber) {
						System.out.println(mon.toString());
					}
				}
				catchProblem(flag);
				break;
			}
			case "6": {
				System.out.println("¬вед≥ть назву пори року: ");
				String season = scan.next().toUpperCase();
				checking(season);
				boolean flag = isSeasonExisted(s, season);
				
				if (flag) {
					System.out.println("Ќаступна пора року: ");

					/* This is a variable of type Season which the user enters */
					Seasons seasons = Seasons.valueOf(season);

					/* The suquence number of the entered season */
					int ordinal = seasons.ordinal();
					if (ordinal == (s.length - 1)) {
						ordinal = 0;
						System.out.println(s[ordinal]);
					} else {
						System.out.println(s[ordinal + 1]);
					}
				}

				break;
			}
			case "7": {
				System.out.println("¬вед≥ть назву пори року: ");
				String season = scan.next().toUpperCase();
				boolean flag = isSeasonExisted(s, season);
				
				if (flag) {
					System.out.println("ѕопередн€ пора року: ");
					Seasons seas = Seasons.valueOf(season);
					int ordinal = seas.ordinal();
					if (ordinal == 0) {
						ordinal = s.length - 1;
						System.out.println(s[ordinal]);
					} else {
						System.out.println(s[ordinal - 1]);
					}
				}
				break;
			}
			case "8": {
				System.out.println("ћ≥с€ц≥ ≥з парною к≥льк≥стю дн≥в: ");
				
				for (Months months : m) {
					if (months.getDays() % 2 == 0) {
						System.out.println(months.toString());
					}
				}
				break;
			}
			case "9": {
				System.out.println("ћ≥с€ц≥ ≥з непарною к≥льк≥стю дн≥в: ");
				
				for (Months months : m) {
					if (months.getDays() % 2 != 0) {
						System.out.println(months.toString());
					}
				}
				break;
			}
			case "10": {
				System.out.println("¬вед≥ть назву м≥с€ц€: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				int daysNumber = Months.valueOf(month).getDays();
				
				if (flag) {
					if (daysNumber % 2 == 0) {
						System.out.println("¬ведений вами м≥с€ць маЇ парну к≥льк≥сть дн≥в");
					} else {
						System.out.println("¬ведений вами м≥с€ць маЇ непарну к≥льк≥сть дн≥в");
					}
				}
				catchProblem(flag);
				break;

			}
			default:{
			System.out.println("Something went wrong...");

			}
			scan.close();
		}
		}

	}

	/** This is a function which prints the menu */
	static void menu() {
		System.out.println("¬вед≥ть 1, €кщо хочете перев≥рити чи Ї такий м≥с€ць: ");
		System.out.println("¬вед≥ть 2, €кщо хочете вивести вс≥ м≥с€ц≥ т≥Їњ ж пори року: ");
		System.out.println("¬вед≥ть 3, €кщо хочете вивести вс≥ м≥с€ц≥ з т≥Їю ж к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 4, €кщо хочете вивести вс≥ м≥с€ц≥ з меншою к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 5, €кщо хочете вивести вс≥ м≥с€ц≥ з б≥льшою к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 6, €кщо хочете вивести наступну пору року: ");
		System.out.println("¬вед≥ть 7, €кщо хочете вивести попередню пору року: ");
		System.out.println("¬вед≥ть 8, €кщо хочете вивести вс≥ м≥с€ц≥ ≥з парною к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 9, €кщо хочете вивести вс≥ м≥с€ц≥ ≥з непарною к≥льк≥стю дн≥в: ");
		System.out.println("¬вед≥ть 10, €кщо хочете перев≥рити чи введений вами м≥с€ць маЇ парну к≥льк≥сть дн≥в: ");
	}

	/**
	 * This is a function which checks the accuracy of your input and throws
	 * exceptions
	 */
	public static void checking(String month) throws WrongInputConsoleParametersException {
		String paternFormat = "[a-zA-Z]*";

		/* This string restricts the entering of all the symbols except letters */
		if (!month.matches(paternFormat)) {
			throw new WrongInputConsoleParametersException("Your input contains unappropriate characters...");
		}

		/* restricts entering of the string which contains less than 3 letters */
		if (month.length() < 3) {
			throw new WrongInputConsoleParametersException("Your input contains less characters...");
		}
	}
	
	
	/** This function informs the user about absence of the month in the enumeration*/
	public static void catchProblem(boolean flag) {
		if (!flag) {
			System.out.println("“акого м≥с€ц€ не ≥снуЇ...");
		}
	}
	

	/**
	 * This function checks whether the user entered the month which exists in
	 * enumeration of Month
	 */
	public static boolean isMonthExisted(Months[] m, String month) {
		boolean flag = false;

		/*
		 * checking the presence of the entered month in the existed enumeration of
		 * Months
		 */
		for (Months months : m) {
			if (months.name().equals(month)) {
				System.out.println("ћ≥с€ць ≥снуЇ");
				flag = true;
			}
		}
		return flag;
	}

	

	/**
	 * This function checks whether the user entered the season which exists in
	 * enumeration of Season
	 */
	public static boolean isSeasonExisted(Seasons[] s, String season) {
		boolean flag = false;

		/*
		 * checking the presence of the entered season in the existed enumeration of
		 * Seasons
		 */
		for (Seasons seasons : s) {
			if (seasons.name().equals(season)) {
				System.out.println("ѕора року ≥снуЇ");
				flag = true;
			}
		}
		return flag;
	}

}
