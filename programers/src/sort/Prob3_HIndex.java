//Á¤·Ä 3¹ø

package sort;

import java.util.Arrays;

public class Prob3_HIndex {
	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		int temp = 0;

		for (int i = 0; i < citations.length; i++) {
			int smaller = Math.min(citations[i], citations.length - i);
			answer = Math.max(answer, smaller);
		}
		return answer;
	}
}
