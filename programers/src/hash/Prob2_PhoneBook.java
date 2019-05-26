//Hash 2¹ø¹®Á¦

package hash;

import java.util.Arrays;

public class Prob2_PhoneBook {
	public boolean solution(String[] phone_book) {
		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				if (phone_book[i].startsWith(phone_book[j]))
					return false;
				if (phone_book[j].startsWith(phone_book[i]))
					return false;
			}
		}
		return true;
	}

	public boolean solution2(String[] phone_book) {
		Arrays.sort(phone_book);
		boolean result = true;
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].contains(phone_book[i])) {
				result = false;
				break;
			}
		}
		return result;
	}
}
