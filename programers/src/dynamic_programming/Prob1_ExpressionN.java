package dynamic_programming;

public class Prob1_ExpressionN {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(5, 12));
		Solution s1 = new Solution();
//		System.out.println(s1.solution(2, 11));
//		Solution s2 = new Solution();
//		System.out.println(s2.solution(5, 31168));
//		Solution s3 = new Solution();
//		System.out.println(s3.solution(5, 24));
//		Solution s4 = new Solution();
//		System.out.println(s4.solution(5, 26));
	}
}

class Solution {
	int min;

	public Solution() {
		min = Integer.MAX_VALUE;

	}

	public int solution(int N, int number) {
		search(N, number, 0, 0);
		if (min == Integer.MAX_VALUE)
			min = -1;
		return min;
	}

	public void search(int N, int target, int count, int current) {
		int temp = N;
		if (count > 8) {
			return;
		} else if (target == current) {
			this.min = Math.min(min, count);
			return;
		} else {
			for (int i = 0; i < 8 - count; i++) {
				search(N, target, count + i + 1, current + temp);
				search(N, target, count + i + 1, current - temp);
				search(N, target, count + i + 1, current * temp);
				search(N, target, count + i + 1, current / temp);
				search(N, target, count + i + 1, N - current);
				temp = temp * 10 + N;
			}
		}
	}

}
