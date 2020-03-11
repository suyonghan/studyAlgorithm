package dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Prob3_IntegerTriangle {
	public static void main(String[] args) {
		int[][] arr = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
//		Solution3 s = new Solution3();
//		System.out.println(s.solution(arr));
//		Solution4 s = new Solution4();
//		System.out.println(s.solution(arr));
//		Solution5 s = new Solution5();
//		System.out.println(s.solution(arr));
		Solution6 s = new Solution6();
		System.out.println(s.solution(arr));
		
	}
}

class Solution3 { // �떆媛꾩큹怨�(耳��씠�뒪 5,6,7,8)
	int max = Integer.MIN_VALUE;

	public int solution(int[][] triangle) {
		int answer = 0;
		int height = triangle.length;
		findMaxWay(triangle, 0, 0, triangle[0][0], 1);
		answer = max;
		return answer;
	}

	public void findMaxWay(int[][] triangle, int i, int j, int value, int now_level) {
		if (triangle.length == now_level) {
			max = Math.max(max, value);
		} else {
			findMaxWay(triangle, i + 1, j, value + triangle[i + 1][j], now_level + 1);
			findMaxWay(triangle, i + 1, j + 1, value + triangle[i + 1][j + 1], now_level + 1);
		}
	}
}

class Solution4 { // �떆媛꾩큹怨�(耳��씠�뒪 5,6,7,8)
	public int solution(int[][] triangle) {
		int answer = 0;
		Node[][] tree = new Node[triangle.length][];
		for (int i = 0; i < triangle.length; i++) {
			tree[i] = new Node[triangle[i].length];
		}
		Node first = new Node(triangle[0][0]);
		first.hs.add(triangle[0][0]);
		tree[0][0] = first;

		for (int i = 1; i < tree.length; i++) {
			for (int j = 0; j < tree[i].length; j++) {
				System.out.println("level : " + (i + 1) + " " + j + "th node");
				Node temp = new Node(triangle[i][j]);
				if (j == 0) {
					temp.cal(tree[i - 1][j].hs);
				} else if (j == tree[i].length - 1) {
					System.out.println(tree[i - 1][j - 1].hs);
					temp.cal(tree[i - 1][j - 1].hs);
				} else {
					temp.cal(tree[i - 1][j].hs);
					temp.cal(tree[i - 1][j - 1].hs);
				}
				tree[i][j] = temp;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < tree[tree.length - 1].length; i++) {
			max = Math.max(max, tree[tree.length - 1][i].getMaxVal());
		}
		return answer = max;
	}
}

class Node {
	int val;
	HashSet<Integer> hs;

	Node(int val) {
		this.val = val;
		hs = new HashSet<Integer>();
	}

	void cal(HashSet<Integer> hs) {
		Iterator<Integer> it = hs.iterator();
		while (it.hasNext()) {
			this.hs.add(it.next() + val);
		}
//		System.out.println(this.hs);
	}

	int getMaxVal() {
		int max = Integer.MIN_VALUE;
		Iterator<Integer> it = this.hs.iterator();
		while (it.hasNext()) {
			max = Math.max(it.next(), max);
		}
		return max;
	}
}

class Solution5 { // bottom-up, �삤瑜�
	ArrayList<Integer> arr;

	public Solution5() {
		arr = new ArrayList<Integer>();
	}

	public int solution(int[][] triangle) {
		int answer = 0;
		for (int j = 0; j < triangle.length; j++) {
			calc(triangle, triangle.length - 1, j, triangle[triangle.length - 1][j]);
		}
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		return answer = max;

	}

	public void calc(int[][] triangle, int i, int j, int value) {
		if (i == 0 && j == 0) {
			arr.add(value);
			return;
		}
		if (j == 0) {
			calc(triangle, i - 1, j, value + triangle[i - 1][j]);
		} else if (j == triangle[i].length - 1) {
			calc(triangle, i - 1, j - 1, value + triangle[i - 1][j - 1]);
		} else {
			if (triangle[i - 1][j - 1] > triangle[i - 1][j])
				calc(triangle, i - 1, j - 1, value + triangle[i - 1][j - 1]);
			else if (triangle[i - 1][j - 1] < triangle[i - 1][j])
				calc(triangle, i - 1, j, value + triangle[i - 1][j]);
			else if (triangle[i - 1][j - 1] == triangle[i - 1][j]) {
				calc(triangle, i - 1, j - 1, value + triangle[i - 1][j - 1]);
				calc(triangle, i - 1, j, value + triangle[i - 1][j]);
			}
		}
	}
}

class Solution6 {
	public int solution(int[][] triangle) {
		int[][] dp = new int[triangle.length][triangle.length];
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
		}

		// 2. �룞�쟻怨꾪쉷踰� //
		for (int i = 2; i < triangle.length; i++)
			for (int j = 1; j < i; j++)
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];

		// 3. 理쒕�媛� 諛섑솚 //
		int max = 0;
		for (int i = 0; i < dp.length; i++)
			max = Math.max(max, dp[dp.length - 1][i]);

		return max;
	}
}
