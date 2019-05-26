package sort;

public class Main {
	public static void main(String[] args) {
//		Solution s = new Solution();
//		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
//		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
//		s.solution(array, commands);

//		Solution2 s2 = new Solution2();
//		int numbers[] = { 6, 10, 2 };
//		int numbers2[] = { 3, 30, 34, 5, 9 };
//		System.out.println(s2.solution(numbers));
//		System.out.println(s2.solution(numbers2));

		Prob3_HIndex s3 = new Prob3_HIndex();
		int[] citations = { 3, 0, 6, 1, 5 };
		int[] citations2 = { 1, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7, 8, 8, 9, 9, 10, 10, 10 };
		System.out.println(s3.solution(citations));
		System.out.println(s3.solution(citations2));
	}
}
