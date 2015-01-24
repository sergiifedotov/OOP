package OOP.lesson11;

/**
 * Написать параметризованный связный список
 * 
 * Написать метод <T>max(), который возвращает максимальное значение в списке
 *
 */

public class ParamLinkList<T extends Comparable<T>>{ // т.е. только для сравнимых типов
	public static void main(String[] args) {
		ParamLinkList<Integer> myList = new ParamLinkList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		System.out.print(myList.getNode().getValue());
		System.out.print(myList.getNode().getNode().getValue());
		System.out.print(myList.getNode().getNode().getNode().getValue());
		System.out.println();
		
		System.out.print(myList.getElement(2));
		System.out.println();
		
		myList.print();
		
		System.out.println(myList.max());
	}
	
	private int size;
	private Node<T> node;
		
	public ParamLinkList() {
		setNode(null);
		setSize(0);
	}
	
	public ParamLinkList(Node<T> node) {
		this.setNode(node);
		setSize(1);
	}
	
	public T max() {
		return getNode().max();
	}
	
	
	public void add(T value) {
		setNode(new Node<T>(getNode()));
		getNode().setValue(value);
		size++;
	}
	
	public void print() {
		if (!(getNode() == null)) {
			getNode().print();
		}
	}
	
	public T getElement(int number) {
		if (!(getNode() == null)) {
			return getNode().getElement(number);
		}
		return null;
	}
	
	public int size() {
		return getSize();
	}
	
	public Node<T> getNode() {
		return node;
	}

	public void setNode(Node<T> node) {
		this.node = node;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}



	@SuppressWarnings("hiding")
	private class Node<T extends Comparable<T>> {
				
		private T value;
		private Node<T> next;
		
		public Node(Node<T> node) {
			this.setNode(node);
		}
		
		public T getElement(int number) {
			if (number > 0 && next != null) {
				number--;
				return next.getElement(number);
			} else {
				return getValue();
			}
		}

		public T max() {
			T max = value;
			if(next != null) {
				T nextValue = next.max();
				if (nextValue.compareTo(max) > 0) {
					max = nextValue;
				}
			}
			return max;
		}

		public void print() {
			System.out.print(getValue());
			if (next != null) {
				System.out.print(" -> ");
				next.print();
			}
			System.out.println();
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNode() {
			return next;
		}

		public void setNode(Node<T> node) {
			this.next = node;
		}

	}

}
