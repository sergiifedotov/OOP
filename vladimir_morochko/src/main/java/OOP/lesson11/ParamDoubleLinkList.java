package OOP.lesson11;

public class ParamDoubleLinkList<T extends Comparable<T>> {
	public static void main(String[] args) {
		ParamDoubleLinkList<Integer> myList = new ParamDoubleLinkList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		System.out.print(myList.getDnode().getValue());
		System.out.print(myList.getDnode().getNext().getValue());
		System.out.print(myList.getDnode().getNext().getNext().getValue());
		System.out.println();
		
		System.out.print(myList.getElement(2));
		System.out.println();
		
		myList.print();
		
		System.out.println(myList.max());
	}
	
	private int size;
	private DNode<T> dnode;
		
	public ParamDoubleLinkList() {
		setDnode(null);
		setSize(0);
	}
	
	public ParamDoubleLinkList(DNode<T> node) {
		setDnode(node);
		setSize(1);
	}
	
	public T max() {
		return dnode.max();
	}
	
	
	public void add(T value) {
		dnode = new DNode<T>(dnode, null);
		if (dnode.getNext() != null) {
			dnode.getNext().setPrevious(dnode);
		}
		dnode.setValue(value);
		size++;

	}
	
	public void print() {
		if (!(dnode == null)) {
			dnode.print();
		}
	}
	
	public T getElement(int number) {
		if (!(dnode == null)) {
			return dnode.getElement(number);
		}
		return null;
	}
	
	public int size() {
		return getSize();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public DNode<T> getDnode() {
		return dnode;
	}

	public void setDnode(DNode<T> dnode) {
		this.dnode = dnode;
	}



	@SuppressWarnings("hiding")
	private class DNode<T extends Comparable<T>> {
				
		private T value;
		private DNode<T> next;
		private DNode<T> previous;
		
		public DNode(DNode<T> next, DNode<T> previous) {
			this.setNext(next);
			this.setPrevious(previous);
		}
		
		public T getElement(int number) {
			if (number > 0 && next != null) {
				number--;
				return next.getElement(number);
			} else {
				return value;
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
			System.out.print(value);
			if (getNext() != null) {
				System.out.print(" -> ");
				getNext().print();
			}
			System.out.println();
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public DNode<T> getNext() {
			return next;
		}

		public void setNext(DNode<T> next) {
			this.next = next;
		}

		@SuppressWarnings("unused")
		public DNode<T> getPrevious() {
			return previous;
		}

		public void setPrevious(DNode<T> previous) {
			this.previous = previous;
		}

	}

}
