//¿ÏÀüÅ½»ö 1¹ø
package brute_force_search;

import java.util.LinkedList;

public class Prob1_MockExam {
	public int[] solution(int[] answers) {
		int[] answer;
		LinkedList<Integer> li = new LinkedList<>();
		int[] st1 = { 1, 2, 3, 4, 5 };
		int[] st2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] st3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		for (int i = 0; i < answers.length; i++) {
			if (st1[i1] == answers[i])
				r1++;
			if (st2[i2] == answers[i])
				r2++;
			if (st3[i3] == answers[i])
				r3++;
			
			i1++;
			i2++;
			i3++;

			if (i1 == st1.length)
				i1 = 0;
			if (i2 == st2.length)
				i2 = 0;
			if (i3 == st3.length)
				i3 = 0;
		}

		if (r1 == r2 && r2 == r3) {
			li.add(1);
			li.add(2);
			li.add(3);
		} else {
			if (r1 == r2 && r2 > r3) {
				li.add(1);
				li.add(2);
			} else if (r1 == r3 && r3 > r2) {
				li.add(1);
				li.add(3);
			} else if (r2 == r3 && r3 > r1) {
				li.add(2);
				li.add(3);
			} else {
				int temp = Math.max(Math.max(r1, r2), r3);
				if (r1 == temp) {
					li.add(1);
				} else if (r2 == temp) {
					li.add(2);
				} else {
					li.add(3);
				}
			}
		}
		answer = new int[li.size()];
		System.out.println(li);
		for (int i = 0; i < li.size(); i++) {
			answer[i] = li.get(i);
		}
		return answer;
	}
}
