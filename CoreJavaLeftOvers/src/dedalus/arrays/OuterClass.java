package dedalus.arrays;

public class OuterClass {

	static int i =10;
	public void method()
	{
		System.out.println("i == " + i);
	}
	
	static class InnerClass
	{
		public void display()
		{
			System.out.println("i == " + ++i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//OuterClass.InnerClass oi = new OuterClass.InnerClass();
		//oi.display();
		
		OuterClass oc = new OuterClass();
		oc.method();
		
		InnerClass ic = new OuterClass.InnerClass();
		ic.display();
	}
}


//Check whether the inner class can be abstract => YES
//can it be inherited? => YES
//scope of instance variable within the inner class 
//scope of local variable within the inner class
