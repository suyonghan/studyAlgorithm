package dfs_bfs;

import java.util.*;

public class TravelPath {
	public static void main(String[] args) {

	}
}

class Solution {
	public String[] solution(String[][] tickets) {
		// 출발지 초기화 //
		List<Node> nodeList = new ArrayList<>();
		for (int i = 0; i < tickets.length; i++)
			nodeList.add(new Node(tickets[i][0], tickets[i][1]));

		Collections.sort(nodeList,
				((o1, o2) -> o1.departure.compareTo((o2.departure)) != 0 ? o1.departure.compareTo((o2.departure))
						: o1.destination.compareTo(o2.destination)));

		// ICN으로 시작된 출발점 설정 //
		List<Node> departures = new ArrayList<>();
		for (Node node : nodeList)
			if (node.departure.equals("ICN"))
				departures.add(node);

		// DFS //
		for (Node node : departures) {
			node.index = 0;
			if (dfs(nodeList, node, 1))
				break;
		}

		return createArray(nodeList);
	}

	public String[] createArray(List<Node> nodeList) {
		// index 순차적으로 값을 넣기 위해 //
		Collections.sort(nodeList, (o1, o2) -> o1.index > o2.index ? 1 : -1);

		String[] answer = new String[nodeList.size() + 1];
		answer[0] = nodeList.get(0).departure;
		answer[1] = nodeList.get(0).destination;
		for (int i = 1; i < nodeList.size(); i++)
			answer[i + 1] = nodeList.get(i).destination;

		return answer;
	}

	public boolean dfs(List<Node> tickets, Node departure, int idx) {
		boolean stop = false;
		if (idx == tickets.size())
			return true;

		for (Node ticket : tickets) {
			if (ticket.index < 0 && departure.isAdjacent(ticket)) {
				ticket.index = idx;
				if ((stop = dfs(tickets, ticket, idx + 1)))
					break;
			}
		}

		// 잘못된 경로 일 경우, 현재 경로는 취소하기 위한 로직 //
		if (!stop)
			departure.index = -1;

		return stop;
	}

	public class Node {
		private String departure;
		private String destination;
		private int index = -1;

		public Node(String departure, String destination) {
			this.departure = departure;
			this.destination = destination;
		}

		public boolean isAdjacent(Node other) {
			return this.destination.equals(other.departure);
		}
	}
}