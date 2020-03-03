package task2;


public class Methods {
	private int num1;
	private int num2;

	int sum(int num1, int num2) throws IllegalAccessException, MyException {
		System.out.println("This method should calculate the sum");
		check(num1, num2);
		return num1 + num2;
	}

	int extract(int num1, int num2) throws IllegalAccessException, MyException {
		System.out.println("This method should extract");
		check(num1, num2);
		return num1 - num2;
	}

	int multiply(int num1, int num2) throws IllegalAccessException, MyException {
		System.out.println("This method should multiply");
		check(num1, num2);
		return num1 * num2;
	}

	double divide(int num1, int num2) throws IllegalAccessException, MyException {
		System.out.println("This method should divide");
		check(num1, num2);
		return num1 / num2;
	}

	public void check(int num1, int num2) throws IllegalAccessException, MyException {
		if ((num1 < 0) || (num2 < 0)) {
			System.out.println("One of your number is less than zero");
			throw new IllegalArgumentException();
		}
		if ((num1 == 0) || (num2 == 0)) {
			System.out.println("One of your number is zero");
			throw new ArithmeticException();
		}
		if ((num1 == 0) && (num2 == 0)) {
			System.out.println("You are forbidden to enter zeroes...");
			throw new IllegalAccessException();
		}
		if ((num1 > 0) && (num2 > 0)) {
			throw new MyException("MyException is thrown. Your numbers are greater than zero...");
		}

	}

}
