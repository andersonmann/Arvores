package recursividade;

public class ExibirNumerosRecursivoDecrescente {

	static void exibirNumeros(int n) {
		if (n > 0) {
			exibirNumeros(n - 1);
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
		exibirNumeros(10);
	}

}
