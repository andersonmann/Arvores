package recursividade;

public class Somatorio {

	public static long somatorioRecursivo(long n) {
		if (n <= 0)
			throw new RuntimeException();
		return som(n);
	}

	private static long som(long n) {
		if (n == 1)
			return 1;
		return n + som(n - 1);

	}

}
