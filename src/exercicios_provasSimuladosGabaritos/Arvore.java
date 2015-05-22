package exercicios_provasSimuladosGabaritos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A classe <code> Arvore </code> implementa uma árvore binária de pesquisa.
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public class Arvore {

	private static class Nodo {
		String info;
		Nodo esquerdo;
		Nodo direito;

		public Nodo(String s) {
			info = s;
			esquerdo = direito = null;
		}
	}

	private Nodo raiz;

	/**
 * 
 */
	public Arvore() {
		raiz = null;
	}

	/**
	 * 
	 * @param s
	 */
	public void add(String s) {
		raiz = add(raiz, s);
	}

	private Nodo add(Nodo n, String s) {
		if (n == null) {
			Nodo novo = new Nodo(s);
			return novo;
		}
		if (s.compareTo(n.info) < 0) {
			n.esquerdo = add(n.esquerdo, s);
		} else if (s.compareTo(n.info) > 0) {
			n.direito = add(n.direito, s);
		} else {
			throw new IllegalArgumentException("Chave repetida!");
		}
		return n;
	}

	/**
 * 
 */
	public void print() {
		print(raiz);
	}

	private void print(Nodo n) {
		if (n != null) {
			print(n.esquerdo);
			System.out.println(n.info);
			print(n.direito);
		}
	}

	/**
 * 
 */
	public void printNivel() {
		printNivel(raiz, 0);
	}

	private void printNivel(Nodo n, int nivel) {
		if (n != null) {
			printNivel(n.esquerdo, nivel + 1);
			System.out.printf("%s %d\n", n.info, nivel);
			printNivel(n.direito, nivel + 1);
		}
	}

	/**
 * 
 */
	public void printLarguraOndas() {
		for (int i = 0; i < altura(); i++) {
			System.out.println(i);
			printLarguraOndas(raiz, 0, i);
		}
	}

	private void printLarguraOndas(Nodo n, int nivel, int c) {
		if (n != null) {
			printLarguraOndas(n.esquerdo, nivel + 1, c);
			if (nivel == c)
				System.out.printf("%s %d\n", n.info, nivel);
			printLarguraOndas(n.direito, nivel + 1, c);
		}
	}

	/**
 * 
 */
	public void printLarguraFila() {
		Queue<Nodo> f = new LinkedList<Nodo>();
		if (raiz != null) {
			f.add(raiz);
		}
		while (!f.isEmpty()) {
			Nodo n = f.remove();
			System.out.println(n.info);
			if (n.esquerdo != null) {
				f.add(n.esquerdo);
			}
			if (n.direito != null) {
				f.add(n.direito);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public int altura() {
		return altura(raiz);
	}

	private int altura(Nodo n) {
		if (n == null)
			return 0;
		return 1 + Math.max(altura(n.esquerdo), altura(n.direito));
	}

	private List<String> desenhaAltura(Nodo n) {
		if (n == null)
			return new ArrayList<String>();
		List<String> esq = desenhaAltura(n.esquerdo);
		List<String> dir = desenhaAltura(n.direito);
		if (esq.size() >= dir.size()) {
			esq.add(n.info);
			return esq;
		} else {
			dir.add(n.info);
			return dir;
		}
	}

	private void desenhaAltura2(Nodo n) {
		if (n != null) {
			System.out.println(n.info);
			int esq = altura(n.esquerdo);
			int dir = altura(n.direito);
			if (esq > dir) {
				desenhaAltura2(n.esquerdo);
			} else {
				desenhaAltura2(n.direito);
			}
		}
	}

	private String desenhaAltura3(Nodo n) {
		return desenhaAltura3(n, "");
	}

	private String desenhaAltura3(Nodo n, String ac) {
		if (n == null) {
			return ac;
		} else {
			ac += n.info + "\n";
			int esq = altura(n.esquerdo);
			int dir = altura(n.direito);
			if (esq > dir) {
				return desenhaAltura3(n.esquerdo, ac);
			} else {
				return desenhaAltura3(n.direito, ac);
			}
		}
	}

	List<String> nodos;

	public void niveisImpares() {
		for (int i = 0; i < altura(); i++) {
			nodos = new ArrayList<String>();
			preencheNivel(raiz, 0, i);
			System.out.println(nodos);
		}
	}

	private void preencheNivel(Nodo n, int ac, int nivel) {
		if (n != null) {
			preencheNivel(n.esquerdo, ac + 1, nivel);
			if (nivel == ac) {
				// System.out.printf("%s %d\n", n.info, nivel);
				nodos.add(n.info);
			}
			preencheNivel(n.direito, ac + 1, nivel);
		}
	}

	/**
	 * 
	 * @return
	 */
	public int total() {
		return total(raiz);
	}

	private int total(Nodo n) {
		if (n == null)
			return 0;
		return 1 + total(n.esquerdo) + total(n.direito);
	}

	/**
	 * 
	 * @param s
	 */
	public void caminho(String s) {
		caminho(raiz, s);
	}

	private void caminho(Nodo n, String s) {
		if (n == null) {
			throw new IllegalArgumentException("Informação inexistente!");
		}
		System.out.println(n.info);
		if (s.compareTo(n.info) < 0) {
			caminho(n.esquerdo, s);
		} else if (s.compareTo(n.info) > 0) {
			caminho(n.direito, s);
		}
	}

	/**
	 * 
	 * @param s
	 */
	public void caminhoAc(String s) {
		System.out.println(caminhoAc(raiz, s, ""));
	}

	private String caminhoAc(Nodo n, String s, String parcial) {
		if (n == null) {
			return "";
		}
		parcial += n.info;
		if (s.compareTo(n.info) < 0) {
			return caminhoAc(n.esquerdo, s, parcial);
		} else if (s.compareTo(n.info) > 0) {
			return caminhoAc(n.direito, s, parcial);
		}
		return parcial;
	}

	public void caminhoMaiorAltura(String s) {
		caminhoMaiorAltura(raiz, s);
	}

	private void caminhoMaiorAltura(Nodo n, String s) {
		if (n == null) {
			throw new IllegalArgumentException("Informação inexistente!");
		}
		if (s.compareTo(n.info) == 0) {
			// TODO
			// System.out.println("Achei!");
			// List<String> r = desenhaAlturaNão;
			// Collections.reverse(r);
			// System.out.println(r);
			desenhaAltura2(n);

		} else if (s.compareTo(n.info) < 0) {
			caminhoMaiorAltura(n.esquerdo, s);
		} else if (s.compareTo(n.info) > 0) {
			caminhoMaiorAltura(n.direito, s);
		}
	}



	/**
	 * @author Diego da Jornada
	 * 
	 * @return
	 */
	public int folhas() {

		// if(raiz == null) return 0;
		return folhasAux(raiz);
	}

	private int folhasAux(Nodo n) {
		if (n == null)
			return 0;
		if (n.direito == null && n.esquerdo == null) {
			return 1;
		}
		return folhasAux(n.direito) + folhasAux(n.esquerdo);
	}

	/**
 */
	public String pai(String s) {
		return paiAux(raiz, s, null);
	}

	/**
 */
	public String avo(String s) {
		String ps = pai(s);
		if (ps == null) {
			return null;
		}
		return pai(pai(s));
	}

	public String tio(String s) {
		return tio(raiz, s, null, null);
	}

	private String tio(Nodo n, String s, Nodo pai, Nodo avo) {
		if (n == null) {
			throw new IllegalArgumentException();
		}
		if (s.compareTo(n.info) < 0) {
			return tio(n.esquerdo, s, n, pai);
		} else if (s.compareTo(n.info) > 0) {
			return tio(n.direito, s, n, pai);
		} else {
			Nodo tio;
			if (avo == null) {
				throw new IllegalArgumentException();
			}
			if (avo.esquerdo == pai) {
				tio = avo.direito;
			} else {
				tio = avo.esquerdo;
			}
			if (tio == null) {
				return null;
			} else {
				return tio.info;
			}
		}
	}

	private String paiAux(Nodo n, String s, Nodo pai) {
		if (n == null) {
			throw new IllegalArgumentException();
		}
		if (s.compareTo(n.info) < 0) {
			return paiAux(n.esquerdo, s, n);
		} else if (s.compareTo(n.info) > 0) {
			return paiAux(n.direito, s, n);
		} else {
			return pai == null ? null : pai.info;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String desenhaArvoreA1() {
		return desenhaArvoreA1(raiz, 0);
	}

	private String desenhaArvoreA1(Nodo n, int ac) {
		if (n != null) {
			return String.format("%s%s\n%s%s", pad(ac), n.info,
					desenhaArvoreA1(n.direito, ac + 1),
					desenhaArvoreA1(n.esquerdo, ac + 1));
		}
		return "";
	}

	private String pad(int ac) {
		if (ac == 0)
			return "";
		if (ac == 1)
			return "+-";
		// FIXME: colocar mais barras para nível
		// acima de 2
		return "|.+-";
	}

	/**
	 * 
	 * @return
	 */
	public String desenhaArvoreA2() {
		System.out.println(altura());
		return desenhaArvoreA2(raiz);
	}

	private String desenhaArvoreA2(Nodo n) {
		if (n != null) {
			return String.format("%s%s%s\n", "..+---", n.info, "");
		}
		return "";
	}

}