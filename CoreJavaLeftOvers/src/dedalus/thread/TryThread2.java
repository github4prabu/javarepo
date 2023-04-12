package dedalus.thread;

import java.lang.Object;

class MyThread1{
	
	public  void doPrint1_5() {
		System.out.println("Method started");
		synchronized(this) {
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(1000);
				System.out.println("i = " + i);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		}
		System.out.println("Method ended");
	}
}	

class MyThread2 extends Thread {
	
	MyThread1 mt1;

	public MyThread2(MyThread1 mt1) {
		this.mt1 =mt1;
	}

	public void run() {
		mt1.doPrint1_5();
	}
}

public class TryThread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main started");
		MyThread1 mt1 = new MyThread1();
	

		MyThread2 mt2a = new MyThread2(mt1);
		MyThread2 mt2b = new MyThread2(mt1);
		mt2a.start();
		mt2b.start();
		System.out.println("Main ended");
	}

}
