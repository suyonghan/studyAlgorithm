//Hash 2¹ø¹®Á¦

package level2;

class Country124Number {
	public String solution(int n) {
		String answer = "";
		while( n != 0) {
			if(n % 3 == 0) {
				answer = "4" + answer;
                n = n/3-1;
			}
			else {
				answer = Integer.toString(n % 3) + answer;
				n = n / 3;
			}
		}
		return answer;
	}
}