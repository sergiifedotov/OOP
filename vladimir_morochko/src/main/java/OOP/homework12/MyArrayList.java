package OOP.homework12;

/**
 * Написать собственную реализацию динамического массива MyArrayList.
 * Сделать параметризированную релизацию списка, параметр E.
 * Реализовать следующие методы
 - void add(E value)
 - int get(int index)
 - boolean set(int index, E value)
 - boolean add(int index, E value)
 - int indexOf(E value)
 - int size()
 - E remove(int index)
 */

public class MyArrayList<E> {
	private E [] MyArray;

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		MyArray = (E[]) new Object[0];
	}
	
	public MyArrayList(E[] myArray) {
		this.MyArray = myArray;
	}

	public void add(E value) {
		@SuppressWarnings("unchecked")
		E[] myNewArray = (E[]) new Object[MyArray.length + 1];
		for (int i = 0; i < MyArray.length; i++) {
			myNewArray[i] = MyArray[i];
		}
		myNewArray[MyArray.length] = value;
		MyArray = myNewArray;
	}

	public E get(int index) {
		return MyArray[index];
	}

	public boolean set(int index, E value) {
		boolean answer = false;
		if (index >= 0 && index < MyArray.length) {
			MyArray[index] = value;
			answer = true;
		}
		return answer;
	}

	public boolean add(int index, E value) {
		boolean answer = false;
		if (index >= 0 && index < MyArray.length) {
			@SuppressWarnings("unchecked")
			E[] myNewArray = (E[]) new Object[MyArray.length + 1];
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

	public int indexOf(E value) {
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
		
	public void print() {
		System.out.println(this);
	}
	
	public E remove(int index) {
		E answer = null;
		if (index >= 0 && index < MyArray.length) {
			answer = MyArray[index];
			@SuppressWarnings("unchecked")
			E[] myNewArray = (E[]) new Object[MyArray.length - 1];
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
		for (Object current : MyArray) {
			outString += (current + " ");
		}
		return outString;
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
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

