// 정렬1번문제

package sort;

import java.util.Arrays;
import java.util.LinkedList;

public class Prob1_Kth {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		LinkedList<Integer> li = new LinkedList<>();
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int size = end - start;
			int temp[] = new int[size + 1];
			int k = 0;
			for (int j = start - 1; j < end; j++) {
				temp[k] = array[j];
				if (k < size)
					k++;
			}
			Arrays.sort(temp);
//			System.out.print("after : ");
//			for(int j = 0; j < temp.length; j++) {
//				System.out.print(temp[j]);
//			}
//			System.out.println(commands[i][2]);
			li.add(temp[commands[i][2]-1]);
		}
		answer = new int[li.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = li.get(i);

		return answer;
	}
}
