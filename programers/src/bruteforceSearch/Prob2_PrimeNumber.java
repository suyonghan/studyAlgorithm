package sss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Prob2_PrimeNumber {
	public static void main(String[] args) {
		SolutionP2 s = new SolutionP2();
		s.solution("17");
	}
}

class SolutionP2 {
	HashSet<Integer> hs = new HashSet<Integer>();

	public int solution(String numbers) {
		int answer = 0;
		char[] ch = numbers.toCharArray();
		Arrays.sort(ch);
		String maxValue = "";
		for (int i = numbers.length() - 1; i > -1; i--) {
			maxValue += String.valueOf(numbers.charAt(i));
		}
		boolean[] check = new boolean[numbers.length()];
		permutation(numbers, "", check, 0);

		for (int i : hs) {
			if (checkPrimeNo(i))
				answer++;
		}
		System.out.println(hs);
		System.out.println(answer);
		return answer;
	}

	void permutation(String numbers, String n, boolean[] check, int count) {
		if (count == numbers.length()) {
			return;
		} else {
			if (count == 0) {
				for (int i = 0; i < numbers.length(); i++) {
					String temp = String.valueOf(numbers.charAt(i));
					if (temp.equals("0"))
						continue;
					else {
						check[i] = true;
						permutation(numbers, n + temp, check, count + 1);
						check[i] = false;
						hs.add(Integer.parseInt(temp));
					}
				}
			} else {
				for (int i = 0; i < numbers.length(); i++) {
					if (!check[i]) {
						check[i] = true;
						String temp = n + String.valueOf(numbers.charAt(i));
						permutation(numbers, temp, check, count + 1);
						check[i] = false;
						hs.add(Integer.parseInt(temp));
					}
				}
			}
		}
	}

	ArrayList<Integer> eratosthenes(int n) {
		boolean[] era = new boolean[n + 1];
		for (int i = 2; i < era.length; i++) {
			if (!era[i]) {
				for (int j = i * i; j < era.length; j += i) {
					era[j] = true;
				}
			}
		}
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		for (int i = 2; i < era.length; i++) {
			if (!era[i])
				primeList.add(i);
		}
		return primeList;
	}

	boolean checkPrimeNo(int n) {
		boolean check = true;
		if (n == 1)
			return false;
		for (int i = 2; i < Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				check = false;
				break;
			}
		}
		return check;
	}
}
