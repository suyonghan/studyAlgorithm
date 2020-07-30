package leetcode;

public class Prob8 {
	public static void main(String[] args) {
		StringToInteger s = new StringToInteger();
//		String str = "42"; //#output : 42
//		String str = "   -42"; // #output : -42
//		String str = "4193 with words"; //#output : 4193
//		String str = "words and 987"; // #output : 0
//		String str = "-91283472332"; //#output : -2147483648
//		String str = "  -1";
//		String str = "  c-1";
//		String str = "  -c1";
//		String str = "3.141592";
//		String str = "-";
//		String str = "+1";
//		String str = "  0000000000012345678";
//		String str = "+-2";
//		String str = "words and 987";
//		String str = "0-1";
		String str = "-5-";
		System.out.println(s.myAtoi(str));
	}
}

class StringToInteger {
	public int myAtoi(String str) {
		int result = 0;
		str = str.trim();
		if (str == null || str.equals(""))
			result = 0;
		else if (str.length() == 1) {
			if (Character.isDigit(str.charAt(0)))
				result = Integer.parseInt(str);
			else
				result = 0;
		} 
		else if(str.length() == 2) {
			str = str.replace("+", "");
			try {
				result = Integer.parseInt(str);
			} catch (Exception e) {
				result = 0;
			}
		}
		else {
			char first = str.charAt(0);
			char last = str.charAt(str.length() - 1);
			if (!Character.isDigit(last)) {
				last = ' ';
			}
			for (int i = 1; i < str.length() - 1; i++) {
				
			}
		}
		return result;
	}
}

/*
 * Implement atoi which converts a string to an integer. The function first
 * discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes
 * an optional initial plus or minus sign followed by as many numerical digits
 * as possible, and interprets them as a numerical value. The string can contain
 * additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function. If the first
 * sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only
 * whitespace characters, no conversion is performed. If no valid conversion
 * could be performed, a zero value is returned.
 */