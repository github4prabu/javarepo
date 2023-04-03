package dedalus.try1;

import java.util.Scanner;

public class TrySwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		// get operation choice
		System.out.println("Give math operation choice");
		System.out.println("1 for Add");
		System.out.println("2 for Subtract");
		int choice = scanner.nextInt();

		// get numbers

		MathClass math = new MathClass();

		// switch add or delete
		switch (choice) {

		// do add
		case 1: {
			System.out.println("Enter number1 to add");
			int num1 = scanner.nextInt();

			System.out.println("Enter number2 to add");
			int num2 = scanner.nextInt();

			int result = math.doAdd(num1, num2);
			System.out.println(result);
			break;
		}
		// do delete
		case 2: {
			System.out.println("Enter number to delete from");
			int firstnum = scanner.nextInt();
			System.out.println("Enter number to delete");
			int secondnum = scanner.nextInt();

			int result = math.doSub(firstnum, secondnum);
			System.out.println(result);
			break;
		}
		default: {
			System.out.println("Enter either 1 or 2 only!");
			break;
		}

		} // switch

		scanner.close();
	} // main

}
