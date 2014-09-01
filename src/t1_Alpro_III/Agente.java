/**
 * 
 */
package t1_Alpro_III;

/**
 * @author anderson
 *
 */
public class Agente {
	private int numero;
	
	public Agente(int numero){
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Agente [numero=" + numero + "]";
	}
	
	

}
