package OOP.homework12;


/**
 * Написать класс LinkList, содержащий элементы типа int, 
 * реалзизующем связанный список с классом элемента Node.
 * Для класса LinkList написать методы:
 *  1. Замена значения элемента по индексу, метод void set(int index, int element)
 *  2. Удаление элемента по индексу, метод void remove(int index)
 *  3. Поиск элемента по значению, метод int indexOf(int element)
 *  4. Поменять местами первый и последний элементы, метод void swapFirstLast()
 *  5. Перестроить элементы в списке в обратном порядке, метод void revert()
 *  6. Поменять местами наибольший и наименьший элементы, в случае если 
 *     реализован интерфейс Comparable, метод void swapMaxMin()
 *  7. Частично упорядочить элементы списка, в случае если 
 *     реализован интерфейс Comparable, метод void sortPartial(int index)
 *  8. Сравнение двух списков, метод boolean equals(LinkList list)
 *  9. Сложение двух списков, метод LinkList concat(LinkList list)
 *  10*. Отсортировать список, в случае если реализован 
 *       интерфейс Comparable, метод void sort()
 11*. Удалить повторяющиеся элементы из списка, в случае если 
 *    реализован интерфейс Comparable, метод boolean removeDuplicates()
 *
 */

public class LinkList {
	public static void main(String[] args) {
		LinkList myList = new LinkList();
		
		for (int i = 0; i < 10; i++) {
			myList.add(i);
		}
//		myList.add(1);
//		LinkList myList2 = new LinkList();
//		
//		for (int i = 0; i < 10; i++) {
//			myList2.add(i);
//		}
//		myList2.add(2);
//		System.out.println(myList.equals(myList2));
		
//		System.out.print(myList.getNode().getValue());
//		System.out.print(myList.getNode().getNext().getValue());
//		System.out.print(myList.getNode().getNext().getNext().getValue());
//		System.out.println();
//		myList.print();
//		System.out.println(myList.getElement(2));
//		
//		myList.set(1, 6);
//		myList.print();
//		
//		myList.remove(2);
//		System.out.println(myList.indexOf(1));
//		System.out.println(myList.indexOf(33));
//		myList.print();
//		
//		myList.swapFirstLast();
//		myList.print();
//		
//		myList.sortPartial(6);
//		myList.print();
//		
//		myList.revert();
//		myList.print();
//		
//		myList.swapMaxMin();
//		myList.print();
//		
//		myList.sort();
		
//		System.out.println(myList.indexOf(myList.getElement(4)));
		
//		myList.revert();
//		myList.add(9);
//		myList.print();
//		myList.removeDuplicates();
		myList.print();
		
	}
	
	private int size;
	private Node node;
	
	public LinkList() {

	}
	
	public LinkList(Node node) {
		this();
		this.add(node);
	}

	public LinkList(LinkList list) {
		this();
		Node currentNode = list.getNode();
		while (currentNode.getNext() != null) {
			this.add(currentNode);
			currentNode = currentNode.getNext();
		}
	}
	
	public void add(int value) {
		node = new Node(node);
		node.setValue(value);
		size++;
	}
	
	public void add(Node node) {
		node = new Node(node);
		size++;
	}
	
	public void remove(int index) {
		if (index < size) {
			node.remove(index);
			size--;
		}
	}
	
	public int indexOf(int element) {
		return node.indexOf(element, 0);
	}
	
	public int indexOf(Node node) {
		int counter = 0;
		Node currentNode = this.node;
		while (currentNode != null) {
			if (currentNode.compareTo(node) == 0) {
				return counter;
			}
			currentNode = currentNode.getNext();
			counter++;
		}
		return -1;
	}
	
