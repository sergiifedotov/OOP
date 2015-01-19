package OOP.lesson11;

/**
 * Создать класс "связный список", реализовать три метода: 
 * void add(int) добавление элемента в конец списка
 * int size() возвращает элемент списка
 * void print() выводит список в виде 1 -> 2 -> 3
 */

public class LinkList {
	public static void main(String[] args) {
		LinkList myList = new LinkList();
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
		
	}
	
	private int size;
	private Node node;
	
	public LinkList() {
		setNode(null);
		setSize(0);
	}
	
	public LinkList(Node node) {
		this.setNode(node);
		setSize(1);
	}
	
	public void add(int value) {
		setNode(new Node(getNode()));
		getNode().setValue(value);
		setSize(getSize() + 1);
	}
	
	public void print() {
		if (getNode() != null) {
			getNode().print();
		}
	}
	
	public int getElement(int number) {
		if (getNode() != null) {
			return getNode().getElement(number);
		}
		return 0;
	}
	
	public int size() {
		return getSize();
	}
	
	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}



	private class Node {
		private int value;
		private Node next;
		
		public Node(Node node) {
			this.setNode(node);
		}
		
		public int getElement(int number) {
			if (number > 0 && next != null) {
				number--;
				return next.getElement(number);
			} else {
				return getValue();
			}
		}

		public void print() {
			System.out.print(getValue());
			if (next != null) {
				System.out.print(" -> ");
				next.print();
			}
			System.out.println();
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNode() {
			return next;
		}

		public void setNode(Node node) {
			this.next = node;
		}
		
	}

}
