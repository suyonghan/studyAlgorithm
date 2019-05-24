package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Prob6_StockPrice {
	public int[] solution(int[] prices) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] answer = new int[prices.length];
		for (int i : prices) {
			q.offer(i);
		}

		for (int a = 0; a < prices.length - 1; a++) {
			boolean check = false;
			int time = 0;
			int price = q.peek();
			q.poll();
			int i;
			for (i = 0; i < q.size(); i++) {
				if (q.peek() - price < 0) {
					answer[a] = ++time;
					check = true;
					break;
				} else {
					q.offer(q.poll());
					time++;
				}
			}

			if (!check)
				answer[a] = time;
			else {
				for (int j = 0; j < i; j++) {
					q.offer(q.poll());
				}
			}

		}

		for (int i = 0; i < prices.length; i++) {
			System.out.print(answer[i]);
		}
		System.out.println();
		return answer;
	}

	public int[] solution1(int[] prices) {
		int[] temp = new int[prices.length];
		int[] answer = null;
		for (int i = 0; i < prices.length - 1; i++) {
			temp[i] = prices[i + 1] - prices[i];
		}

		int total = 0;
		for (int i = prices.length - 1; i > -1; i++) {
			int j = 0;
			total += temp[i];
			if (total > 0) {
				answer[i] = j;
				j++;
			}
			else {
				answer[i] = j;
				j++;
			}
		}
		return answer;
	}
}
