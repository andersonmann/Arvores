package recursividade;

public class Palindromo {

	public static void main(String[] args) {
		System.out.println(reverseIterative("Subi no ônibus"));
	}

	private static String reverseIterative(String s) {
		String r = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			r += s.charAt(i);
		}
		return r;
	}

	private static String reverse(String s) {
		if (s.isEmpty()) {
			return "";
		}
		return "" + s.charAt(s.length() - 1)
				+ reverse(s.substring(0, s.length() - 1));

	}

	private static boolean isPalindromeIndex(String s) {
		return isPalindrome(0, s);
	}

	/**
	 * 
	 * @param s
	 *            o texto a ser verificado (s != null)
	 * @return true se s é um palindromo
	 */
	private static boolean isPalindrome(String s) {
		assert s != null;
		if (s.isEmpty()) {
			return true;
		}
		if (s.length() == 1) {
			return true;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			String novoTexto = s.substring(1, s.length() - 1);
			return isPalindrome(novoTexto);
		}
		return false;
	}

	private static boolean isPalindrome(int i, String s) {
		assert s != null;
		if (s.length() / 2 == i) {
			return true;
		}
		char first = s.charAt(i);
		char last = s.charAt((s.length() - i) - 1);
		if (first == last) {
			return isPalindrome(i + 1, s);
		}
		return false;
	}
}
