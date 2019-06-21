package sss;

public class Prob2_MaxNumber {
	public static void main(String[] args) {
		SolutionNumber s = new SolutionNumber();
		System.out.println(s.solution("1924", 2));
		System.out.println(s.solution("1231234", 3));
		System.out.println(s.solution("4199252841", 3));
	}
}

class SolutionNumber {
	String result = "";

	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder(number);
		findMax(answer, 0, k);
		findMax1(number, 0, k);
		return this.result;
	}

	public void findMax(StringBuilder s, int depth, int k) {
		if (depth == k) {
			result = s.toString();
			return;
		}
		StringBuilder num = new StringBuilder(s.toString());
		long max = -1;
		long temp;
		for (int i = 0; i < s.length(); i++) {
			temp = Long.parseLong((num.delete(i, i + 1).toString()));
			if (max < temp) {
				max = temp;
			}
			num = new StringBuilder(s.toString());
		}
		findMax(new StringBuilder(Long.toString(max)), depth + 1, k);
	}

	public void findMax1(String s, int depth, int k) {
		while (depth != k) {
			long max = -1;
			for (int i = 0; i < s.length(); i++) {
				String temp;
				if (i == 0)
					temp = s.substring(1);
				else if (i == s.length() - 1)
					temp = s.substring(0, i);
				else
					temp = s.substring(0, i) + s.substring(i + 1);
				max = Math.max(max, Long.parseLong(temp));

			}
			depth++;
			s = Long.toString(max);
		}
		result = s;
	}
}