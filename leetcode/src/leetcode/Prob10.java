package leetcode;

public class Prob10 {
	public static void main(String[] args) {

	}
}

class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
    	StringBuffer target = new StringBuffer(s);
    	StringBuffer src = new StringBuffer(p);
    	boolean result = false;
    	
    	if(!p.contains(".") && !p.contains("*")) {
    		if(src.length() != target.length())
    			result = false;
    		else if(!src.equals(target))
    			result = false;
    		else
    			result = true;
    	}
    	else {
    		for(int i = 0; i < target.length(); i++) {
    			if(target.charAt(i) == src.charAt(i))
    				continue;
    			else {
    				
    			}
    		}
    	}
    	return result;
    }
}