/**
 * 
 */
package recursividade;

/**
 * @author Anderson_M_Mann
 * 
 */
public class Fatorial {

	public long fatorialRecursivo(long n) {
		// se n � igual a 0, retorna 1
		if (n == 0) {
			return 1;
		}
		// Caso contrario, o m�todo recursivo � chamado
		return n * fatorialRecursivo(n - 1);
	}
}
