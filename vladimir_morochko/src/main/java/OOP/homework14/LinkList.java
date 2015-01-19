package OOP.homework14;


/**
 Создать параметризированный связанный список и реализовать РЕКУРСИВНЫЕ методы:
 1. Замена значения элемента по индексу, void setRec(int index, E element)
 2. Удаление элемента по индексу, E removeRec(int index)
 3. Поиск элемента по значению (сравнение через equals), int indexOfRec(E element)
 4. Поменять местами первый и последний элементы, void swapFirstLastRec()

Класс задания hw8.reclist.LinkList
 */

public class LinkList<E> {
	private int size;
	private Node<E> node;

	public LinkList() {

	}

	public LinkList(Node<E> node) {
		this();
		this.add(node);
	}
	
	public void add(Node<E> node) {
		Node<E> temp = this.node;
		this.node = node;
		node.next = temp;
		size++;
	}

	public void add(E value) {
		this.add(new Node<E>(value));
	}

	public void setRec(int index, E element) {
		if (index < size) {
			node.set(index, element);
		}
	}

	@SuppressWarnings("unchecked")
	public E removeRec(int index) {
		if (index < size) {
			size--;
			return node.remove(index);
		}
		return (E) new Object();
	}

	public int indexOfRec(E element) {
		return node.indexOf(element, 0);
	}

	public void swapFirstLastRec() {
		node.value = node.swapFirstLast(node.value);
	}
	
	@Override
	public String toString() {
		return "" + node;
	}
	
	public void print() {
		System.out.println(this);		
	}

	@SuppressWarnings("hiding")
	private class Node<E> {
		private E value;
		private Node<E> next;

		public Node() {

		}
		
		public Node(E value) {
			this();
			this.value = value;
		}		

		public int indexOf(E element, int counter) {
			if (!value.equals(element) && next != null) {
				return next.indexOf(element, ++counter);
			} else if (value.equals(element)) {
				return counter;
			} else {
				return -1;
			}
		}

		public E remove(int index) {
			if (index > 1) {
				return next.remove(--index);
			} else {
				E temp = next.value;
				next = next.getNext();
				return temp;
			}
		}

		public void set(int index, E value) {
			if (index > 0 && next != null) {
				next.set(--index, value);
			} else {
				this.value = value;
			}
		}

		public E swapFirstLast(E value) {
			if (next == null) {
				E temp = this.value;
				this.value = value;
				return temp;
			} else {
				return next.swapFirstLast(value);
			}
		}

		@Override
		public String toString() {
			if (next == null) {
				return "" + value;
			} else {
				return value + " -> " + next;
			}
		}

		@SuppressWarnings("unused")
		public E getValue() {
			return value;
		}

		@SuppressWarnings("unused")
		public void setValue(E value) {
			this.value = value;
		}

		public Node<E> getNext() {
			return next;
		}

		@SuppressWarnings("unused")
		public void setNext(Node<E> node) {
			this.next = node;
		}

	}
	
	public static void main(String[] args) {
		LinkList<Object> myList = new LinkList<Object>();
		
		for (int i = 0; i < 10; i++) {
			myList.add(i);
			if (i == 5) {
				myList.add("foo");
			}
		}
		myList.print();
		
		System.out.println("setRec(4, \"bar\")");
		myList.setRec(4, "bar");
		myList.print();
		
		System.out.println("removeRec(4)");
		myList.removeRec(4);
		myList.print();
		
		System.out.println("indexOfRec(2) : " + myList.indexOfRec(2));
		
		System.out.println("swapFirstLastRec()");
		myList.swapFirstLastRec();
		myList.print();
	}
	
}
