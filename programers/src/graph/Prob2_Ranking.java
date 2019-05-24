package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Prob2_Ranking {
	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 8;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		System.out.println(s.solution(n, results));
	}
}

class Solution {
	HashMap<Integer, Integer> hm;

	public Solution() {
		hm = new HashMap<Integer, Integer>();
	}

	public int solution(int n, int[][] results) {
		int answer = 0;
		if (results.length == 1)
			answer = 1;
		else {
			Player[] players = new Player[n + 1];
			for (int i = 0; i < n + 1; i++) {
				players[i] = new Player();
			}
			for (int i = 0; i < results.length; i++) {
				players[results[i][1]].winner.addLast(results[i][0]);
				players[results[i][0]].loser.addLast(results[i][1]);
			}

//			printPlayerInfo(players);
			int maxInfoPlayer = 0;
			for (int i = 1; i < players.length; i++) {
				if (players[maxInfoPlayer].loser.size() + players[maxInfoPlayer].winner.size() < players[i].loser.size()
						+ players[i].winner.size())
					maxInfoPlayer = i;
			}
			hm.put(maxInfoPlayer, 0);
			setRanking(players, maxInfoPlayer, 0);
			answer = findGrade();
		}
		return answer;
	}

	public void setRanking(Player[] players, int current_player, int result) {
		players[current_player].isCheck = true;
		for (int i : players[current_player].loser) {
			if (!hm.containsKey(i)) {
				hm.put(i, result - 1);
			}
		}
		for (int i : players[current_player].winner) {
			if (!hm.containsKey(i)) {
				hm.put(i, result + 1);
			}
		}
		for (int i : players[current_player].loser) {
			if (!players[i].isCheck)
				setRanking(players, i, result - 1);
		}
		for (int i : players[current_player].winner) {
			if (!players[i].isCheck)
				setRanking(players, i, result + 1);
		}
	}

	public void printPlayerInfo(Player[] players) {
		for (int i = 1; i < players.length; i++) {
			System.out.print(i);
			System.out.print("플레이어 참여여부 : " + players[i].isCheck);
			System.out.print(", 진사람 명단" + players[i].winner.toString());
			System.out.println(", 이긴사람  명단" + players[i].loser.toString());
		}
	}

	public int findGrade() {
		int result = 0;
		int[] arr = new int[hm.values().size()];
		int i = 0;
		for (int j : hm.keySet()) {
			arr[i] = hm.get(j);
			i++;
		}
		Arrays.sort(arr);
		int temp = arr[0];
		int count = 1;
		for (int j = 1; j < arr.length; j++) {
			if (temp != arr[j]) {
				if (count == 1)
					result++;
				temp = arr[j];
				count = 1;
			} else {
				count++;
			}
		}
		return result;
	}
}

class Player {
	boolean isCheck;
	public LinkedList<Integer> winner;
	public LinkedList<Integer> loser;

	public Player() {
		isCheck = false;
		winner = new LinkedList<Integer>();
		loser = new LinkedList<Integer>();
		// TODO Auto-generated constructor stub
	}
}