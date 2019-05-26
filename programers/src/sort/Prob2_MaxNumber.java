// 정렬2번문제

package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Prob2_MaxNumber {
	public String solution(int[] numbers) {
		String answer = "";
		String[] s = new String[numbers.length];
		for (int i = 0; i < s.length; i++) {
			s[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(s, new MyComp());
		if (s[0].equals("0"))
			answer += "0";
		else {
			for (int i = 0; i < s.length; i++) {
				answer += s[i];
			}
		}
		return answer;
	}

	class MyComp implements Comparator<String> {
		public int compare(String o1, String o2) {
			return (o2 + o1).compareTo(o1 + o2);
		}
	}
}
