package leetcode;

import java.util.HashSet;

public class Prob5 {
	public static void main(String[] args) {
//		String s = "babad";
//		String s = "cbbd";
//		String s = "a";
//		String s = "ac";
//		String s = "lphbehiapswjudnbcossedgioawodnwdruaaxhbkwrxyzaxygmnjgwysafuqbmtzwdkihbwkrjefrsgjbrycembzzlwhxneiijgzidhngbmxwkhphoctpilgooitqbpjxhwrekiqupmlcvawaiposqttsdgzcsjqrmlgyvkkipfigttahljdhtksrozehkzgshekeaxezrswvtinyouomqybqsrtegwwqhqivgnyehpzrhgzckpnnpvajqevbzeksvbezoqygjtdouecnhpjibmsgmcqcgxwzlzztdneahixxhwwuehfsiqghgeunpxgvavqbqrelnvhnnyqnjqfysfltclzeoaletjfzskzvcdwhlbmwbdkxnyqappjzwlowslwcbbmcxoiqkjaqqwvkybimebapkorhfdzntodhpbhgmsspgkbetmgkqlolsltpulgsmyapgjeswazvhxedqsypejwuzlvegtusjcsoenrcmypexkjxyduohlvkhwbrtzjnarusbouwamazzejhnetfqbidalfomecehfmzqkhndpkxinzkpxvhwargbwvaeqbzdhxzmmeeozxxtzpylohvdwoqocvutcelgdsnmubyeeeufdaoznxpvdiwnkjliqtgcmvhilndcdelpnilszzerdcuokyhcxjuedjielvngarsgxkemvhlzuprywlypxeezaxoqfges";
//		String s = "";
		String s = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
//		String s = "abcda";
//		String s = "ccc";
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome(s));
	}
}

class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        if(s.equals("") || s.length() < 1)
			return "";
		String result = null;
		int start = 0;
		int end = 0;
		int len = 0;
		for (int i = 0; i < s.length(); i++) {
			int result1 = check(i, i, s);
			int result2 = check(i, i + 1, s);
			len = Math.max(result1, result2);
			if(len > end - start) {
				start = i - (len - 1 ) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end+1);
	}

	public int check(int left, int right, String s) {
		int l = left;
		int r = right;
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}
//	public String longestPalindrome(String s) {
//		if(s.equals(""))
//			return s;
//		String result = null;
//		boolean isChecked = false;
//		for (int i = 0; i < s.length(); i++) {
//			for (int j = i; j < s.length(); j++) {
//				if (i == j)
//					continue;
//				else {
//					isChecked = check(s, i, j);
//					if (isChecked) {
//						String temp = s.substring(i, j+1);
//						if(result == null)
//							result = temp;
//						else if(temp.length() > result.length())
//							result = temp;
//						System.out.println("i : " + i + ", j : " + j + ", result : " + result);
//					}
//				}
//			}
//		}
//		if (result == null)
//			result = s.charAt(0) + "";
//		return result;
//	}
//
//	public boolean check(String s, int i, int j) {
//		boolean result = false;
////		System.out.println("i : " + i + ", j : " + j);
//		if(i == j)
//			result = true;
//		else if(i == j-1) {
//			if(s.charAt(i) == s.charAt(j))
//				result = true;
//			else
//				result = false;
//		}
//		else {
//			if(s.charAt(i) == s.charAt(j))
//				result = check(s, i+1, j-1);
//			else
//				result =  false;
//		}
//		return result;
//	}
//	private HashSet<String> hs = new HashSet<String>();
//	public String longestPalindrome(String s) {
//		check(s, s);
//		return hs.toString();
//	}
//	public void check(String origin, String curr) {
//		if(curr.length() == 1) {
//			hs.add(origin);
//			return;
//		}
//		else if(curr.length() == 2) {
//			if(curr.charAt(0) == curr.charAt(1)) {
//				hs.add(origin);
//				return;
//			}
//			else {
//				hs.add(curr.charAt(0) + "");
//				return;
//			}
//		}
//		else if(hs.contains(origin) || hs.contains(curr))
//			return;
//		else {
//			if(curr.charAt(0) == curr.charAt(curr.length()-1)) {
////				System.out.println(origin);
//				check(origin, curr.substring(1, curr.length()-1));
//			}
//			else {
//				String temp;
//				temp = curr.substring(0, curr.length()-1);
//				check(temp, temp);
//				temp = curr.substring(1, curr.length());
//				check(temp, temp);
//			}
//		}
//	}

//	public String longestPalindrome(String s) {
//		StringBuilder sb = new StringBuilder(s);
//		StringBuilder sb2 = sb.reverse();
//		sb = new StringBuilder(s);
////		System.out.println("sb : " + sb.toString() + ", sb2 : " + sb2.toString());
//		int max = Integer.MIN_VALUE;
//		String result = "";
//		if(s.length() == 1)
//			result = s;
//		else if(sb.equals(sb2)) {
//			return sb.toString();
//		}
//		else {
//			for (int i = 0; i < s.length(); i++) {
//				for (int j = i+1; j < s.length(); j++) {
//					String origin = sb.substring(i, j+1);
//					String reverse = sb2.substring(s.length() - j - 1, s.length() - i);
////					System.out.println("origin : " + origin + ", reverse : " + reverse);
//					if (origin.equals(reverse)) {
//						if (max < origin.length()) {
//							max = origin.length();
//							result = origin;
//						}
//					}
//
//				}
//			}
//			if(s.length() > 1 && max == Integer.MIN_VALUE)
//				result = s.charAt(0) + "";
//		}
//		return result;
//	}
}