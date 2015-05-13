package bst_2015;

public class AVLTree {
	
	private class Node {
		int value;
		int height;
		Node left, right;

		public Node(int value) {
			this.value = value;
			left = right = null;
			height = 0;
			count++;
		}
	}

	private Node root;
	private int count;

	public AVLTree() {
		root = null;
		count = 0;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return count;
	}

	public void add(int value) {
		root = add(root, value);
	}

	private Node add(Node node, int value) {
		if (node == null)
			return new Node(value);

		if (value < node.value) {
			node.left = add(node.left, value);
			int delta = h(node.left)- h(node.right);
			if (delta == 2) {
				System.out.println("Rotação com o filho da esquerda");
				System.out.printf("Node: %d, node.left: %d, value: %d\n",
						node.value, node.left.value, value);
				// 
				Node a = node.left;
				// o esquerdo do 20 recebe o direito do 10
				node.left = a.right;
				// o direito do 10 recebe o 20
				a.right = node;
				// retornar 10 como novo raiz da subarvore
				node.height = 1 + Math.max(h(node.left), h(node.right));
				a.height = 1+ Math.max(h(a.left), h(a.right));
				node = a;
			}
			
		} else if (value > node.value)
			node.right = add(node.right, value);
		else
			throw new RuntimeException("A chave já está cadastrada: " + value);
		//
		node.height = 1 + Math.max(h(node.left), h(node.right));
		//
		return node;
	}

	private int h(Node node) {
		return node == null ? -1 : node.height;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		if (node == null)
			return false;

		if (value < node.value)
			return contains(node.left, value);

		if (value > node.value)
			return contains(node.right, value);

		return true;
	}

	public String toString() {
		return toString(root);
	}

	private String toString(Node node) {
		if (node == null)
			return "*";
		return node.value + " (" + node.height + ")  [" + (h(node.left)- h(node.right)) + "] " + toString(node.left)
				+ " " + toString(node.right);
	}

}
