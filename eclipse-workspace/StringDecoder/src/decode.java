
public class decode {
	public static String decode(String encoded) {
		StringBuilder reverse = new StringBuilder(encoded);
		String phrase = new String();
		reverse.reverse();
		while(reverse.length() != 0) {
			String charac = reverse.substring(0, 2);
			if(isValidChar(charac)) {
				int val = Integer.parseInt(charac);
				char addChar = (char)val;
				phrase = phrase + addChar;
				reverse.delete(0, 2);
			}
			else if(isValidChar(charac = reverse.substring(0,3))) {
				int val = Integer.parseInt(charac);
				char addChar = (char)val;
				phrase = phrase + addChar;
				reverse.delete(0, 3);
			}
		}
		return phrase;
	}

	public static boolean isValidChar(String charString) {
		int val = Integer.parseInt(charString);
		if (val >= 65 && val <= 90) {
			return true;
		} else if (val >= 97 && val <= 122) {
			return true;
		} else if (val == 32) {
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		String encode = "23511011501782351112179911801562340161171141148";
		String phrase = decode(encode);
		System.out.println(phrase);
	}
}
