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
		// se n é igual a 0, retorna 1
		if (n == 0) {
			return 1;
		}
		// Caso contrario, o método recursivo é chamado
		return n * fatorialRecursivo(n - 1);
	}
}
