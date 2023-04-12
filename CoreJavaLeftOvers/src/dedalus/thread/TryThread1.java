package dedalus.thread;

import java.lang.Object;

class MyThreadA extends Thread {

	public void run() {
		System.out.println("Thread Method started");

		try {
			
			VolatileCounter vc = new VolatileCounter();
			
			System.out.println("counter = "+ vc.getCounter());

			/*			for (int i = 1; i <= 5; i++) {
				//Thread.sleep(1000);
				System.out.println("i = " + i);
			}
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread Method ended");
	}
}

public class TryThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main started");
		MyThreadA mta = new MyThreadA();
		mta.start();
		System.out.println("Main ended");
	}

}
