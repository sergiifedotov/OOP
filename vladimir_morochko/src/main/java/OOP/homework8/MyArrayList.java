package OOP.homework8;

/**
 * Написать собственную реализацию динамического массива MyArrayList, 
 * содержащего целые числа. Реализовать следующие методы
 * - void add(int value)
 * - int get(int index)
 * - boolean set(int index, int value)
 * - boolean add(int index, int value)
 * - int indexOf(int value)
 * - int size()
 * - boolean remove(int index)
 */

public class MyArrayList {
	private int[] MyArray;

	public MyArrayList() {
		MyArray = new int[0];
	}
	
	public MyArrayList(int[] myArray) {
		this.MyArray = myArray;
	}

	public void add(int value) {
		int[] myNewArray = new int[MyArray.length + 1];
		for (int i = 0; i < MyArray.length; i++) {
			myNewArray[i] = MyArray[i];
		}
		myNewArray[MyArray.length] = value;
		MyArray = myNewArray;
	}

	public int get(int index) {
		return MyArray[index];
	}

	public boolean set(int index, int value) {
		boolean answer = false;
		if (index >= 0 && index < MyArray.length) {
			MyArray[index] = value;
			answer = true;
		}
		return answer;
	}

	public boolean add(int index, int value) {
		boolean answer = false;
		if (index >= 0 && index < MyArray.length) {
			int[] myNewArray = new int[MyArray.length + 1];
			for (int i = 0; i < index; i++) {
				myNewArray[i] = MyArray[i];
			}
			myNewArray[index] = value;

			for (int i = index; i < MyArray.length; i++) {
				myNewArray[i + 1] = MyArray[i];
			}
			MyArray = myNewArray;
			answer = true;
		}
		return answer;
	}

	public int indexOf(int value) {
		int answer = 0;
		for (int i = 0; i < MyArray.length; i++) {
			if (MyArray[i] == value) {
				answer = i;
				break;
			}
		}
		return answer;
	}

	public int size() {
		return MyArray.length;
	}
	
	public int min() {
		int min = MyArray[0];
		for(int current : MyArray) {
			if (current < min) {
				min = current;
			}
		}
		return min;
	}

	public int max() {
		int max = MyArray[0];
		for(int current : MyArray) {
			if (current > max) {
				max = current;
			}
		}
		return max;
	}
	
	public void fillRandom(int min, int max) {
		for(int i = 0; i < MyArray.length; i++) {
			MyArray[i] = (int)(min + Math.random() * (max - min));
		}
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	public int remove(int index) {
		int answer = 0;
		if (index >= 0 && index < MyArray.length) {
			answer = MyArray[index];
			int[] myNewArray = new int[MyArray.length - 1];
			for (int i = 0; i < index; i++) {
				myNewArray[i] = MyArray[i];
			}
			for (int i = index; i < MyArray.length - 1; i++) {
				myNewArray[i] = MyArray[i + 1];
			}
			MyArray = myNewArray;
		}
		return answer;
	}

	@Override
	public String toString() {
		String outString = "";
		for (int current : MyArray) {
			outString += (current + " ");
		}
		return outString;
	}

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(new int[] { 1, 2, 3 });
		list.print();
		list.add(4);
		list.print();
		list.add(3, 5);
		list.print();
		list.set(1, 7);
		list.print();
		
		System.out.println(list.get(3));
		System.out.println(list.indexOf(5));
		System.out.println(list.size());
		
		list.remove(3);
		list.print();
		System.out.println(list.size());
				
	}
}

