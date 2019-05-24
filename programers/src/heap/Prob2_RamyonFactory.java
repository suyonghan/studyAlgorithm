package heap;

public class Prob2_RamyonFactory {
	public int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		int start_index = 0;

		if (stock >= k)
			return 0;

		while (true) {
			int max = 0;
			int max_index = 0;
			for (int i = start_index; i < dates.length; i++) {
				if (dates[i] < stock) {
					int temp = supplies[i] - stock + dates[i];
					if (max < temp) {
						max_index = i;
						max = temp;
					}
				}
			}
			stock += max;
			start_index = max_index;
			answer++;
			System.out.println("start_index : " + start_index);
			System.out.println("stock : " + stock);
			System.out.println("answer : " + answer);
			if (k <= stock)
				break;	
		}
		return answer;
	}
}
