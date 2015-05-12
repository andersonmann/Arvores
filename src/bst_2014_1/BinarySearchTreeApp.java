package bst_2014_1;

public class BinarySearchTreeApp {

	public static void main(String[] args) {
		BinarySearchTree t1 = new BinarySearchTree();
		System.out.println("Elementos na arvore: " + t1.size());
		System.out.println(t1);
		t1.add(12);
		System.out.println("Elementos na arvore: " + t1.size());
		System.out.println(t1);
		t1.add(10);
		System.out.println("Elementos na arvore: " + t1.size());
		System.out.println(t1);
	}
}