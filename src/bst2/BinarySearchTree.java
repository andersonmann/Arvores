package bst2;

import java.util.ArrayList;

/**
 * 
 * @version 2
 * 
 * @author marco.mangan@pucrs.br
 *
 */
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

	public int getLevelFor(int value) {
		return getLevelFor(root, 0, value);
	}

	private int getLevelFor(Node r, int level, int value) {
		if (r == null)
			throw new RuntimeException("ERRO: nodo não encontrado!");

		if (value == r.value)
			return level;
		else if (value < r.value)
			return getLevelFor(r.left, level + 1, value);
		// else if (value > r.value)
		else
			return getLevelFor(r.right, level + 1, value);

	}

	public int getHeightFor(int value) {
		return getHeightFor(root, value);
	}

	private int getHeightFor(Node r, int value) {
		if (r == null)
			throw new RuntimeException("ERRO: nodo não encontrado!");

		if (value == r.value) {
			return h(r);
		} else if (value < r.value)
			return getHeightFor(r.left, value);
		// else if (value > r.value)
		else
			return getHeightFor(r.right, value);
	}

	private int h(Node r) {
		if (r == null)
			return -1;

		int hl = h(r.left);
		int hr = h(r.right);

		return Math.max(hl, hr) + 1;
	}

	public ArrayList<Integer> getPathTo(int value) {
		ArrayList<Integer> result = new ArrayList<>();
		getPathTo(root, result, value);
		return result;
	}

	private void getPathTo(Node r, ArrayList<Integer> result, int value) {
		if (r == null)
			throw new RuntimeException("ERRO: valor não encontrado!");

		result.add(r.value);

		if (value != r.value) {
			if (value < r.value)
				getPathTo(r.left, result, value);
			else
				getPathTo(r.right, result, value);
		}
	}

	public boolean isLeaf(int value) {
		return getDegreeFor(root, value) == 0;
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
