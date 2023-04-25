package dedalus.javainternals;

public class ReflectionTry {

	public static void main(String[] args) {

		Employee emp = new Employee();
		Class c = emp.getClass();
		System.out.println(c.getName());
		
		Employee emp2 = new Employee();
		Class c2 = emp2.getClass();
		
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		
		System.out.println(emp.hashCode());
		System.out.println(emp2.hashCode());		
		
	}

}
