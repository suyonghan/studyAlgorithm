package dynamic_programming;

public class Prob2_TileDecoration {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.solution(80));
	}
}

class Solution1 {
	public long solution(int N) {
		long answer = 0;
		long a = 1, b = 1;
		if (N == 1)
			return 4;
		else if (N == 2)
			return 6;
		else {
			long tmp;
			for (int i = 2; i < N; i++) {
				tmp = a;
				a = a + b;
				b = tmp;
			}

		}
		answer = 4 * a + 2 * b;
		return answer;
	}
}
