package dedalus.controller;

import java.util.Scanner;

import dedalus.modal.Employee;

//POJO = Plain Old Java Object
public class EmployeeController {
		Employee emp = new Employee();

		public void addEmployee() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Eid");
			int eid = sc.nextInt();
			emp.setEid(eid);

			System.out.println("Enter Ename");
			String ename = sc.next();
			emp.setEname(ename);
		}

		public void viewEmployee() {
			System.out.println(emp);
		}
}
