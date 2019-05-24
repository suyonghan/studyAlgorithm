package stack_queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Prob4_FuncDevelpment {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] result = null;
		int[] day = new int[progresses.length];
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < progresses.length; i++) {
			if ((100 - progresses[i]) % speeds[i] == 0)
				day[i] = (100 - progresses[i]) / speeds[i];
			else
				day[i] = ((100 - progresses[i]) / speeds[i]) + 1;
			;
		}

		for (int i : day) {
			if (q.isEmpty()) {
				q.offer(i);
				hm.put(i, 1);
			} else {
				Boolean check = false;
				int j;
				for (j = 0; j < q.size(); j++) {
					if (i <= q.peek()) {
						hm.put(q.peek(), hm.get(q.peek()) + 1);
						check = true;
						break;
					}
					q.offer(q.peek());
					q.poll();
				}
				
				if(!check) {
					q.offer(i);
					hm.put(i, 1);
				}
				else {
					for(; j < q.size(); j++) {
						q.offer(q.peek());
						q.poll();
					}
				}
			}
		}
		result = new int[hm.size()];
		System.out.println(hm.keySet());
		System.out.println(hm.values());

		for(int i = 0; i < hm.size(); i++) {
			result[i] = hm.get(q.peek());
			q.poll();
		}

		return result;
	}
}
