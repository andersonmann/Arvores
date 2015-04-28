package Arvores;

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

		if (value < node.value)
			node.left = add(node.left, value);
		else if (value > node.value)
			node.right = add(node.right, value);
		else
			throw new RuntimeException("A chave já está cadastrada: " + value);

		return node;
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

	public int getLevelByValue(int value) {
		return getLevelByValue(root, value, 0);
	}

	private int getLevelByValue(Node node, int value, int level) {
		if (node == null)
			throw new IllegalArgumentException("Chave não encontrada: " + value);

		if (value < node.value)
			return getLevelByValue(node.left, value, level + 1);

		if (value > node.value)
			return getLevelByValue(node.right, value, level + 1);

		return level;
	}

	public int getHeightByValue(int value) {
		return getHeightByValue(root, value);
	}

	private int getHeightByValue(Node node, int value) {
		if (node == null)
			throw new IllegalArgumentException("Chave não encontrada: " + value);

		if (value < node.value)
			return getHeightByValue(node.left, value);

		if (value > node.value)
			return getHeightByValue(node.right, value);

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

	private int getParent(Node root, Node pather, int value) {
		if (root == null)
			throw new IllegalArgumentException("ERRO: nodo não encontrado!");
		if (root.value == value) {
			if (pather == null)
				throw new IllegalArgumentException(
						"ERRO: nodo encontrado (raiz) não tem nodo pai!");
			return pather.value;
		} else if (value < root.value)
			return getParent(root.left, root, value);
		else
			return getParent(root.right, root, value);
	}

	public int[] getChildren(int i) {
		return new int[0];
	}

}