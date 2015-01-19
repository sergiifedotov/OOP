package OOP.lesson11;

public class DoubleLinkList {
	public static void main(String[] args) {
		DoubleLinkList myList = new DoubleLinkList();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		System.out.print(myList.getDNode().getValue());
		System.out.print(myList.getDNode().getNext().getValue());
		System.out.print(myList.getDNode().getNext().getNext().getValue());
		System.out.println();
		
		System.out.print(myList.getElement(2));
		System.out.println();
		
		myList.print();
		
	}
	
	private int size;
	private DNode dnode;
	
	public DoubleLinkList() {
		setDNode(null);
		setSize(0);
	}
	
	public DoubleLinkList(DNode dnode) {
		this.setDNode(dnode);
		setSize(1);
	}
	
	public void add(int value) {
		setDNode(new DNode(dnode, null));
		if (dnode.getNext() != null) {
			dnode.getNext().setPrevious(dnode);
		}
		dnode.setValue(value);
		size++;
	}
	
	public void print() {
		if (dnode != null) {
			dnode.print();
		}
	}
	
	public int getElement(int number) {
		if (dnode != null) {
			return dnode.getElement(number);
		}
		return 0;
	}
	
	public int size() {
		return getSize();
	}
	
	public DNode getDNode() {
		return dnode;
	}

	public void setDNode(DNode dnode) {
		this.dnode = dnode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}



	private class DNode {
		private int value;
		private DNode next;
		private DNode previous;
		
		public DNode(DNode next, DNode previous) {
			this.setNext(next);
			this.setPrevious(previous);
		}
		
		public int getElement(int number) {
			if (number > 0 && next != null) {
				number--;
				return next.getElement(number);
			} else {
				return value;
			}
		}

		public void print() {
			System.out.print(value);
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

		public DNode getNext() {
			return next;
		}

		public void setNext(DNode next) {
			this.next = next;
		}

		@SuppressWarnings("unused")
		public DNode getPrevious() {
			return previous;
		}

		public void setPrevious(DNode previous) {
			this.previous = previous;
		}

		
	}

}
