package dedalus.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

import dedalus.modal.Employee;

//POJO = Plain Old Java Object
public class EmployeeController implements EmployeeInterface {

	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();

	public void addEmployee() {
		Scanner sc1 = new Scanner(System.in);
		emp = new Employee();

		System.out.println("Enter Eid");
		int eid = sc1.nextInt();
		emp.setEid(eid);

		System.out.println("Enter Ename");
		String ename = sc1.next();
		emp.setEname(ename);
		emplist.add(emp);
		System.out.println("Employee Added Succesfully");
		// sc1.close();
	}

	public void viewEmployee() {
		// System.out.println(emp);

		/*Iterator i = emplist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
*/
		emplist.forEach(lis->System.out.println(lis));
	}

	public void serializeEmployee() {
		try {
			Employee emp = new Employee(1012, "Pavithra");

			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(emp);
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		} catch (IOException ois) {
			System.out.println("Handled IO Exception");
		}

	}

	public void deSerializeEmployee() {
		try {
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Employee emp = (Employee) ois.readObject();
			System.out.println("DeSerilized from file dedalus.txt");
			System.out.println(emp.getEid());
			System.out.println(emp.getEname());
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		} catch (ClassNotFoundException cnf) {
			System.out.println("No Emp class");
		} catch (IOException ois) {
			System.out.println("Handled IO Exception");
		}
	}

	@Override
	public void sortByEid() {
		// TODO Auto-generated method stub
		// Collections.sort(emplist);
		System.out.println("After sorting by EID");
		System.out.println(emplist);
	}

	@Override
	public void sortByEname() {
		// TODO Auto-generated method stub
		Collections.sort(emplist, Employee.NameComparator);
		System.out.println(emplist);
	}

	@Override
	public boolean validateLogin() {
		String uname = null;
		String pwd = null;
		
		try {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter User Name:");
		uname = br.readLine();
		System.out.println("Enter Password:");
		pwd = br.readLine();

		/*
		 * if (uname.equals("test") && pwd.equals("pass")) {
		 * System.out.println("Welcome" + uname); acceptChoices(); } else { throw new
		 * UserNotFoundException("User "+uname+" not found");
		 */	
		
		// 	Using Predicate 
		BiPredicate<String, String> user = (n, p) -> n.equals("prabu");
		BiPredicate<String, String> pass = (n, p) -> p.equals("pass");

		return (user.and(pass).test(uname, pwd));
		}
		
		catch (Exception ex) {
		System.out.println("except"+ex);
		ex.printStackTrace();
		return false;
		}
	}
}