//StackQueue 5번문제

package stack_queue;

import java.util.Stack;

public class Prob5_Top {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		for (int i : heights) {
			s.add(i);
		}

		for (int i = heights.length - 1; i > 0; i--) {
			int temp = s.peek();
			s.pop();
			int j;
			for (j = s.size()-1; j > -1; j--) {
				if (temp >= s.peek()) {
					s2.add(s.pop());
				} // 같거나 작은 경우
				else {
					answer[i] = j+1;
					break;
				} // 큰 경우
			}

			while (!s2.isEmpty()) {
				s.add(s2.pop());
			}
		}

	
		for (int i = 0; i < heights.length; i++) {
			System.out.print(answer[i]);
		}
		System.out.println();
		return answer;
	}
}
