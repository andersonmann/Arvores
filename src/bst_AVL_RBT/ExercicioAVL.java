package bst_AVL_RBT;

public class ExercicioAVL {

	public static void main(String[] args) {
		System.out.println("Exercício AVL");
		Exercicio_AvlTree<Integer> t = new Exercicio_AvlTree<Integer>();
		// BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();

		// for (int i = 1; i <= 7; i++) {
		// t.insert(i);
		// System.out.println(t.desenhaArvoreA1());
		// }
		// System.out.println("FIM");

		// t.makeEmpty();
		//
		// for (int i = 7; i >= 1; i--) {
		// t.insert(i);
		// System.out.println(t.desenhaArvoreA1());
		//
		// }

		// t.makeEmpty();
		//
		// Random r = new Random();
		// for (int i = 1; i <= 7; i++) {
		// t.insert(r.nextInt(100));
		// System.out.println(t.desenhaArvoreA1());
		//
		// }

		// t.makeEmpty();
		//
		// int[] vs = { 1, 2, 4, 3 };
		// for (int i : vs) {
		// t.insert(i);
		// System.out.println(t.desenhaArvoreA1());
		// }

		t.makeEmpty();

		int[] ys = { 1, 2, 3, 4, 6, 7, 8, 5 };
		for (int i : ys) {
			t.insert(i);
			System.out.println(t.desenhaArvoreA1());
		}

	}

}
