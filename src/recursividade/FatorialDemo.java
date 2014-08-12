/**
 * 
 */
package recursividade;

import javax.swing.JOptionPane;

/**
 * @author Anderson_M_Mann
 * 
 */
public class FatorialDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long antes = System.currentTimeMillis();
		long n = Integer
				.parseInt(JOptionPane.showInputDialog("Digite um valor"));
		Fatorial fat = new Fatorial();
		n = fat.fatorialRecursivo(n);

		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);
		JOptionPane.showMessageDialog(null, "O fatorial é: " + n + "\n"
				+ "Tempo de processamento: " + tempo + " ms");
	}
}
