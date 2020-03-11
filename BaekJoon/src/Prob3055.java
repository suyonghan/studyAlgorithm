package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prob3055 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());

		char[][] board = new char[h][w];
		for (int i = 0; i < h; i++) {
			board[i] = sc.next().toCharArray();
		}

		Prob3055 p = new Prob3055();
		System.out.println(p.solution(board, w, h));
	}

	public void print(char[][] board) {

		System.out.println("---------------------------------------");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");
	}

	public String solution(char[][] board, int w, int h) {
		int end_i, end_j;
		int start_i, start_j;
		end_i = end_j = start_i = start_j = 1;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i][j] == 'S') {
					start_i = i;
					start_j = j;
				}
				if (board[i][j] == 'D') {
					end_i = i;
					end_j = j;
				}
			}
		}
		return find(board, end_i, end_j, start_i, start_j);
	}

	public String find(char[][] board, int end_i, int end_j, int now_i, int now_j) {
		// 0. 도착
		String result = "KAKTUS";
		Queue<Now> path = new LinkedList<Now>();
		int time = 0;

		// 1. 비버굴 체크
		if (!validate(board, end_i, end_j))
			return result;

		// 2. 고슴도치 체크
		if (!validate(board, now_i, now_i))
			return result;

		path.add(new Now(now_i, now_j));

		loop: while (path.size() > 0) {
			// 3. 물이 채워질 경로 구함
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == '*') {
						if (i > 0 && board[i - 1][j] == '.')
							board[i - 1][j] = '-';
						if (i < board.length - 1 && board[i + 1][j] == '.')
							board[i + 1][j] = '-';
						if (j > 0 && board[i][j - 1] == '.')
							board[i][j - 1] = '-';
						if (j < board[i].length - 1 && board[i][j + 1] == '.')
							board[i][j + 1] = '-';
					}
				}
			}
			// 4. 실제로 물이 채워짐
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == '-') {
						board[i][j] = '*';
					}
				}
			}
			// 5. 고슴도치 이동(**항상 최단경로로 가야함, 인덱스가 같아지면 더 움직일 필요가 없어진다.)
			int size = path.size();
			if (size == 0)
				return result;
			loop2 : for (int i = 0; i < size; i++) {
				Now c = path.poll();
				if (c.i == end_i && c.j == end_j) {
					result = Integer.toString(time);
					break loop;
				}
				if (end_i > c.i && (board[c.i + 1][c.j] == '.' || board[c.i + 1][c.j] == 'D')) {
					path.add(new Now(c.i + 1, c.j));
				}
				if (end_i < c.i && (board[c.i - 1][c.j] == '.' || board[c.i - 1][c.j] == 'D')) {
					path.add(new Now(c.i - 1, c.j));
				}
				if (end_j > c.j && (board[c.i][c.j + 1] == '.' || board[c.i][c.j + 1] == 'D')) {
					path.add(new Now(c.i, c.j + 1));
				}
				if (end_j < c.j && (board[c.i][c.j - 1] == '.' || board[c.i][c.j - 1] == 'D')) {
					path.add(new Now(c.i, c.j - 1));
				}
			}
			time++;
		}
		return result;
	}

	public boolean validate(char[][] board, int i, int j) {
		boolean check = false;
		if (i > 0 && board[i - 1][j] == '.')
			check = true;
		if (i < board.length - 1 && board[i + 1][j] == '.')
			check = true;
		if (j > 0 && board[i][j - 1] == '.')
			check = true;
		if (j < board[i].length - 1 && board[i][j + 1] == '.')
			check = true;
		return check;
	}
}

class Now {
	public int i;
	public int j;

	Now(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		return "Now [i=" + i + ", j=" + j + "]";
	}
}