	public void swapMaxMin() {
		Node currentNode = node;
		Node minNode = currentNode;
		Node maxNode = currentNode;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			minNode = currentNode.compareTo(minNode) < 0 ? currentNode : minNode;
			maxNode = currentNode.compareTo(maxNode) > 0 ? currentNode : maxNode;
		}
		swap(minNode, maxNode);
	}
	
	public void sortPartial(int index) {
		Node sortBase = node.getElement(index);
		for (int i = 0; i < size; i++) {
			int firstSwapIndex = 0;
			while (node.getElement(firstSwapIndex).compareTo(sortBase) < 0 
					&& firstSwapIndex < size) {
				firstSwapIndex++;
			}
			int lastSwapIndex = size - 1;
			while (node.getElement(lastSwapIndex).compareTo(sortBase) > 0 
					&& lastSwapIndex > 0) {
				lastSwapIndex--;
			}
			swap(node.getElement(firstSwapIndex), node.getElement(lastSwapIndex));
		}

	}
	
	public boolean equals(LinkList list) {
		boolean answer = true;
		if (size != list.getSize()) {
			answer = false;
		} else {
			Node currentNode = node;
			Node currentOtherNode = list.getNode();
			while (answer && currentNode.getNext() != null) {
				answer = currentNode.compareTo(currentOtherNode) == 0;
				currentNode = currentNode.getNext();
				currentOtherNode = currentOtherNode.getNext();
			}
		}
		return answer;
	}
	
	public LinkList concat(LinkList list) {
		LinkList concatList = new LinkList(this);
		Node currentNode = list.getNode();
		while (currentNode != null) {
			concatList.add(currentNode);
			currentNode = currentNode.getNext();
		}
		return concatList;
	}
	
	public void sort() {
		for (int step = size / 2; step > 0; step /= 2) {
			for (int i = 0; i < size - step; i++) {
				int j = i;
				while (j >= 0 
						&& node.getElement(j).compareTo(node.getElement(j + step)) > 0) {
					swap(node.getElement(j), node.getElement(j + step));
					j--;
				}
			}
		}

	}
	
	public boolean removeDuplicates() {
		boolean duplicatesRemoved = false;
		Node currentNode = node;
		int currentNodeIndex = 0;
		while (currentNode.getNext() != null) {
			Node duplicateNode = currentNode;
			int duplicateNodeIndex = currentNodeIndex;
			while (duplicateNode.getNext() != null) {
				duplicateNode = duplicateNode.getNext();
				duplicateNodeIndex++;
				if (currentNode.compareTo(duplicateNode) == 0) {
					remove(duplicateNodeIndex);
					duplicatesRemoved = true;
				}
			}
			currentNode = currentNode.getNext();
			currentNodeIndex++;
		}
		return duplicatesRemoved;
	}
	
	public void print() {
		System.out.println(node);		
	}
	
	public Node getElement(int index) {
		if (index < size) {
			return node.getElement(index);
		} else {
			return null;
		}
	}
	
	public void set(int index, int element) {
		if (index < size) {
			node.set(index, element);
		}
	}
	
	public void swapFirstLast() {
		int firstNumber = 0;
		int lastNumber = size - 1;
		swap(getElement(firstNumber), getElement(lastNumber));
	}
	
	private void swap(Node node1, Node node2) {
		int temp = node1.getValue();
		node1.setValue(node2.getValue());
		node2.setValue(temp);
	}
	
	public void revert() {
		if (size > 0) {
			node = node.revert(null);
		}
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



	private class Node implements Comparable<Node>{
		private int value;
		private Node next;
		
		public Node() {
			
		}
		
		public Node(Node node) {
			this();
			this.setNext(node);
		}
		
		public Node revert(Node node) {	
			Node temp = next;
			next = node;
			if (temp != null) {
				return temp.revert(this);
			} else {
				return this;
			}
		}

		public int indexOf(int element, int counter) {
			if (value != element && next != null) {
				return next.indexOf(element, ++counter);
			} else if (value == element){
				return counter;
			} else {
				return -1;
			}
		}
		
		public void remove(int index) {
			if (index > 1 && next != null) {
				next.remove(--index);
			} else {
				next = next.getNext();
			}
		}

		public void set(int index, int element) {
			if (index > 0 && next != null) {
				next.set(--index, element);
			} else {
				setValue(element);
			}
		}

		public Node getElement(int index) {
			if (index > 0 && next != null) {
				return next.getElement(--index);
			} else {
				return this;
			}
		}

		@SuppressWarnings("unused")
		public void print() {
			System.out.print(value);
			if (next != null) {
				System.out.print(" -> ");
				next.print();
			}
		}
		
		@Override
		public String toString() {
			return (value + " -> " + next);
		}

		
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node node) {
			this.next = node;
		}

		@Override
		public int compareTo(Node node) {
			return this.value - node.getValue();
		}
		
	}

}
