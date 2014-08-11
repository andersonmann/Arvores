package recursividade;

import java.util.ArrayList;
import java.util.List;

public class Exemplos {
	/**
	 * Apresenta um contador regressivo.
	 * 
	 * @param i
	 *            um valor maior ou igual a zero
	 */
	public static void regressivo(int i) {
		if (i == 0) {
			System.out.println("ZERO!");
		} else {
			System.out.println(i);
			regressivo(i - 1);
		}
	}

	/**
	 * Apresenta um contador progressivo.
	 * 
	 * @param i
	 *            um valor maior ou igual a zero
	 * @param n
	 *            valor limite
	 */
	public static void progressivo(int i, int n) {
		if (i == n) {
			System.out.println("FIM!");
		} else {
			System.out.println(i);
			progressivo(i + 1, n);
		}
	}

	public static void main(String[] args) {
		System.out.println("Testes de recursividade.");
		// regressivo(10);
		// progressivo(1, 15);
		//int[] vs = { 1, 2, 3, 4, 5 };
		//System.out.println(somar(vs));
		List<Integer> ls = new ArrayList<Integer>();
		// TODO converter array em lista
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);
		ls.add(5);
		//System.out.println(ls);
		System.out.println(somarLista(ls));
		//System.out.println(ls);
	}

	private static int somarLista(List<Integer> ls) {
		return somarListaImpl(new ArrayList<Integer>(ls));
		//return somarListaImpl(ls);
	}

	private static int somarListaImpl(List<Integer> ls) {
		if (ls.isEmpty()) {
			return 0;
		} else {
			int elem = ls.remove(0);
			return elem + somarListaImpl(ls);
		}
	}

	private static int somar(int[] vs) {
		return somar(0, vs.length - 1, vs);
	}

	private static int somar(int i, int j, int[] vs) {
		if (i > j) {
			return 0;
		} else {
			return vs[i] + somar(i + 1, j, vs);
		}
	}
}
