package t1_Alpro_III;

public class Cabine<E> {
	protected E[] data;
	protected int count;
	protected int capacity;

	public Cabine() {
		this(10); // Cria um array com tamanho 10
	}

	@SuppressWarnings("unchecked")
	public Cabine(int capacidade) {
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
		// public void add(Object element) {
		if (count == capacity) { // se o array est� cheio chama setCapacity
			setCapacity(capacity * 2); // dobra o tamanho do array
			data[count] = element; // adicona o elemento na posi��o de count
			count++; // incrementa o contador
		}
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

	public void add(int index, E element) {
		if (index == 0 && count == 0) {
			add(element);
		}
		if (index < 0 || index >= count) { // verifica se o index � valido
			throw new IndexOutOfBoundsException("Posi��o invalida" + index);
		}
		if (count == capacity) { // verifa se o array n�o est� cheio
			setCapacity(capacity * 2);
		}
		// Copia os elementos da posi��o desejada at� o �ltimo ocupado
		// mas do fim para o in�cio
		for (int pos = count - 1; pos >= index; pos--) {
			data[pos + 1] = data[pos];
		}
		data[index] = element; // insere o novo elemento na posi��o
		count++; // incrementa o count
	}

	public E get(int index) {
		if (index < 0 || index >= count) { // verifica se o index � valido
			throw new IndexOutOfBoundsException("Posi��o invalida " + index);
		}
		return (E) data[index];
	}

	public E set(int index, E element) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Posi��o invalida " + index);
		}
		E aux = data[index]; // salva referencia de index
		data[index] = element; // troca o elemento
		return aux; // exibe o elemento substituido
	}

	public boolean remove(E element) {
		int index = indexOf(element); // verifica a posi��o do elemento
		if (index == -1) { // Elemento n�o existe na lista
			return false;
		}
		remove(index); // se o elemento existir, � removido
		return true; // retorna true indicando que o elemento foi removido
	}

	public E remove(int index) {
		if (index < 0 || index >= count) { // verifica se o index � valido
			throw new IndexOutOfBoundsException("Posi��o invalida" + index);
		}
		E aux = data[index]; // variavel local que armazena o elemento que ser�
								// removido
		// Copia as refs. seguintes para as posi��es anteriores a elas
		// (vai at� count-2, pois sempre pega o pos+1 e o limite � count-1)
		for (int pos = index; pos < count - 1; pos++) {
			data[pos] = data[pos + 1];
		}
		// Remove a ref. da �ltima posi��o (s� por precau��o...)
		data[count - 1] = null;
		count--; // decrementa o contador
		return aux; // retorna o elemento que foi removido
	}

	public boolean isEmpty() {
		return count == 0; // retorna true se o array estiver vazio
	}

	public int size() {
		return count; // retorna a quantidade de elementos do array
	}

	public boolean contains(E element) {
		return indexOf(element) != -1; // retorna true se o elemento existe
	}

	public int indexOf(E element) {
		for (int pos = 0; pos < count; pos++) { // percorre todo o array
			if (data[pos].equals(element)) { // compara os elementos por posi��o
				return pos; // se o elemento existe retorna a posi�ao
			}
		}
		return -1; // caso contrario retorna -1
	}

	@SuppressWarnings("unchecked")
	public void clear() { // Recria array com a capacidade atual
		data = (E[]) new Object[capacity];
		count = 0; // E zera o total de elementos
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
