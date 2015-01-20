package OOP.homework12;


/**
 * Написать класс DoublyLinkList, реалзизующем двусвязанный список с классом элемента DNode.
 Для класса DoublyLinkList написать методы:

 1. Вывести элементы списка в обратном порядке, метод void printRevert()
 2. Добавление элемента в начало, метод void addFirst(int element)
 3. Добавление элемента в конец, метод void addLast(int element)
 4. Перестроить элементы в списке в обратном порядке, метод void revert()
 5. Частично упорядочить элементы списка, в случае если реализован интерфейс 
 Comparable, метод void sortPartial(int index)
 *
 */

public class DoublyLinkList {
	public static void main(String[] args) {
		DoublyLinkList myList = new DoublyLinkList();
		myList.addFirst(1);
		myList.addFirst(2);
		myList.addFirst(3);
		myList.addLast(0);
		System.out.print(myList.getHead().getValue());
		System.out.print(myList.getHead().getNext().getValue());
		System.out.print(myList.getHead().getNext().getNext().getValue());
		System.out.println();
		
		System.out.print(myList.getElement(2));
		System.out.println();
		
		myList.print();
		myList.sortPartial(2);
		myList.print();
		myList.printRevert();
		myList.revert();
		myList.print();
		myList.printRevert();
		
	}
	
	private int size;
	private DNode head;
	private DNode tail;
	
	public void addFirst(int value) {
		if (head == null) {
			head = new DNode(null, null);
			tail = head;
		} else {
			DNode newHead = new DNode(head, null);
			head.setPrevious(newHead);
			head = newHead;
		}
		head.setValue(value);
		size++;
	}
	
	public void addLast(int value) {
		if (tail == null) {
			tail = new DNode(null, null);
			head = tail;
		} else {
			DNode newTail = new DNode(null, tail);
			tail.setNext(newTail);
			tail = newTail;
		}
		tail.setValue(value);
		size++;
	}
	
	public DNode getElement(int index) {
		if (head == null && index > size) {
			return null;
		} else {
			DNode currentNode = head;
			int counter = index;
			while (counter > 0) {
				currentNode = currentNode.getNext();
				counter--;
			}
			return currentNode;
		}
	}
	
	public void print() {
		DNode currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode);
			currentNode = currentNode.getNext();
			if (currentNode != null) {
				System.out.print(" -> ");
			}
		}		
		System.out.println();
	}
	
	public void printRevert() {
		DNode currentNode = tail;
		while (currentNode != null) {
			System.out.print(currentNode);
			currentNode = currentNode.getPrevious();
			if (currentNode != null) {
				System.out.print(" -> ");
			}
		}		
		System.out.println();
	}
	
	public void revert() {
		if (size > 0) {
			DNode currentNode = head;
			DNode temp = tail;
			tail = head;
			head = temp;
			while (currentNode != null) {
				temp = currentNode.getNext();
				currentNode.setNext(currentNode.getPrevious());
				currentNode.setPrevious(temp);
				currentNode = temp;
			}
		}
	}
	
	public void sortPartial(int index) {
		DNode sortBase = getElement(index);
		for (int i = 0; i < size; i++) {
			int firstSwapIndex = 0;
			while (getElement(firstSwapIndex).compareTo(sortBase) < 0
					&& firstSwapIndex < size) {
				firstSwapIndex++;
			}
			int lastSwapIndex = size - 1;
			while (getElement(lastSwapIndex).compareTo(sortBase) > 0
					&& lastSwapIndex > 0) {
				lastSwapIndex--;
			}
			swap(getElement(firstSwapIndex), getElement(lastSwapIndex));
		}
	}

	private void swap(DNode dnode1, DNode dnode2) {
		int temp = dnode1.getValue();
		dnode1.setValue(dnode2.getValue());
		dnode2.setValue(temp);
	}


	public int size() {
		return getSize();
	}
	
	public DNode getHead() {
		return head;
	}

	public void setHead(DNode head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public DNode getTail() {
		return tail;
	}

	public void setTail(DNode tail) {
		this.tail = tail;
	}


	private class DNode implements Comparable<DNode>{
		private int value;
		private DNode next;
		private DNode previous;
		
		public DNode() {

		}
		
		public DNode(DNode next, DNode previous) {
			this();
			setNext(next);
			setPrevious(previous);
		}
		
		@Override
		public String toString () {
			return "" + value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public DNode getNext() {
			return next;
		}

		public void setNext(DNode next) {
			this.next = next;
		}

		public DNode getPrevious() {
			return previous;
		}

		public void setPrevious(DNode previous) {
			this.previous = previous;
		}

		@Override
		public int compareTo(DNode dnode) {
			return value - dnode.getValue();
		}
	}
}
