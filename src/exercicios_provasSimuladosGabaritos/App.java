package exercicios_provasSimuladosGabaritos;

public class App {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Arvore a = new Arvore();
		// a.add("C");
		// a.add("B");
		// a.add("A");
		//System.out.println(a.total());
		a.add("D");
		a.add("B");
		a.add("A");
		a.add("C");
		a.add("F");
		a.add("E");
		a.add("G");
		a.add("H");
		System.out.println(a.total());
		// a.printLarguraFila();
		// a.caminhoAc("D");
		//System.out.println(a.desenhaArvoreA1());
		// a.caminhoMaiorAltura("D");
		//a.niveisImpares();
		
		a.printNivel();
	}

}
