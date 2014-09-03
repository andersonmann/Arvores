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

	public void substituirElemento(int index, E element) {
		if (getPosicao(index).equals("0")) {
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
				else{
					lista.set(index, element);
				}
			}
		}
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
