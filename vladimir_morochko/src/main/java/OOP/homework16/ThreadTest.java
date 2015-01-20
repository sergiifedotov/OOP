package OOP.homework16;

public class ThreadTest implements Runnable {
	private Thread thread;
	long count;
	String name;

	public ThreadTest() {
		this.thread = new Thread(this);
	}

	public ThreadTest(long count, String name) {
		this();
		this.count = count;
		this.name = name;
	}

	public void start() {
		thread.start();
	}

	@Override
	public void run() {
		long d1, d2;
		d1 = System.nanoTime();
		for (long i = 0; i < count; i++) {
			
		}
		d2 = System.nanoTime();
		System.out.println(name + " finished in " + (d2 - d1) / 1000 + " mics");
	}

	public static void main (String[] args) {
		ThreadTest th1 = new ThreadTest((long) 10e9, "th1");
		ThreadTest th2 = new ThreadTest((long) 10e9, "th2");
		
		th1.start();
		th2.start();
	}
	
}
