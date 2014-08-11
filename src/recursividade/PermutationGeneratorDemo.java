package recursividade;

import java.util.ArrayList;

/**
 * This program demonstrates the permutation generator.
 */
public class PermutationGeneratorDemo {
	public static void main(String[] args) {
		long antes = System.currentTimeMillis();		
		PermutationGenerator generator = new PermutationGenerator("ABCDEF");//ABCDEFGHIJKLMNOPQRSTUVXZ
		ArrayList<String> permutations = generator.getPermutations();
		for (String s : permutations) {
			System.out.println(s);			
		}
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes)/1000;
		System.out.println("Tempo de processamento: " + tempo + " s");
	}
}
