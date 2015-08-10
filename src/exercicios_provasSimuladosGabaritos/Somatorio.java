package exercicios_provasSimuladosGabaritos;

public class Somatorio {

	public static long somatorioRecursivo(long i, long j) {
		Contagem.add();
		if (i == j)
			return i;
		int meio = (int) ((i + j) / 2);
		long esq = somatorioRecursivo(i, meio);
		long dir = somatorioRecursivo(meio + 1, j);
		return esq + dir;
	}
}
