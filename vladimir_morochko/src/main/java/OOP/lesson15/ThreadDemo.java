package OOP.lesson15;

/**
 * Создать три потока, каждый из которых будет выводить 
 * числа в заданном диапазоне и свое имя.
 *
 */

public class ThreadDemo {
	class MyThread extends Thread {
		int count;
		
		public MyThread () {
			count = 30;
		}
		
		public MyThread (int count) {
			this();
			this.count = count;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < count; i++) {
				System.out.println(getName() + " " + i);
			}
		}
	}
	
	public static void main(String[] args) {
		MyThread th1 = new ThreadDemo().new MyThread(20);
		MyThread th2 = new ThreadDemo().new MyThread();
		MyThread th3 = new ThreadDemo().new MyThread(40);
		
		th1.start();
		th2.start();
		th3.start();
	}
}
