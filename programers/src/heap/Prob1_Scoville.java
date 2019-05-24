package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Prob1_Scoville {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		Arrays.sort(scoville);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i : scoville) {
			if (i < K) {
				pq.add(i);
			}
		}

		while (!pq.isEmpty()) {
			int a = pq.poll();
			int b;
			if (pq.isEmpty()) {
				return -1;
			} else {
				b = pq.poll();
				if (a + (2 * b) < K) {
					pq.offer(a + (2 * b));
					pq.comparator();
				}
				answer++;
			}
		}
		return answer;
	}

	public int solution1(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++)
			q.add(scoville[i]);

		int count = 0;
		while (q.size() > 1 && q.peek() < K) {
			int weakHot = q.poll();
			int secondWeakHot = q.poll();

			int mixHot = weakHot + (secondWeakHot * 2);
			q.add(mixHot);
			count++;
		}

		if (q.size() <= 1 && q.peek() < K)
			count = -1;

		return count;
	}

}
