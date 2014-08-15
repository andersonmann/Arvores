package recursividade;

public class ExibirNumeros {
	static int z = 0;

	static void exibirNumeros(int n) {
		z += 1;
		z += 1;
		for (int i = 1; i <= n; i++) {
			// System.out.println(i);
			z += 2;
			z += 2;
			z += 1;
		}
	}

	public static void main(String[] args) {
		System.out.println("Números");
		for (int i = 1; i <= 10; i++) {
			z = 0;
			exibirNumeros(i);
			System.out.printf("%3d %3d\n", i, z);
		}
	}

}
