package bst1;

public class BinarySearchTree {

	private Node root;
	
	private class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
			left = right = null;
		}

		@Override
		public String toString() {
			return String.format("Node [value=%s, left=%s, right=%s]", value,
					left, right);
		}
		
		
	}
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}

	private Node insert(Node r, int value) {
		if (r == null)
			return new Node(value);
		
		if (value < r.value)
			r.left = insert(r.left, value);			
		else if (value > r.value)
			r.right = insert(r.right, value);
		else
			throw new RuntimeException("ERRO: Chave duplicada!");
		
		return r;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node r, int value) {
		if (r == null)
			return false;
		
		if (value < r.value)
			return contains(r.left, value);
		else if (value > r.value)
			return contains(r.right, value);
		else
			return true;
				
	}
	
	public int getDegreeFor(int value) {
		return getDegreeFor(root, value);
	}
		
	private int getDegreeFor(Node r, int value) {
		if (r == null)
			throw new RuntimeException("ERRO: nodo não encontrado!");
		
		if (value < r.value)
			return getDegreeFor(r.left, value);
		else if (value > r.value)
			return getDegreeFor(r.right, value);
		else {
			int c = 0;
			if (r.left != null)
				c++;
			if (r.right != null)
				c++;			
			return c;	
		}
	}

	@Override
	public String toString() {
		return String.format("BinarySearchTree [raiz=%s]", root);
	}
	

	
	
}
