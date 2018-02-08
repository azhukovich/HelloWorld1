package first;

import java.util.Random;

public class Counter implements Runnable {

	public int id = 0;
	public static int c = 0;

	public Counter() {
		
	}
	
	public Counter(int n) {
		id = n;
	}

	public void run() {
		//System.out.println("Thread:" + id);
		inc();
		dec();
	}

	public synchronized void inc() {
		for (int i = 0; i < 10; i++) {
			++c;
			System.out.println("Thread:" + id + ":");
			System.out.println(c);
			try {
				Thread.sleep((int)Math.random()*500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void dec() {
		for (int i = 0; i < 10; i++) {
			c--;
			System.out.println("Thread:" + id + ":");
			System.out.println(c);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public synchronized int get() {
		return c;
	}
}
