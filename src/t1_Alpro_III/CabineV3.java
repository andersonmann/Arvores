package t1_Alpro_III;

public class CabineV3<E> {
	protected E[] data;
	protected int count;
	protected int capacity;

	public CabineV3() {
		this(10); // Cria um array com tamanho 10
	}

	@SuppressWarnings("unchecked")
	public CabineV3(int capacidade) {
		if (capacidade > 0) {
			capacity = capacidade;
		} else {
			capacity = 10;
		}
		clear();
		data = (E[]) new Object[capacity];
		count = 0;
	}

	public void add(E element) {
		if (count == 0) {
			data[count] = element;
			count++;
		}
		verificaPosicaoVazia(count);
		if (verificaPosicaoVazia(count) == false
				&& verificaPosicaoVazia(count + 1) == false) {
			data[count] = element;
			count++;
		}		
	}

	public boolean verificaPosicaoVazia(int i) {
		for (int pos = 0; pos < count; pos++) { // percorre todo o array
			if (data[pos].equals(null)) { // verifica as posi��es que est�o
											// vazias
				return true; // se est� vazia retorna a posi�ao
			}
		}
		return false; // caso contrario retorna -1
	}

	@SuppressWarnings("unchecked")
	public void setCapacity(int newCapacity) {
		if (newCapacity != capacity) { // verifica se a nova capacidade n�o �
										// igual a atual
			int minimum = 0; // define o tamanho m�nimo do array
			// variavel local para armazenar os elementos que
			// ser�o movidos para o novo array com capacidade maior
			Object[] newData = new Object[newCapacity]; // necessario cast
			if (capacity < newCapacity) { // verifica se capacidade atual �
											// menor que a nova
				minimum = capacity; //
			} else {
				minimum = newCapacity; //
			}
			for (int pos = 0; pos < minimum; pos++) {
				newData[pos] = data[pos]; // copia os elementos para o novo
											// array
			}
			data = (E[]) newData;
			capacity = newCapacity;
		}
	}

	@SuppressWarnings("unchecked")
	public void clear() { // Recria array com a capacidade atual
		data = (E[]) new Object[capacity];
		count = 0; // E zera o total de elementos
	}

	public int size() {
		return count; // retorna a quantidade de elementos do array
	}

	@Override
	public String toString() {
		// Usando StringBuffer por uma quest�o de efici�ncia
		StringBuffer aux = new StringBuffer();
		for (int p = 0; p < count; p++) {
			aux.append(data[p] + " ");
		}
		return aux.toString();
	}
}