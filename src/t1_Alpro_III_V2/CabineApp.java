package t1_Alpro_III_V2;

public class CabineApp {

	public static <E> void main(String[] args) {
		long antes = System.currentTimeMillis();
		Cabine<String> lista = new Cabine<>();		
		for (int i = 0; i < lista.getCapacidade(); i++) {
			lista.preencherTodasPosicoes("0");
		}
		System.out.println("Quantidade de elementos na lista " + lista.getTotal());
		lista.preencherPosicao(0, "R");
		lista.preencherPosicao(4, "R");
		lista.preencherPosicao(8, "R");	
		lista.preencherPosicao(16, "R");
		lista.preencherPosicao(10, "R");
		lista.preencherPosicao(14, "R");		
		System.out.println("Elementos "+lista.getLista());		
		System.out.println("Quantidade de elementos na lista " + lista.getTotal());				
		lista.substituirElemento(2, "A"); 
		lista.substituirElemento(6, "A");
		lista.substituirElemento(12, "A");		
		lista.substituirElemento(18, "A");				
		System.out.println("Elementos "+lista.getLista());				
		System.out.println("Quantidade de elementos na lista " + lista.getTotal());		
		lista.substituirElemento(1, "A");
		System.out.println("Elementos "+lista.getLista());				
		System.out.println("Quantidade de elementos na lista " + lista.getTotal());
		//System.out.println("Elementos na lista: " + lista.toString());		
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);
		System.out.println();
		System.out.println("Tempo de processamento: " + tempo + " milisegundos");
	}
}
