package leetcode;

public class Prob8 {
	public static void main(String[] args) {
		StringToInteger s = new StringToInteger();
		String str1 = "42"; // #output : 42
		String str2 = "   -42"; // #output : -42
		String str3 = "4193 with words"; // #output : 4193
		String str4 = "words and 987"; // #output : 0
		String str5 = "-91283472332"; // #output : -2147483648
		String str6 = "  -1";
		String str7 = "  c-1";
		String str8 = "  -c1";
		String str9 = "3.141592";
		String str10 = "-";
		String str11 = "+1";
		String str12 = "  0000000000012345678";
		String str13 = "+-2";
		String str14 = "words and 987";
		String str15 = "0-1";
		String str16 = "-5-";
		String str17 = "  +004500";
		String str18 = "1a";
		String str19 = "    0000000000000   ";
		String str20 = "-000000000000001";
		String str21 = "  -0012a42";
//		System.out.println("1 : " + s.myAtoi(str1));
//		System.out.println("2 : " + s.myAtoi(str2));
//		System.out.println("3 : " + s.myAtoi(str3));
//		System.out.println("4 : " + s.myAtoi(str4));
//		System.out.println("5 : " + s.myAtoi(str5));
//		System.out.println("6 : " + s.myAtoi(str6));
//		System.out.println("7 : " + s.myAtoi(str7));
//		System.out.println("8 : " + s.myAtoi(str8));
//		System.out.println("9 : " + s.myAtoi(str9));
//		System.out.println("10 : " + s.myAtoi(str10));
//		System.out.println("11 : " + s.myAtoi(str11));
//		System.out.println("12 : " + s.myAtoi(str12));
//		System.out.println("13 : " + s.myAtoi(str13));
//		System.out.println("14 : " + s.myAtoi(str14));
		System.out.println("15 : " + s.myAtoi(str15));
//		System.out.println("16 : " + s.myAtoi(str16));
//		System.out.println("17 : " + s.myAtoi(str17));
//		System.out.println("18 : " + s.myAtoi(str18));
//		System.out.println("19 : " + s.myAtoi(str19));
//		System.out.println("20 : " + s.myAtoi(str20));
//		System.out.println("21 : " + s.myAtoi(str21));
//		System.out.println("22 : " + s.myAtoi("-+1"));
		System.out.println("22 : " + s.myAtoi("    +1146905820n1"));
	}
}

class StringToInteger {
	public int myAtoi(String str) {
		int result = 0;
		String s = str.trim();
		try {
			if (s == null || s.equals(""))
				result = 0;
			else if(s.length() == 1 && !Character.isDigit(s.charAt(0)))
				result = 0;
			else {
				for(int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					if(!Character.isDigit(c) && c != '-' && c != '+') {
						s = s.substring(0, i);
						break;
					}
					for (int j = i+1; j < s.length(); j++) {
						char cc = s.charAt(j);
						if(!Character.isDigit(c) && !Character.isDigit(cc)) {
							s = s.substring(0, j);
						}
						else if(Character.isDigit(c) && !Character.isDigit(cc)) {
							s = s.substring(0, j);
						}
					}
				}
				System.out.println(s);
				if(!s.equals("")) {
					int i = 0;
					while(s.charAt(i) == '0') {
						if(s.length() > 1)
							s = s.substring(1);
						else
							break;
					}
					String min = Integer.toString(Integer.MIN_VALUE);
					String max = Integer.toString(Integer.MAX_VALUE);
					if(s.charAt(0) == '-') {
						int k = 1;
						while(s.charAt(k) == '0' && s.length() > 1) {
							s = s.substring(1);
						}
						if(s.charAt(0) == '0')
							s = "-" + s.substring(1);
						if(s.length() > 11)
							result = Integer.MIN_VALUE;
						else if (s.length() == 11) {
							boolean check = false;
							for(int j = 1; j<s.length(); j++) {
								if(min.charAt(j) > s.charAt(j))
									break;
								if(min.charAt(j) < s.charAt(j)) {
									check = true;
									break;
								}
								else
									continue;
							}
							if(!check)
								result = Integer.parseInt(s);
							else
								result = Integer.MIN_VALUE;	
						}
						else
							result = Integer.parseInt(s);		
					}
					else {
						s = s.replace("+", "");
						int k = 0;
						while(s.charAt(k) == '0') {
							if(s.length() > 1)
								s = s.substring(1);
							else
								break;
						}
						if(s.length() > 10)
							result = Integer.MAX_VALUE;
						else if (s.length() == 10) {
							boolean check = false;
							for(int j = 0; j < s.length(); j++) {
								if(max.charAt(j) > s.charAt(j)) {
									break;	
								}
								if(max.charAt(j) < s.charAt(j)) {
									check = true;
									break;
								}
								else
									continue;
							}
							if(!check)
								result = Integer.parseInt(s);
							else
								result = Integer.MAX_VALUE;	
						}
						else {
							s = s.replace("+", "");
							if(!s.equals(""))
								result = Integer.parseInt(s);	
							else
								result = 0;
						}
					}
				}
				else
					result = 0;
			}	
		}
		catch (Exception e) {
			result = 0;
		}
		return 	result;
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