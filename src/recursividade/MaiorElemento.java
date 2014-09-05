package recursividade;

import java.util.ArrayList;

public class MaiorElemento {	

	static int findBiggest(ArrayList<Integer> ar) {
		if (ar == null)//{
			throw new IllegalArgumentException("Lista nao pode ser null");
		//}
		if (ar.isEmpty())// {
			throw new IllegalArgumentException("Lista nao pode ser null");
		//}
		ArrayList<Integer> clone = new ArrayList<>(ar);
		
		return findBiggestAux(clone);
	}

	static int findBiggestAux(ArrayList<Integer> ar) {
		if (ar.size() == 1)
			return ar.get(0);

		int a = ar.remove(0);
		int b = ar.remove(0);

		ar.add(Math.max(a, b));
		return findBiggest(ar);
	}

	public static void main(String[] args) {
		ArrayList<Integer> exemplo = new ArrayList<>();
		exemplo.add(10);
		exemplo.add(5);
		exemplo.add(1);
		System.out.println(findBiggest(exemplo));
	}
}
