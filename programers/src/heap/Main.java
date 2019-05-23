package heap;

public class Main {
	public static void main(String[] args) {
//		Solution s = new Solution();
//		int[] scoville = { 1, 2, 3, 9, 10, 12 };
//		int K = 7;
//		System.out.println(s.solution(scoville, K));
		
		Solution2 s = new Solution2();
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		System.out.println(s.solution(stock, dates, supplies, k));
		
	}
}
