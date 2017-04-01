package ThreadTest;

/*
 * Daemon thread running in back-end services for other user thread, once all the user thread terminated, daemon thread will closed with JVM
 * eg: GC, thread pool's guardians thread.
 * 1.Before start() must setDaemon first
 * 2.new thread that generated from Daemon thread is daemon thread
 * 3.Daemon thread should not be used for IO write or read and logic calculation, eg below
 * **/

import java.util.Scanner;

class DaemonThreadClass implements Runnable{
	@Override
	public void run(){
		System.out.println("Start Daemon thread");
		int count = 0;
		while (count < 1000) {
			count ++;
			System.out.println(Thread.currentThread().getName() + " Count number: " + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class DaemonThread {

	public static void main(String[] args) {
		DaemonThreadClass daemon = new DaemonThreadClass();
		Thread td = new Thread(daemon, "Daemon thread");
		td.setDaemon(true);
		td.start();
		Scanner sc = new Scanner(System.in);
		sc.next();
	}

}
