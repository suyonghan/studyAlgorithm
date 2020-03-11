//StackQueue 2¹ø¹®Á¦

package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Prob2_Printer {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int p : priorities)
			q.offer(p);

		while (!q.isEmpty()) {
			System.out.print(q);
			int item = q.poll();
			System.out.print("     item : " + item);
			boolean check = true;
			for (int s : q) {
				if (item < s) {
					check = false;
				}
			}

			if (check) {
				answer++;
				if (location == 0)
					return answer;
			} else
				q.offer(item);
			location--;
			System.out.print("   check : " + check + "   before-location : " + location);
			if (location < 0)
				location += q.size();
			System.out.print("     after-location : " + location + "    answer : " + answer);
			System.out.println();
		}

		return answer;
	}

}
