package greedy;

import java.util.Arrays;

class Solution1 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		int j = -1;
		Arrays.sort(people);
//		print(people);
		for (int i = people.length - 1; i > j; i--) {
//			System.out.println("i : " + i + ", j : " + j);
			if (people[i] < limit) {
				if (people[i] + people[j+1] <= limit) {
					j++;
				} answer++;
			} else {
				answer++;
			}
		}
//		if (people.length % 2 == 1)
//			answer += 1;
		return answer;
    }
}