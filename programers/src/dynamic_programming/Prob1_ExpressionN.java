package dynamic_programming;

import java.util.HashMap;

public class Prob1_ExpressionN {
	public static void main(String[] args) {

	}
}

class Solution {
	HashMap<String, Integer> hm;

	public Solution() {
		// TODO Auto-generated constructor stub
		hm = new HashMap<String, Integer>();
	}

	public int solution(int N, int number) {
		int answer = 0;
		if (N == number)
			return 1;
		else {
			int count = 1;
			hm.put(Integer.toString(N), N);
			while (count < 10) {
//				if(!hm.containsKey(key)
			}
			if (answer > 8)
				return -1;
			else
				return answer;
		}
	}
}