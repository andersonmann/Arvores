package bst4;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Retorna uma lista com os valores pares armazenados na árvore.
	 * 
	 * @return
	 */
	public List<Integer> getEven() {
		ArrayList<Integer> result = new ArrayList<>();
		getEven(root, result);
		return result;
	}

	private void getEven(Node r, ArrayList<Integer> result) {
		if (r == null)
			return;
		if (r.value % 2 == 0)
			result.add(r.value);
		getEven(r.left, result);
		getEven(r.right, result);
	}

	/**
	 * Visita cada nodo da árvore e executa o método process do Processor sobre
	 * o valor armazenado no nodo.
	 * 
	 * @param p
	 */
	public void visit(Processor p) {
		visit(root, p);
	}

	private void visit(Node r, Processor p) {
		if (r != null) {
			visit(r.left, p);
			p.process(r.value);
			visit(r.right, p);
		}
	}

	public void drawTree() {
		if (root == null)
			System.out.println("VAZIA!");

		int h = getHeightFor(root.value);
		int fill = h * 4;
		String fillString;
		for (int i = 0; i <= h; i++) {
			fillString = "";
			for (int j = 0; j < fill; j++)
				fillString += ".";
			// System.out.print(fillString);
			drawTree(root, 0, i, fillString);
			System.out.println();
			fill -= 4;
		}
	}

	private void drawTree(Node r, int count, int level, String fillString) {
		if (r != null) {
			if (count == level)
				System.out.printf("%s %d", fillString, r.value);
			drawTree(r.left, count + 1, level, fillString);
			drawTree(r.right, count + 1, level, fillString);
		}
	}

	/**
	 * 
	 */
	public void drawTree2() {
		drawTree2(root, "");
	}

	private void drawTree2(Node r, String fill) {
		if (r == null)
			return;

		if (r.left == null && r.right == null)
			System.out.printf(".%s %d\n", fill, r.value);
		else
			System.out.printf("+%s %d\n", fill, r.value);

		drawTree2(r.left, fill + ".");
		drawTree2(r.right, fill + ".");
	}

	public List<Integer> getEvenChild() {
		ArrayList<Integer> result = new ArrayList<>();
		getEvenChild(root, result);
		return result;
	}

	private void getEvenChild(Node r, ArrayList<Integer> result) {
		if (r == null)
			return;
		if (r.value % 2 == 0) {
			if (r.left != null)
				result.add(r.left.value);
			if (r.right != null)
				result.add(r.right.value);
		}
		getEvenChild(r.left, result);
		getEvenChild(r.right, result);
	}

	public boolean check() {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean check(Node r, int min, int max) {
		// if (r == null)
		// return true;
		//
		return r == null || r.value > min && r.value < max
				&& check(r.left, min, r.value) && check(r.right, r.value, max);
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node r) {
		if (r == null)
			return;
		System.out.println(r.value);
		preorder(r.left);
		preorder(r.right);

	}

	public void central() {
		central(root);
	}

	private void central(Node r) {
		if (r == null)
			return;
		central(r.left);
		System.out.println(r.value);
		central(r.right);

	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node r) {
		if (r == null)
			return;
		postorder(r.left);
		postorder(r.right);
		System.out.println(r.value);

	}

	public List<Integer> getLeaf() {
		ArrayList<Integer> result = new ArrayList<>();
		getLeaf(root, result);
		return result;
	}

	private void getLeaf(Node r, ArrayList<Integer> result) {
		if (r == null)
			return;
		if (r.left == null && r.right == null)
			result.add(r.value);
		getLeaf(r.left, result);
		getLeaf(r.right, result);
	}

}
