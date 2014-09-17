package t1_Alpro_III_V2;

import java.util.ArrayList;

public class Cabine<E> {
	private ArrayList<E> lista;
	static int capacidade;

	public Cabine(int capacidade) {
		Cabine.capacidade = capacidade;
		lista = new ArrayList<E>();
	}
	
	public Cabine() {
		Cabine.capacidade = 19;
		lista = new ArrayList<E>();
	}	

	public void preencherTodasPosicoes(E element) {
		lista.add(element);
	}

	public void preencherPosicao(int index, E element){
		lista.set(index, element);
	}
	
	public void entrarCabineV2(E element){ 
		for (int i = 0; i < lista.size(); i++){
			if(i == 0 && lista.get(i+1).equals("0")){
				lista.set(i, element); // insere na primeira posicao
				break;
			}
			if(i == lista.size()-1 && lista.get(lista.size()-2).equals("0")){
				lista.set(i, element);
				break;
			}			
			if(lista.get(i).equals("0") && lista.get(i+1).equals("0") && lista.get(i+2).equals("0")){ // vai dar erro no fim da lista!
				preencherPosicao(i+1, element);  // encontra a primeira cabine com as duas visinhas vazias  
				break;  						 // e insere na lista (evitando ter que percorrer toda lista).
			}
			if(lista.get(i).equals("0")){
				lista.set(i, element);
			}
			
		}
	}	

	public void entrarCabineV1(int index, E element) {		
			for (int i = 0; i < lista.size(); i++) {
				if (index == 0 && lista.get(index + 1).equals("0")) { // insere na primeira posicao
					lista.set(index, element);
					break;
				}	
				if(index == lista.size()-1 && lista.get(index -1).equals("0")) {  // insere na ultima posicao 
					lista.set(index, element);
					break;
				}				
				if (lista.get(index - 1).equals("0") && lista.get(index + 1).equals("0")) { // insere no meio de duas cabines vazias
					lista.set(index, element);
					break;
				}
				if(encontraPosicaoLivre() != -1){ // insere em uma posicao livre
					lista.set(encontraPosicaoLivre(), element);
					break;
				}
				else if(encontraPosicaoLivre2() != -1){ // insere em uma posicao livre
					lista.set(encontraPosicaoLivre2(), element);
					break;
				}				
			}
		}	
	
	/*
	 *  Corrigir o metodo encontraPosicaoLivre, ele está adicionando na primeira posicao 
	 *  livre, sem antes verificar se tem mais alguma posicao com visinhas livres.
	 */
	public int encontraPosicaoLivre(){
		for (int pos = 0; pos < lista.size(); pos++) { // percorre a lista até o final
			if(lista.get(pos-1).equals("0") && lista.get(pos+1).equals("0")){
				return pos+2;
			}
		}
		return -1;
	}	
	
	public int encontraPosicaoLivre2() {		
		for (int pos = 0; pos < lista.size(); pos++) { // percorre a lista até o final		
			if(lista.get(pos).equals("0")){
				return pos;
			}							
		}
		return -1;
	}

	
	/*public int encontraPosicaoLivre(){		
		for(E element: lista){
			if(element.equals("0")){
				return getPosicao2(element);
			}
		}
		return -1;
	}*/
	
	public int getPosicao2(E element) {
		return lista.indexOf(element);
	}	

	public E getPosicao(int posicao) {
		return lista.get(posicao);
	}
	
	public int getCapacidade() {
		return capacidade;
	}	

	/**
	 * @return the lista
	 */
	public ArrayList<E> getLista() {
		return lista;
	}

	public int getTotal() {
		return lista.size();
	}

	public String toString() {
		if (lista.isEmpty()) {
			return ("Lista vazia !!");
		} else {
			StringBuilder sb = new StringBuilder();
			for (E p : lista) {
				sb.append(p.toString());
				sb.append("|");// sb.append("\n");
			}
			return (sb.toString());
		}
	}

}
