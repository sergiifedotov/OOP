package OOP.lesson15;

public class ThreadDemo2 {

	class MyClass implements Runnable {
		private Thread thread;
		int count;
		String name;

		public MyClass() {
			count = 30;
			this.thread = new Thread(this);
		}

		public MyClass(int count, String name) {
			this();
			this.count = count;
			this.name = name;
		}
		
		public void start() {
			thread.start();
		}
		
		@SuppressWarnings("deprecation")
		public void stop() {
			thread.stop(); // или interrupt
		}


		@Override
		public void run() {
			for (int i = 0; i < count; i++) {
				System.out.println(name + " " + i);
			}
		}
	}

	public static void main(String[] args) {
		MyClass th1 = new ThreadDemo2().new MyClass(20, "th1");
		MyClass th2 = new ThreadDemo2().new MyClass(30, "\tth2");
		MyClass th3 = new ThreadDemo2().new MyClass(40, "\t\tth3");

		th1.start();
		th2.start();
		th3.start();
	}

}
