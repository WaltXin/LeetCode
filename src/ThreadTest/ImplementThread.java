package ThreadTest;

/*
 * Advantage of using implements Runnable:
 * 1. Java doesn't supp multiple inheritance, if you class already extends an object, you can't exted Thread
 * 2. By implementing Runnable, multiple threads can share an instance of your work, if you extends Thread, 
 * you have to create new instance of your work for each thread.
 * 3. Extend method will cause all methods in Thread will be inheriting to your class that you may not need, waste resources
 * 4. Implement makes code loosely coupled and improves re-usability
 * **/


class TestImplementThread implements Runnable{

	private int ticketNum = 5;

	@Override
	public void run() {
		while (ticketNum > 0) {
			System.out.println( Thread.currentThread().getName() + " Ticket Num: " + ticketNum--);		
		}
	}
}

public class ImplementThread {
	public static void main(String[] args) {
		TestImplementThread thread = new TestImplementThread();
		Thread td = new Thread(thread,"UnionFind");
		td.start();
		Thread td2 = new Thread(thread, "T2");
		td2.start();
		Thread td3 = new Thread(thread, "T3");
		td3.start();	
	}
}
