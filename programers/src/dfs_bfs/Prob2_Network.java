package dfs_bfs;

public class Prob2_Network {

}

class Searchs {
	int n;
	int answer;
	boolean[][] isVisit;

	Searchs(int n, int[][] computers) {
		this.n = n;
		answer = 0;
		isVisit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (computers[i][j] == 1)
					isVisit[i][j] = true;
			}
		}
	}

	// i : 0 ~ n
	// j : i ~ n
	void dfs(int depth, int i, int j) {
		if (depth == 1)
			answer++;
		isVisit[i][j] = false;

		if (isVisit[j][j])
			dfs(depth + 1, j, j);
		if (j + 1 < n && isVisit[i][j + 1])
			dfs(depth + 1, i, j + 1);
	}
}

class Solutionnetwork {
	public int solution(int n, int[][] computers) {

		Searchs s = new Searchs(n, computers);

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (s.isVisit[i][j])
					s.dfs(1, i, j);
			}
		}

		int answer = s.answer;
		return answer;
	}
}