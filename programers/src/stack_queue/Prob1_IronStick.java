//StackQueue 1������

package stack_queue;

import java.util.Stack;

public class Prob1_IronStick {
	public int solution(String arrangement) {
		int answer = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '(') {
				st.push(i);
			} else if (arrangement.charAt(i) == ')') {
				if (st.peek() + 1 == i) {
					st.pop();
					answer += st.size();
				} else {
					st.pop();
					answer += 1;
				}
			}
			System.out.println(answer);
		}
		return answer;
	}
}
