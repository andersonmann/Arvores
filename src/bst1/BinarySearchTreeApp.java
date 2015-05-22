package bst1;

public class BinarySearchTreeApp {

	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(20);
		t.insert(10);
		t.insert(30);
		t.insert(40);
		
		System.out.println(t);
		
		System.out.println(t.contains(100));
		System.out.println(t.contains(30));

		System.out.println(t.getDegreeFor(20));		
		
	}

}
