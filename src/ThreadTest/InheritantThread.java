package ThreadTest;

class TestInheritanceThread extends Thread{

	String name;
	int ticketNum = 5;
	
	public TestInheritanceThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run(){
		while (ticketNum > 0) {
			System.out.println(name + " ticket Num: " + ticketNum--);
		}
	}
}

public class InheritantThread{
	public static void main(String[] args) {
		TestInheritanceThread thread1 = new TestInheritanceThread("Thread1");
		TestInheritanceThread thread2 = new TestInheritanceThread("Thread2");
		thread1.start();
		thread2.start();
	}
}

