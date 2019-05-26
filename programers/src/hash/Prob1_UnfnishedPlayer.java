//Hash 1번문제

package hash;

import java.util.HashMap;
import java.util.*;

public class Prob1_UnfnishedPlayer {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		// 참여자 배열과 그렇지 못한 자 배열의 비교
		// 동일인이 몇명인지
		String list = "";

		for (int i = 0; i < completion.length; i++) {
			list = list + " " + completion[i];
		}

		for (int i = 0; i < participant.length; i++) {
			if (list.contains(participant[i])) {
				list = list.replace(participant[i], "");
			}

			else {
				answer = participant[i];
				break;
			}
		}
		return answer;
	}

	public String solution1(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}

	public String solution2(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		int i;
		for (i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[i];
	}
}
