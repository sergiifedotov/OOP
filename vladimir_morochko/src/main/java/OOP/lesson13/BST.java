package OOP.lesson13;

/**
 * Написать бинарное дерево поиска, реализовать метод add
 * Написать метод contains
 */

public class BST {	
	Node root;

	public BST() {

	}

	public BST(Node root) {
		this();
		this.root = root;
	}
	
	// это нужно, т.к. Node не static
	private Node Node(int value) {
		return new Node(value);
	}

	@Override
	public String toString() {
		return root.toString();
	}
	
//	  public void printByLevel(Node root, int maxLevel) {
//	       Queue<Node> prev = new LinkedList<Node>();
//	       Queue<Node> next = new LinkedList<Node>();
//	       Queue<Node> tmp;
//	       boolean isLevelNull = false;
//	       int gap = (int) Math.pow(2, maxLevel);
//	       prev.add(root);
//	 
//	       while (maxLevel > 0 && !isLevelNull && !prev.isEmpty()) {
//	           isLevelNull = true;
//	           System.out.print(String.format("%" + gap + "s", " "));
//	           while (!prev.isEmpty()) {
//	               Node node = prev.poll();
//	               System.out.print(node == null ? "--" : node);
//	               if (node != null && node.left != null) {
//	                   next.add(node.left);
//	                   isLevelNull = false;
//	               } else {
//	                   next.add(null);
//	               }
//	               System.out.print(String.format("%" + (gap * 2 - 2) + "s", " "));
//	               if (node != null && node.right != null) {
//	                   next.add(node.right);
//	                   isLevelNull = false;
//	               } else {
//	                   next.add(null);
//	               }
//	           }
//	           System.out.println();
//	           gap /= 2;
//	           maxLevel--;
//	           tmp = prev;
//	           prev = next;
//	           next = tmp;
//	       }
//	   }

	
	public void add(int value) {
		boolean nodeFound = false;
		Node currentNode = root;
		while (!nodeFound) {
			int currentNodeValue = currentNode.getValue();
			if (value > currentNodeValue) {
				if (currentNode.getRight() == null) {
					currentNode.setRight(new Node(value));
					nodeFound = true;
				} else {
					currentNode = currentNode.getRight();
				}
			} else if (value < currentNodeValue) {
				if (currentNode.getLeft() == null) {
					currentNode.setLeft(new Node(value));
					nodeFound = true;
				} else {
					currentNode = currentNode.getLeft();
				}
			} else {
				nodeFound = true;
			}
		}
	}

	public void addRecusion(int value) {
		root.add(value);
	}

	public boolean contains(int value) {
		Node currentNode = root;
		while (currentNode != null) {
			int currentNodeValue = currentNode.getValue();
			if (value > currentNodeValue) {
				currentNode = currentNode.getRight();
			} else if (value < currentNodeValue) {
				currentNode = currentNode.getLeft();
			} else {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsRecusion(int value) {
		return root.contains(value);
	}
	
	private static class Node implements Comparable<Node> {
		private int value;
		private Node left;
		private Node right;

		public Node() {

		}

		public Node(int value) {
			this();
			setValue(value);
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

		@Override
		public String toString() {
			return value + "-" + "(" + 
					(left == null ? "-" : left.toString()) + 
					"+" + (right == null ? "-" : right.toString()) + ")";
		}

//		@Override
//		public String toString() {
//			return "" + value;
//		}
		
		@Override
		public int compareTo(Node dnode) {
			return value - dnode.getValue();
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}
	
	public static void main (String[] args) {
		BST myBST = new BST(new BST().Node(5));
		myBST.add(6);
		System.out.println(myBST);
		myBST.add(5);
		System.out.println(myBST);
		myBST.add(8);
		System.out.println(myBST);
		myBST.add(7);
		System.out.println(myBST);
		myBST.add(10);
		System.out.println(myBST);
		myBST.add(4);
		System.out.println(myBST);
		
		myBST.addRecusion(2);
		System.out.println(myBST);
		myBST.addRecusion(3);
		System.out.println(myBST);
		System.out.println(myBST.contains(3));
		System.out.println(myBST.containsRecusion(3));
		System.out.println(myBST.contains(123));
		System.out.println(myBST.containsRecusion(123));
		
		
//		myBST.printByLevel(myBST.root, 4); 

	}

}
