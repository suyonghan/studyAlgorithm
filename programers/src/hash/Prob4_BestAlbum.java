package hash;

import java.util.HashMap;
import java.util.TreeMap;

public class Prob4_BestAlbum {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		HashMap<String, Integer> countMap = new HashMap<>();
		TreeMap<Integer, Integer> playsMap = new TreeMap<>();
		TreeMap<Integer, String> genresMap = new TreeMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (countMap.containsKey(genres[i]))
				countMap.put(genres[i], plays[i] + countMap.get(genres[i]));
			else
				countMap.put(genres[i], plays[i]);
			playsMap.put(plays[i], i);
			genresMap.put(i, genres[i]);
		}

		//장르별 순서정하기
		TreeMap<Integer, String> orderMap = new TreeMap<>();
		for (String key : countMap.keySet())
			orderMap.put(countMap.get(key), key);

		//트리맵을 통해 2개 또는 1개값을 가져오기
		int[] temp = new int[orderMap.size() * 2];
		
		return answer;
	}
}
