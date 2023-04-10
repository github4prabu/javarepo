package dedalus.exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class MyMainClass
{
	public static void main(String[] args)
	{
		try{
		String uname=null;
		String pwd = null;
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter Username:");
		uname=br.readLine();
		System.out.println("Enter password:");
		pwd= br.readLine();

		if(uname.equals("deeps") && pwd.equals("pass"))
		{
			System.out.println("Welcome " + uname);
		}
		else
		{
			throw new UserNotFoundException();
		}
		}
		catch(Exception unf)
		{
			System.out.println(unf);
		}
	}
	
}
