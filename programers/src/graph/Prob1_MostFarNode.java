package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MostFarNode {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(s.solution(n, edge));
	}
}

class Solution1 {
	HashMap<Integer, Integer> hm;

	Solution1() {
		hm = new HashMap<Integer, Integer>();
	}

	public int solution(int n, int[][] edge) {
		Node[] nodes = new Node[n + 1];
		boolean[] check = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < edge.length; i++) {
			nodes[edge[i][0]].addVertex(edge[i][1]);
			nodes[edge[i][1]].addVertex(edge[i][0]);
		}

//		for (Node tmp : nodes)
//			tmp.printVertex();
//		System.out.println("--------------------");

		int count = 2;
		Queue<Node> q = new LinkedList<Node>();
		q.add(nodes[1]);
		hm.put(1, 0);
		while (count < nodes.length) {
			Node currentNode = q.poll();
//			System.out.print(currentNode.data + "->");
//			System.out.println(hm.toString());
			for (int connect : currentNode.li) {
				if (!hm.containsKey(connect)) {
					hm.put(connect, hm.get(currentNode.data) + 1);
					q.add(nodes[connect]);
					count++;
				}
			}
		}
//		System.out.println(hm.toString());
		count = 0;
		int max = 0;
		for (int key : hm.keySet()) {
			if (hm.get(key) == max)
				count++;
			else if (hm.get(key) > max) {
				max = hm.get(key);
				count = 1;
			}
		}
		return count;
	}

	//too much access
	public int failedSolutuon(int n, int[][] edge) {
		Node[] nodes = new Node[n + 1];
		boolean[] check;
		for (int i = 0; i < n + 1; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < edge.length; i++) {
			nodes[edge[i][0]].addVertex(edge[i][1]);
			nodes[edge[i][1]].addVertex(edge[i][0]);
		}

		for (int i = nodes.length - 1; i > 1; i--) {
			check = new boolean[n + 1];
			backTracking(nodes, nodes[i], i, 0, check);
			System.out.println();
		}
		System.out.println(hm.toString());

		int count = 0;
		int max = 0;
		for (int key : hm.keySet()) {
			if (hm.get(key) == max)
				count++;
			else if (hm.get(key) > max) {
				max = hm.get(key);
				count = 1;
			}
		}
		return count;
	}

	public void backTracking(Node[] nodes, Node currentNode, int start, int result, boolean[] check) {
		System.out.print(currentNode.data);
		if (currentNode.data == 1) {
			System.out.print("end");
			if (hm.containsKey(start))
				hm.put(start, Math.min(hm.get(start), result));
			else
				hm.put(start, result);
		} else {
			check[currentNode.data] = true;
			for (int i : currentNode.li) {
				if (!check[i])
					backTracking(nodes, nodes[i], start, result + 1, check);
			}
		}

	}
}

class Node {
	int data;
	List<Integer> li;

	Node(int data) {
		li = new ArrayList<Integer>();
		this.data = data;
	}

	public void addVertex(int v) {
		li.add(v);
	}

	public void printVertex() {
		System.out.println(li.toString());
	}
}