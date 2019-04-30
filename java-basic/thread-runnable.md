# Thread/Runnable

```java
class MyThread extends Thread {
    String name;
    MyThread(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print("thread start: " + name + " i");
        }
    }
}

class MyRunnable implements Runnable {
    String name;
    MyRunnable(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print("thread start: " + name + " i");
        }
    }
}

class Demo {
    MyThread t1 = new MyThread("A");
    MyThread t2 = new MyThread("B");
    MyThread t3 = new MyThread("C");
    t1.start();
    t2.start();
    t3.start();
    
    //Class implements runnable needs to get concreate thread to start
    MyRunnable r1 = new MyRunnable("A");
    MyRunnable r2 = new MyRunnable("B");
    MyRunnable r3 = new MyRunnable("C");
    Thread t11 = new Thread(r1);
    Thread t22 = new Thread(r2);
    Thread t33 = new Thread(r3);
    t11.start();
    t22.start();
    t33.start();
}
```

