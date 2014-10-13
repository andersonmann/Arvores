package bst3;

import java.util.ArrayList;

/**
 * 
 * @version 3
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

	public ArrayList<Integer> getPathToRoot(int value) {
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

	/**
	 * Retorna {@code true} se a árvore não contém nodos.
	 * 
	 * @return {@code true} se a árvore não contém nodos
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Retorna o valor armazenado no nodo pai do nodo que contém o valor value.
	 * 
	 * @param value
	 *            o valor do nodo a ser localizado
	 * 
	 * @throws RuntimeException
	 *             se o valor {@code value} não foi localizado ou se o nodo
	 *             localizado não tem pai
	 * @throws
	 * 
	 * @return o valor do nodo pai do nodo localizado
	 */
	public int getParent(int value) {
		return getParent(root, null, value);
	}

	private int getParent(Node r, Node p, int value) {
		if (r == null)
			throw new RuntimeException("ERRO: nodo não encontrado!");

		if (r.value == value) {

			if (p == null)
				throw new RuntimeException(
						"ERRO: nodo encontrado (raiz) não tem nodo pai!");

			return p.value;

		} else if (value < r.value)
			return getParent(r.left, r, value);
		else
			return getParent(r.right, r, value);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public int getUncle(int value) {
		return getUncle(root, value);
	}

	private int getUncle(Node r, int value) {
		int p = getParent(value);
		int gp = getParent(p);

		return getUncle(r, p, gp, value);
	}

	private int getUncle(Node r, int p, int gp, int value) {
		if (r == null)
			throw new RuntimeException("ERRO: nodo não encontrado!");

		if (r.value == gp) {
			
			Node uncle = r.left;
			if (p < gp)
				uncle = r.right;
			if (uncle == null)
				throw new RuntimeException("ERRO: tio inexistente (null)!");

			return uncle.value;

		} else if (value < r.value)
			return getUncle(r.left, p, gp, value);
		else
			return getUncle(r.right, p, gp, value);
	}

}
