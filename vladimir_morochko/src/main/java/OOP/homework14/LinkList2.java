package OOP.homework14;

public class LinkList2<E> {
	private int size;
	private Node<E> tail;
	
	public LinkList2(){}
	
	public void addTail(E value) {
		Node<E> node = new Node<E>(value);
		node.setNext(tail);
		tail=node;
		size++;
	}
	
	public void addHead(E value) {
		tail.addHead(value);
		size++;	
	}
	
	@Override
	public String toString() {
		return "" + tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public Node<E> getTail() {
		return tail;
	}
	
	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	@SuppressWarnings("hiding")
	private class Node<E> implements Comparable<Node<E>> {
		private E value;
		private Node<E> next;
		
		public Node (){}
		
		public Node(E value) {
			this();
			this.value = value;
		}
		
		@SuppressWarnings("unused")
		public Node(E value, Node<E> next) {
			this();
			this.value = value;
			this.next = next;
		}

		
		public void addHead(E value) {
			if(next == null) {
				next = new Node<E>(value);
			} else {
			next.addHead(value);
			}
						
		}
		
		
		@Override
		public int compareTo(Node<E> node) {
			if(this.value.equals(node.getValue())) return 0;
			else return -1;
		}
		
		@Override
		public String toString() {
				return value + " " + next;
		}
		
		
		public E getValue() {
			return value;
		}
		@SuppressWarnings("unused")
		public void setValue(E value) {
			this.value = value;
		}
		@SuppressWarnings("unused")
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		LinkList2<Integer> myList = new LinkList2<Integer>();
		myList.addTail(1);
		myList.addTail(2);
		myList.addTail(3);
		myList.addTail(4);
		System.out.println(myList);
		
		myList.addHead(5);
		System.out.println(myList);
	}
}
