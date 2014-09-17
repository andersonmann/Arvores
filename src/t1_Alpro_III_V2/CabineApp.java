package t1_Alpro_III_V2;

public class CabineApp {

	public static <E> void main(String[] args) {
		long antes = System.currentTimeMillis();
		Cabine<String> lista = new Cabine<>(10);		
		for (int i = 0; i < lista.getCapacidade(); i++) {
			lista.preencherTodasPosicoes("0");
		}
		System.out.println("Quantidade de elementos na lista " + lista.getTotal());
/*		lista.preencherPosicao(0, "R");
		lista.preencherPosicao(4, "R");
		lista.preencherPosicao(8, "R");	
		lista.preencherPosicao(16, "R");
		lista.preencherPosicao(10, "R");
		lista.preencherPosicao(14, "R");*/
		//lista.preencherPosicao(0, "URSS");
		lista.preencherPosicao(1, "URSS");lista.preencherPosicao(2, "URSS");
		lista.preencherPosicao(3, "URSS");lista.preencherPosicao(4, "URSS");lista.preencherPosicao(5, "URSS");
		lista.preencherPosicao(6, "URSS");lista.preencherPosicao(7, "URSS");//lista.preencherPosicao(9, "URSS");		
		//lista.preencherPosicao(9, "URSS");lista.preencherPosicao(10, "URSS");lista.preencherPosicao(11, "URSS");
		//lista.preencherPosicao(12, "URSS");lista.preencherPosicao(13, "URSS");lista.preencherPosicao(14, "URSS");
		//lista.preencherPosicao(15, "URSS");lista.preencherPosicao(16, "URSS");lista.preencherPosicao(17, "URSS");
		//lista.preencherPosicao(18, "URSS");
		System.out.println("Elementos "+lista.getLista());
		/*
		 * lista.entrarCabineV1(0, "AMER");  está falhando para a posicao 0
		 * lista.entrarCabineV1(index, element"); está falhando quando todas posicoes estao ocupadas
		 */			
		//lista.entrarCabineV1(8, "A");		
		//lista.entrarCabineV2("AMER");
		
		
		System.out.println("Elementos "+lista.getLista());		
		//System.out.println("Quantidade de elementos na lista " + lista.getTotal());				
		/*lista.substituirElemento(2, "A"); 
		lista.substituirElemento(6, "A");
		lista.substituirElemento(12, "A");		
		lista.substituirElemento(18, "A");			*/	
		System.out.println("Elementos "+lista.getLista());				
		System.out.println("Quantidade de elementos na lista " + lista.getTotal());		
		//.substituirElemento(1, "A");
		//System.out.println("Elementos "+lista.getLista());				
		//System.out.println("Quantidade de elementos na lista " + lista.getTotal());
		//System.out.println("Elementos na lista: " + lista.toString());		
		long depois = System.currentTimeMillis();
		long tempo = (depois - antes);
		System.out.println();
		System.out.println("Tempo de processamento: " + tempo + " milisegundos");
	}
}
