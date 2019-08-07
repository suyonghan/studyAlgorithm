package sss;

public class Prob2_MaxNumber {
	public static void main(String[] args) {
		SolutionNumber s = new SolutionNumber();
		System.out.println(s.solution("1924", 2));
		System.out.println(s.solution("1231234", 3));
		System.out.println(s.solution("4199252841", 3));
	}
}

class Solution {
	public String solution(String number, int k) {
		StringBuffer answer = new StringBuffer("");
		int max = -1;
		int current = max;
		for (int i = 0; i < number.length(); i++) {
			max = Math.max(number.charAt(i) - '0', max);
		}
		String curr = number;
		while (k > 0) {
			loop: for (int curr_max = max; curr_max > -1; curr_max--) {
				for (int i = 0; i < curr.length(); i++) {
					if (curr.charAt(i) - '0' == curr_max) {
						if(curr.length() == k) {
							return answer.toString();
						}
//						print(answer.toString(), curr_max, k, curr);
						if (k > i) {
							answer.append(curr.charAt(i));
							curr = curr.substring(i + 1);
							k -= i;
							break loop;
						} else if (k == i) {
							answer.append(curr.substring(i));
							k = 0;
							break loop;
						}
					}
//					print(answer.toString(), curr_max, k, curr);
				}
			}
		}
		return answer.toString();
    }
}