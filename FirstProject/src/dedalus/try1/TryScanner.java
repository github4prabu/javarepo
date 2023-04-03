package dedalus.try1;

import java.util.Scanner;

public class TryScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "My Sample";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word");
		str = scanner.next();
		
		StringFormatter formatter = new StringFormatter();
		String revstr = formatter.reverseString(str);
		System.out.println(revstr);
		
		scanner.close();
	}

}
