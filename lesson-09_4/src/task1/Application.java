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
				System.out.println("������ ����� �����: ");

				/* The user enters a month */
				String month = scan.next().toUpperCase();

				/* the checking of the accuracy of the input */
				checking(month);

				boolean flag = isMonthExisted(m, month);
				catchProblem(flag);
				break;

			}
			case "2": {
				System.out.println("������ ����� �����: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				String season = Months.valueOf(month).getSeasons().toString();
				System.out.println("̳���� 򳺿 � ���� ���� ����: ");

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
				System.out.println("������ ����� �����: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				int daysNumber = Months.valueOf(month).getDays();
				System.out.println("̳���� � ����� � ����� ������� ���: ");

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
				System.out.println("������ ����� �����: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				int daysNumber = Months.valueOf(month).getDays();
				System.out.println("̳���� � ������ ������� ���: ");
				
				for (Months mon : m) {
					if (mon.getDays() < daysNumber) {
						System.out.println(mon.toString());
					}
				}
				catchProblem(flag);
				break;
			}
			case "5": {
				System.out.println("������ ����� �����: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				int daysNumber = Months.valueOf(month).getDays();
				System.out.println("̳���� � ������ ������� ���: ");
				
				for (Months mon : m) {
					if (mon.getDays() > daysNumber) {
						System.out.println(mon.toString());
					}
				}
				catchProblem(flag);
				break;
			}
			case "6": {
				System.out.println("������ ����� ���� ����: ");
				String season = scan.next().toUpperCase();
				checking(season);
				boolean flag = isSeasonExisted(s, season);
				
				if (flag) {
					System.out.println("�������� ���� ����: ");

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
				System.out.println("������ ����� ���� ����: ");
				String season = scan.next().toUpperCase();
				boolean flag = isSeasonExisted(s, season);
				
				if (flag) {
					System.out.println("��������� ���� ����: ");
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
				System.out.println("̳���� �� ������ ������� ���: ");
				
				for (Months months : m) {
					if (months.getDays() % 2 == 0) {
						System.out.println(months.toString());
					}
				}
				break;
			}
			case "9": {
				System.out.println("̳���� �� �������� ������� ���: ");
				
				for (Months months : m) {
					if (months.getDays() % 2 != 0) {
						System.out.println(months.toString());
					}
				}
				break;
			}
			case "10": {
				System.out.println("������ ����� �����: ");
				String month = scan.next().toUpperCase();
				checking(month);
				boolean flag = isMonthExisted(m, month);
				int daysNumber = Months.valueOf(month).getDays();
				
				if (flag) {
					if (daysNumber % 2 == 0) {
						System.out.println("�������� ���� ����� �� ����� ������� ���");
					} else {
						System.out.println("�������� ���� ����� �� ������� ������� ���");
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
		System.out.println("������ 1, ���� ������ ��������� �� � ����� �����: ");
		System.out.println("������ 2, ���� ������ ������� �� ����� 򳺿 � ���� ����: ");
		System.out.println("������ 3, ���� ������ ������� �� ����� � �� � ������� ���: ");
		System.out.println("������ 4, ���� ������ ������� �� ����� � ������ ������� ���: ");
		System.out.println("������ 5, ���� ������ ������� �� ����� � ������ ������� ���: ");
		System.out.println("������ 6, ���� ������ ������� �������� ���� ����: ");
		System.out.println("������ 7, ���� ������ ������� ��������� ���� ����: ");
		System.out.println("������ 8, ���� ������ ������� �� ����� �� ������ ������� ���: ");
		System.out.println("������ 9, ���� ������ ������� �� ����� �� �������� ������� ���: ");
		System.out.println("������ 10, ���� ������ ��������� �� �������� ���� ����� �� ����� ������� ���: ");
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
			System.out.println("������ ����� �� ����...");
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
				System.out.println("̳���� ����");
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
				System.out.println("���� ���� ����");
				flag = true;
			}
		}
		return flag;
	}

}
