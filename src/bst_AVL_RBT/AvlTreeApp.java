package bst_AVL_RBT;

public class AvlTreeApp {

	// Test program
	public static void main(String[] args) {
		AvlTree<Integer> t = new AvlTree<Integer>();
		final int NUMS = 4000;
		final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.insert(i);
		if (NUMS < 40)
			t.printTree();
		if (t.findMin() != 1 || t.findMax() != NUMS - 1)
			System.out.println("FindMin or FindMax error!");

		for (int i = 1; i < NUMS; i++)
			if (!t.contains(i))
				System.out.println("Find error1!");
	}
}
