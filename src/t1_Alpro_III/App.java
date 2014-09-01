/**
 * 
 */
package t1_Alpro_III;

/**
 * @author anderson
 *
 */
public class App {
	public static void main(String[] args) {
		long antes = System.currentTimeMillis();	
		
		CabineV3 lista = new CabineV3(10);
        lista.clear();
        lista.add("Fulano");
        lista.add("Beltrano");	
        //System.out.println(lista.count);
        System.out.println(lista.size());
        System.out.println(lista.toString());
              
        
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes)/1000;
		System.out.println("Tempo de processamento: " + tempo + " s");
	}
}

