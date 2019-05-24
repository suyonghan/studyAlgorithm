package dfs_bfs;

import java.util.ArrayList;

public class Prob1_TargetNumber {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int numbers[] = { 1, 1, 1, 1, 1 };
		System.out.println(s.solution(numbers, 3));
	}
}

class Solution1 {
	public int solution(int[] numbers, int target) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int answer = 0;
		int count;

		arr.add(numbers[0]);
		arr.add(-numbers[0]);
		for (int i = 1; i < numbers.length; i++) {
			count = arr.size();
//			System.out.println("level : " + i + "  size : " + arr.size());
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < count; j++) {
//				System.out.print(arr.get(j) + " ");
				temp.add(numbers[i] + arr.get(j));
				temp.add(-numbers[i] + arr.get(j));
			}
//			System.out.println();
			arr = temp;
		}

		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == target)
				answer++;
		}
			
		return answer;
	}
}