package OOP.homework14;


/**
 Создать двоичное дерево поиска и реализовать методы:
 1. Поиск элемента в дереве, boolean contains(int element)
 2. Прямой обход дерева в ширину (вершина, левое, правое), void traversPreOrder()
 3. Вычисления количества элементов дерева, int count()
 4. Вычисление высоты дерева, int calcHeight()
 5. Нахождение наибольшего элемента, int max()

 Классы задания:
 hw8.bst.BST
 hw8.bst.TNode
 */

public class BST {
	Node root;

	public BST() {

	}

	public BST(Node root) {
		this();
		this.root = root;
	}

//	private Node Node(int value) {
//		return new Node(value);
//	}
	
	@Override
	public String toString() {
		return root.toString();
	}

	public void add(int value) {
		root.add(value);
	}
	
	public boolean contains(int value) {
		return root.contains(value);
	}
	
	public void traversPreOrder() {
		System.out.println(traversPreOrderToString());
	}
	
	private String traversPreOrderToString() {
		return root.traversPreOrder();	
	}

	public int count() {
		return root.count();
	}

	public int calcHeight() {
		return root.calcHeight();
	}
	
	public int max() {
		return root.max();
	}

	private class Node {
		private int value;
		private Node left;
		private Node right;

		public Node() {

		}

		public Node(int value) {
			this();
			this.value = value;
		}
		
		public void add(int value) {
			if (value > this.value) {
				if (right == null) {
					right = new Node(value);
					return;
				} else { 
					right.add(value);
				}
			} else if (value < this.value) {
				if (left == null) {
					left = new Node(value);
					return;
				} else {
					left.add(value);
				}
			} else {
				return;
			}
		}

		public boolean contains(int value) {
			if (value > this.value) {
				if (right == null) {
					return false;
				} else { 
					return right.contains(value);
				}
			} else if (value < this.value) {
				if (left == null) {
					return false;
				} else {
					return left.contains(value);
				}
			} else {
				return true;
			}
		}
		
		public String traversPreOrder() {
			String answer = " -> " + value;
			if (left != null) {
				answer += left.traversPreOrder();
			}
			if (right != null) {
				answer += right.traversPreOrder();
			}
			return answer;
		}

		public int count() {
			int answer = 1;
			if (right != null) {
				answer += right.count();
			}
			if (left != null) {
				answer += left.count();
			}
			return answer;
		}
		
		public int calcHeight() {
			int rightHeight = 0;
			if (right != null) {
				rightHeight = right.calcHeight();
			}
			int leftHeight = 0;
			if (left != null) {
				leftHeight = left.calcHeight();
			}
			return 1 + (rightHeight > leftHeight ? rightHeight : leftHeight);
		}
		
		public int max() {
			int answer = value;
			if (right != null) {
				int rightMax = right.max();
				if (rightMax > answer) {
					answer = rightMax;
				}
			}
			if (left != null) {
				int leftMax = left.max();
				if (leftMax > answer) {
					answer = leftMax;
				}
			}
			return answer;
		}

		@Override
		public String toString() {
			return value + "-(" + 
					(left == null ? "-" : left.toString()) + 
					"+" + (right == null ? "-" : right.toString()) + ")";
		}
		
	}

	public static void main (String[] args) {
		BST myBST = new BST(new BST().new Node(5));
		myBST.add(6);
		System.out.println(myBST);
		myBST.add(5);
		System.out.println(myBST);
		myBST.add(8);
		System.out.println(myBST);
		myBST.add(7);
		System.out.println(myBST);
		myBST.add(9);
		System.out.println(myBST);
		myBST.add(10);
		System.out.println(myBST);
		myBST.add(4);
		System.out.println(myBST);	
		myBST.add(2);
		System.out.println(myBST);
		myBST.add(3);
		System.out.println(myBST);
		myBST.add(1);
		System.out.println(myBST);
		System.out.println("contains 3 : " + myBST.contains(3));
		System.out.println("contains 123 : " + myBST.contains(123));
		System.out.println("count : " + myBST.count());
		System.out.println("max : " + myBST.max());
		System.out.println("height : " + myBST.calcHeight());
		System.out.println("travers:" + myBST.traversPreOrderToString());
	}
	
}
