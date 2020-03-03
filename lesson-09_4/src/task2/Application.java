package task2;

import java.util.Scanner;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IllegalAccessException, MyException, MySecondException {
		Scanner scan=new Scanner(System.in);
		menu();
		String choice=scan.next();
		if(choice.length()>1||choice.charAt(0)<'1'||choice.charAt(0)>'4')
			throw new MySecondException("You entered the wrong character");
		System.out.println("Enter two integers: ");
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		Methods method=new Methods();
		method.sum(num1, num2);
		method.extract(num1, num2);
		method.multiply(num1, num2);
		method.divide(num1, num2);
		scan.close();
	}
	static void menu() {
		System.out.println("Enter what action you would like to do?");
		System.out.println("1. To add numbers");
		System.out.println("2. To extract numbers");
		System.out.println("3. To multiply numbers");
		System.out.println("4. To divide numbers");
	}

}
