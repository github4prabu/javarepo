package dedalus.serializable;

import java.io.*;

import dedalus.modal.Patient;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Patient pat = new Patient(9999, "Super Man...");

			FileOutputStream fos = new FileOutputStream("patient.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(pat);
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		} catch (IOException ois) {
			System.out.println("Handled IO Exception");
		}
	}
}
