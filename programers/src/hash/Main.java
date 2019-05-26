package hash;

import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
//		Solution s = new Solution();
//		String[] participant1 = {"leo", "kiki", "eden"};
//		String[] completion1 = {"eden", "kiki"};
//		System.out.println(s.solution(participant1, completion1));
//		
//		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
//		System.out.println(s.solution(participant2, completion2));
//		
//		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
//		String[] completion3 = {"stanko", "ana", "mislav"};
//		System.out.println(s.solution(participant3, completion3));

//		Solution2 s2 = new Solution2();
//		String[] phone_book = 	{"113", "12340", "123440", "12345", "98346"};
//		s2.solution(phone_book);
		
		TreeMap<Integer, String> tm = new TreeMap<>();
		tm.put(5, "b");
		tm.put(5, "a");
		tm.put(3, "c");
		tm.put(2, "c");
		tm.put(1, "f");
		tm.put(100, "g");
		System.out.println(tm.keySet());
		System.out.println(tm.values());
		
	}
}
