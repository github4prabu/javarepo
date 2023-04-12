package dedalus.view;

import java.io.*;
import java.util.Scanner;

import dedalus.controller.EmployeeController;
import dedalus.controller.EmployeeInterface;
import dedalus.exception.UserNotFoundException;

public class MyClass {

	// Class to accept user choices
	public static void acceptChoices() {

		EmployeeInterface ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String choice = null;

		do {
			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Serialise Patient");
			System.out.println("4. De-serialise Patient");
			System.out.println("5. Sort by ID");
			System.out.println("6. Sort by Name");
			System.out.println("7. Update Employee");
			System.out.println("8. Delete Employee");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				ec.addEmployee();
				break;
			}

			case 2: {
				ec.viewEmployee();
				break;
			}
			case 3: {
				ec.serializeEmployee();
				break;
			}
			case 4: {
				ec.deSerializeEmployee();
				break;
			}
			case 5: {
				ec.sortByEid();
				break;
			}
			case 6: {
				ec.sortByEname();
				break;
			}
			case 7: {
				ec.updateEmployee();
				break;
			}
			case 8: {
				ec.deleteEmployee();
				break;
			}
			default: {
				System.out.println("Enter right choice");
				break;
			}
			}
			System.out.println("Do u want to continue Y or y");
			choice = sc.next();

		} while (choice.equals("Y") || choice.equals("y"));
	
		System.out.println("Exited");
		//sc.close();
		System.exit(0);

	}

	public static void main(String[] args) throws UserNotFoundException {
		System.out.println("Welcome");

		EmployeeInterface ec1 = new EmployeeController();		
		if (ec1.validateLogin()) {
			acceptChoices();
		} 
		else {
			throw new UserNotFoundException("User not found!");
		}

	}
	
}