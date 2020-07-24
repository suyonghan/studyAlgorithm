package leetcode;

import java.util.HashSet;

public class Prob3 {
	public static void main(String[] args) {
		String a1 = "abcabcbb"; // output : 3, answer : abc
		String a2 = "bbbbb"; // output : 1, answer : b
		String a3 = "pwwkew"; // output : 3, answer : wke
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println("a1 : " + l.lengthOfLongestSubstring(a1));
		System.out.println("a2 : " + l.lengthOfLongestSubstring(a2));
		System.out.println("a3 : " + l.lengthOfLongestSubstring(a3));
	}
}

class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			String temp = "";
			HashSet<Character> hs = new HashSet<Character>();
			for (int j = i; j < s.length(); j++) {
				if(hs.contains(s.charAt(j)))
					break;
				else {
					hs.add(s.charAt(j));
					temp += s.charAt(j);
				}
			}
			result = Math.max(result, temp.length());
		}
		return result;
	}
}