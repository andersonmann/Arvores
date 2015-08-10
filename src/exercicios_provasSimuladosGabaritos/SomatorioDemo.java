/**
 * 
 */
package exercicios_provasSimuladosGabaritos;

import javax.swing.JOptionPane;

import recursividade.Somatorio;

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
		long valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor"));			
		long n = Somatorio.somatorioRecursivo(valor);		
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);
		JOptionPane.showMessageDialog(null, "O somatorio é: " + n + "\n" + "Tempo de processamento: " + tempo + " ms: " + "\ncont: "+ Contagem.getCounter());
	}

}
