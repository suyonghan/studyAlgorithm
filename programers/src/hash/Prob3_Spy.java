//Hash 3¹ø¹®Á¦

package hash;

import java.util.HashMap;

public class Prob3_Spy {
	public int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> hm = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			if (hm.containsKey(clothes[i][1]))
				hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
			else {
				hm.put(clothes[i][1], 1);
			}
		}

		int count = 1;
		answer = clothes.length;
		for (String key : hm.keySet()) {
			count = (hm.get(key) + 1) * count;
		}
		answer = count -1;
		
		return answer;
	}
}
