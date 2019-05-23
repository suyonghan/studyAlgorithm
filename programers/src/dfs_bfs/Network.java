package dfs_bfs;

public class Network {
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int numbers[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(s.solution(3, numbers));
		int numbers2[][] = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println(s.solution(3, numbers2));
	}

}

class Solution2 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] check = new boolean[computers.length];
		for (int i = 0; i < computers.length; i++) {
			if (check[i])
				continue;
			dfs(computers, check, i);
			answer++;
		}
		return answer;
	}

	public static void dfs(int[][] a, boolean[] c, int v) {
		int n = a.length - 1;
		c[v] = true;
//		System.out.print(v + " ");
		for (int i = 1; i <= n; i++) {
			if (a[v][i] == 1 && !c[i]) {
				dfs(a, c, i);
			}
		}
	}

}