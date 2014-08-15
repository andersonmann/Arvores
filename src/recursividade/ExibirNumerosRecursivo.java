package recursividade;

public class ExibirNumerosRecursivo {

	static void exibirNumeros(int n) {
		if (n > 0)
			exibirNumeros(n, 1);
	}

	static void exibirNumeros(int n, int i) {
		if (i <= n) {
			System.out.println(i);
			exibirNumeros(n, i + 1);
		}
	}

	public static void main(String[] args) {
		exibirNumeros(100);
	}

}
