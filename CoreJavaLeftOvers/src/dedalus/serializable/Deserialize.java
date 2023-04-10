package dedalus.serializable;

import java.io.*;
import dedalus.exception.*;
import dedalus.modal.Patient;

public class Deserialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		FileInputStream fis = new FileInputStream("patient.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Patient pat = (Patient)ois.readObject();
		System.out.println("DeSerilized from file patient.txt");
		System.out.println(pat.getPatientid());
		System.out.println(pat.getPatientname());
		ois.close();
		fis.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("No file");
		}
		catch(ClassNotFoundException cnf) {
			System.out.println("No Emp class");
		}
		catch (IOException ois) {
			System.out.println("Handled IO Exception");
		}
	}
}
