package bst_2015;

public class BinarySearchTree {

	private class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			left = right = null;
			count++;
		}
	}

	private Node root;
	private int count;

	public BinarySearchTree() {
		root = null;
		count = 0;
	}

	public boolean isEmpity() {
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
		if (value < node.value)
			node.left = add(node.left, value);
		else if (value > node.value)
			node.right = add(node.right, value);
		else
			throw new RuntimeException("A chave j� est� cadastrada: " + value);
		return node;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		if (node == null) {
			return false;
		}
		if (value < node.value) {
			return contains(node.left, value);
		}
		if (value > node.value) {
			return contains(node.right, value);
		}
		return true;
	}

	public int getLevelByValue(int value) {
		return getLevelByValue(root, value, 0);
	}

	private int getLevelByValue(Node node, int value, int level) {
		if (node == null)
			throw new IllegalArgumentException("Chave n�o encontrada: " + value);
		if (value < node.value)
			return getLevelByValue(node.left, value, level + 1);
		if (value > node.value)
			return getLevelByValue(node.right, value, level + 1);
		return level;
	}

	public int getHeightByValue(int value) {
		return getHeigthByValue(root, value);
	}

	private int getHeigthByValue(Node node, int value) {
		if (node == null)
			throw new IllegalArgumentException("Chave nao encontrada: " + value);
		if (value < node.value)
			return getHeigthByValue(node.left, value);
		if (value > node.value)
			return getHeigthByValue(node.right, value);
		return h(node);
	}

	private int h(Node node) {
		if (node == null)
			return -1;
		return 1 + Math.max(h(node.left), h(node.right));
	}

	public String toString() {
		return toString(root);
	}

	private String toString(Node node) {
		if (node == null)
			return "*";
		return node.value + " " + toString(node.left) + " "
				+ toString(node.right);
	}

	/**
	 * Retorna o valor armazenado no nodo pai do nodo que cont�m o valor value.
	 * 
	 * @param value
	 *            o valor do nodo a ser localizado
	 * 
	 * @throws RuntimeException
	 *             se o valor {@code value} n�o foi localizado ou se o nodo
	 *             localizado n�o tem pai
	 * @throws
	 * 
	 * @return o valor do nodo pai do nodo localizado
	 */

	public int getParent(int value) {
		return getParent(root, null, value);
	}

	private int getParent(Node root, Node pather, int value) {
		if (root == null)
			throw new IllegalArgumentException("Chave n�o encontrada: " + value);
		if (root.value == value) {
			if (pather == null)
				throw new IllegalArgumentException(
						"Erro: nodo encontrado (raiz) n�o tem nodo pai!");
			return pather.value;
		} else if (value < root.value)
			return getParent(root.left, root, value);
		else
			return getParent(root.right, root, value);
	}
}
