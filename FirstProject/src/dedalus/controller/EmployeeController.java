package dedalus.controller;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

import dedalus.dao.EmployeeDao;
import dedalus.dao.EmployeeDaoImplemention;
import dedalus.modal.Employee;

//POJO = Plain Old Java Object
public class EmployeeController implements EmployeeInterface {

	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();
	EmployeeDao dao = new EmployeeDaoImplemention();
	
	public void addEmployee() {
		Scanner sc1 = new Scanner(System.in);
		emp = new Employee();

		System.out.println("Enter Emp ID");
		int eid = sc1.nextInt();
		emp.setEmpno(eid);

		System.out.println("Enter Emp Name");
		String ename = sc1.next();
		emp.setEname(ename);
				
		System.out.println("Enter Job");
		String job = sc1.next();
		emp.setJob(job);
		
/*		System.out.println("Enter Manager ID");
		float mgr = sc1.nextFloat();
		emp.setMgr(mgr);
		
		System.out.println("Enter Hire Date");
		String hiredate = sc1.next();
		emp.setHiredate(hiredate);
		
		System.out.println("Enter Comm");
		float comm = sc1.nextFloat();
		emp.setComm(comm);

		System.out.println("Enter Dept ID");
		float depno = sc1.nextFloat();
		emp.setDepno(depno);
*/
		// add to employee list
		emplist.add(emp);
		//System.out.println("Employee Added Succesfully");
	    //sc1.close();
		
		// call db call to insert into emp table
		dao.insertEmployee(emp);
		System.out.println("Employee Inserted to DB Succesfully");
		
	}

	public void viewEmployee() {
		// System.out.println(emp);

		/*Iterator i = emplist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
*/
		// Using lamda
		//emplist.forEach(lis->System.out.println(lis));
		
		dao.showEmployee();
	}
	
	public void updateEmployee() {
		Scanner sc2 = new Scanner(System.in);
		emp = new Employee();

		System.out.println("Enter Emp ID");
		int eid = sc2.nextInt();
		emp.setEmpno(eid);

		System.out.println("Enter Emp Name");
		String ename = sc2.next();
		emp.setEname(ename);
				
		System.out.println("Enter Job");
		String job = sc2.next();
		emp.setJob(job);
		
		dao.updateEmployee(emp);
	}

	public void deleteEmployee() {
		Scanner sc3 = new Scanner(System.in);
		emp = new Employee();

		System.out.println("Enter Emp ID");
		int eid = sc3.nextInt();
		emp.setEmpno(eid);

		dao.deleteEmployee(emp.getEmpno());
	}

	public void serializeEmployee() {
		try {
			//Employee emp = new Employee (1012, "Pavithra", "CLERK", 30, "12/01/2023", 4000, 300, 10);
			Employee emp = new Employee ();
			
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
			System.out.println(emp.getEmpno());
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