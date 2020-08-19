package leetcode;

import java.util.HashSet;

public class Prob10 {
	public static void main(String[] args) {

	}
}

class RegularExpressionMatching {
	HashSet<String> hs = new HashSet<String>();
	public boolean isMatch(String s, String p) {
    	String src = s;
    	String target = p;
    	boolean result = false;
    	
    	if(!target.contains(".") && !target.contains("*")) {
    		if(src.length() != target.length())
    			result = false;
    		else if(!src.equals(target))
    			result = false;
    		else
    			result = true;
    	}
    	else {

    	}
    	return result;
    }
	
	public void save(int index, String target) {
		if(index == target.length()) {
			hs.add(target.toString());
		}
		else {
			for(int i = index; i < target.length(); i++) {
				if(target.charAt(i) == '*') {
					StringBuffer temp = new StringBuffer(target);
					System.out.println("replace 1: " + temp);
					temp.replace(i, i, target.charAt(i-1)+"");
					System.out.println("replace 2: " + temp);
					save(i+1, temp.toString());
					temp.delete(i-1, i);
					System.out.println("replace 3: " + temp);
					save(i+1, temp.toString());
				}
			}
		}
	}
}

//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.

//Example 1:
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
//
//Example 2:
//Input:
//s = "aa"
//p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//
//Example 3:
//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
//
//Example 4:
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
//
//Example 5:
//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false