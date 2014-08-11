package recursividade;

public class Sentence {
	private String text;

	/**
	 * Constructs a sentence.
	 * 
	 * @param aText
	 *            a string containing all characters of the sentence
	 */
	public Sentence(String aText) {
		text = aText;
	}

	/**
	 * Tests whether this sentence is a palindrome.
	 * 
	 * @return true if this sentence is a palindrome, false otherwise
	 */
	public boolean isPalindrome() {
		int length = text.length();
		// Separate case for shortest strings.
		if (length <= 1)
			return true;
		// Get first and last characters, converted to lowercase.
		char first = Character.toLowerCase(text.charAt(0));
		char last = Character.toLowerCase(text.charAt(length - 1));
		if (Character.isLetter(first) && Character.isLetter(last)) {
			// Both are letters.
			if (first == last) {
				// Remove both first and last character.
				Sentence shorter = new Sentence(text.substring(1, length - 1));
				return shorter.isPalindrome();
			} else {
				return false;
			}
		} else if (!Character.isLetter(last)) {
			// Remove last character.
			Sentence shorter = new Sentence(text.substring(0, length - 1));
			return shorter.isPalindrome();
		} else {
			// Remove first character.
			Sentence shorter = new Sentence(text.substring(1));
			return shorter.isPalindrome();
		}
	}

	public boolean isPalindrome(int start, int end) {
		// Caso separado para substrings de comprimento 0 e 1.
		if (start >= end)
			return true;
		// Converte o primeiro e o ultimo caractere em letras minusculas.
		char first = Character.toLowerCase(text.charAt(start));
		char last = Character.toLowerCase(text.charAt(end));
		if (Character.isLetter(first) && Character.isLetter(last)) {
			if (first == last) {
				// Testa substring que nao contem letras correspondentes.
				return isPalindrome(start + 1, end - 1);
			} else
				return false;
		} else if (!Character.isLetter(last)) {
			// Testa substring que nao contem ultimo caractere.
			return isPalindrome(start, end - 1);
		} else {
			// Testa substring que nao contem o primeiro caractere.
			return isPalindrome(start + 1, end);
		}
	}
	
	public boolean isPalindromeAux(){
		return isPalindrome(0, text.length() -1);
	}
}
