package OOP.homework12;

public class Test1 {
	public static void main(String[] args) {

		for (long j = 0; j < 10e6; j += 1e4) {
			System.out.println(j + " " + new Test1().test(j));
		}
		
		
	}
	MyInt myint = new MyInt(3);
	
	public long test(long count) {
		long d1, d2;
		// MyInt myint = new MyInt(3);
		d1 = System.currentTimeMillis();
		for (long i = 0; i < count; i++) {
		}
		d2 = System.currentTimeMillis();
		return (d2 - d1);
		
	}
	
	class MyInt {
		private int myInt;
		
		public MyInt (int value) {
			myInt = value;
		}

		public int getMyInt() {
			return myInt;
		}

		public void setMyInt(int myInt) {
			this.myInt = myInt;
		}
	}
}
