/**
 * 
 */
package recursividade;

import javax.swing.JOptionPane;

/**
 * @author 10204155
 * 
 */
public class SomatorioDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long antes = System.currentTimeMillis();
		long n = Integer.parseInt(JOptionPane
				.showInputDialog("Digite um valor"));
		Somatorio soma = new Somatorio();
		n = soma.somatorioRecursivo(n);
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);
		JOptionPane.showMessageDialog(null, "O somatorio é: " + n + "\n"
				+ "Tempo de processamento: " + tempo + " ms");

	}

}
