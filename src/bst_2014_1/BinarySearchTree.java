package bst_2014_1;

/*
 * BinarySearchTree - 2014/1
 */
public class BinarySearchTree {

	static class Node {
		int info;
		Node left, right;
	}

	private Node root;

	public void add(int info) {
		root = add(info, root);
	}

	private Node add(int info, Node t) {
		if (t == null) {
			Node newNode = new Node();
			newNode.info = info;
			return newNode;
		}

		if (info < t.info)
			t.left = add(info, t.left);
		else
			t.right = add(info, t.right);

		return t;
	}

	public int size() {
		return size(root);
	}

	private int size(Node t) {
		if (t == null)
			return 0;
		return 1 + size(t.left) + size(t.right);
	}

	@Override
	public String toString() {
		return toString(root);
	}

	private String toString(Node t) {
		if (t == null)
			return "#";
		return String.format("%d %s %s", t.info, toString(t.left),
				toString(t.right));
	}

	public static void main(String[] args) {
		BinarySearchTree t1 = new BinarySearchTree();
		System.out.println(t1.size());
		System.out.println(t1);
		t1.add(12);
		System.out.println(t1.size());
		System.out.println(t1);
		t1.add(10);
		System.out.println(t1.size());
		System.out.println(t1);

	}

}