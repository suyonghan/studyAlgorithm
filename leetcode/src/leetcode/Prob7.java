package leetcode;

public class Prob7 {
	public static void main(String[] args) {
//		int x = 123; // #Output: 321
//		int x = -123; // #Output: -321
//		int x = 120; // #Output: 21
//		int x = 1534236469; //#output : 0
//		int x = -2147483412; //#output : -2143847412
		int x = -2147483648;
				
		ReverseInteger r = new ReverseInteger();
		System.out.println("min : " + Integer.MIN_VALUE);
		System.out.println("max : " + Integer.MAX_VALUE);
		System.out.println("result : " +r.reverse(x));
//		System.out.println(2147483412);
//		System.out.println(2134847412);
	}
}

//Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
//[−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

class ReverseInteger {
	public int reverse(int x) {
		if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE)
			return 0;
		boolean ischecked =  x < 0;
		int xx;
		if(ischecked)
			xx = -x;
		else
			xx = x;
		String temp = new StringBuffer(Integer.toString(xx)).reverse().toString();
		if(temp.length() == 10) {
			String max = Integer.toString(Integer.MAX_VALUE);
			for(int i = 0; i < temp.length(); i++) {
				if(max.charAt(i) < temp.charAt(i)) {
					xx = 0;
					break;
				}
				else if(max.charAt(i) > temp.charAt(i))
					break;
			}
		}
		if(xx != 0) {
			if(ischecked)
				xx = -Integer.parseInt(temp);
			else
				xx = Integer.parseInt(temp);	
		}
		return xx;
	}
}


