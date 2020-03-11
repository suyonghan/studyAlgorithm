package bogle;

import java.util.ArrayList;

public class BogleGame {
	static ArrayList<String> arrs = new ArrayList<String>();

	public static void main(String[] args) {
		char[][] arr = { { 'T', 'W', 'I', 'C', 'E' }, { 'I', 'S', 'C', 'U', 'B' }, { 'L', 'E', 'M', 'O', 'E' },
				{ 'U', 'F', 'M', 'O', 'A' }, { 'S', 'O', 'I', 'T', 'U' } };
		String[] target = { "TWICE", "IS", "SO", "BEAUTIFUL" };
		BogleGame.solution(arr, target);
		System.out.println(arrs);
	}

	public static boolean solution(char[][] arr, String[] target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < target.length; k++) {
					if (arr[i][j] == target[k].charAt(0)) {
						find(i, j, target[k], 0, arr);
					}
				}
			}
		}
		return false;
	}

	public static void find(int i, int j, String str, int count, char[][] arr) {
		// 1
		if (count == str.length() - 1) {
			arrs.add(str);
			return;
		} else if (i > 0 & j > 0 && i < arr.length - 1 && j < arr.length - 1) {
			if (arr[i - 1][j - 1] == str.charAt(count + 1)) {
				find(i - 1, j - 1, str, count + 1, arr);
			}
			if (arr[i - 1][j] == str.charAt(count + 1)) {
				find(i - 1, j, str, count + 1, arr);
			}
			if (arr[i - 1][j + 1] == str.charAt(count + 1)) {
				find(i - 1, j + 1, str, count + 1, arr);
			}
			if (arr[i][j - 1] == str.charAt(count + 1)) {
				find(i, j - 1, str, count + 1, arr);
			}
			if (arr[i][j] == str.charAt(count + 1)) {
				find(i, j, str, count + 1, arr);
			}
			if (arr[i][j + 1] == str.charAt(count + 1)) {
				find(i, j + 1, str, count + 1, arr);
			}
			if (arr[i + 1][j - 1] == str.charAt(count + 1)) {
				find(i + 1, j - 1, str, count + 1, arr);
			}
			if (arr[i + 1][j] == str.charAt(count + 1)) {
				find(i + 1, j, str, count + 1, arr);
			}
			if (arr[i + 1][j + 1] == str.charAt(count + 1)) {
				find(i + 1, j + 1, str, count + 1, arr);
			} else {
				return;
			}
		} else if (i == 0 && j == 0) {
			if (arr[i][j] == str.charAt(count + 1)) {
				find(i, j, str, count + 1, arr);
			}
			if (arr[i][j + 1] == str.charAt(count + 1)) {
				find(i, j + 1, str, count + 1, arr);
			}
			if (arr[i + 1][j] == str.charAt(count + 1)) {
				find(i + 1, j, str, count + 1, arr);
			}
			if (arr[i + 1][j + 1] == str.charAt(count + 1)) {
				find(i + 1, j + 1, str, count + 1, arr);
			} else {
				return;
			}
		} else if (i == 0 && j == arr.length - 1) {
			if (arr[i][j - 1] == str.charAt(count + 1)) {
				find(i, j - 1, str, count + 1, arr);
			}
			if (arr[i][j] == str.charAt(count + 1)) {
				find(i, j, str, count + 1, arr);
			}
			if (arr[i + 1][j - 1] == str.charAt(count + 1)) {
				find(i + 1, j - 1, str, count + 1, arr);
			}
			if (arr[i + 1][j] == str.charAt(count + 1)) {
				find(i + 1, j, str, count + 1, arr);
			} else {
				return;
			}
		} else if (i == arr.length - 1 && j == 0) {
			if (arr[i - 1][j] == str.charAt(count + 1)) {
				find(i - 1, j, str, count + 1, arr);
			}
			if (arr[i - 1][j + 1] == str.charAt(count + 1)) {
				find(i - 1, j + 1, str, count + 1, arr);
			}
			if (arr[i][j] == str.charAt(count + 1)) {
				find(i, j, str, count + 1, arr);
			}
			if (arr[i][j + 1] == str.charAt(count + 1)) {
				find(i, j + 1, str, count + 1, arr);
			} else {
				return;
			}
		} else if (i == arr.length - 1 && j == arr.length - 1) {
			if (arr[i - 1][j - 1] == str.charAt(count + 1)) {
				find(i - 1, j - 1, str, count + 1, arr);
			}
			if (arr[i - 1][j] == str.charAt(count + 1)) {
				find(i - 1, j, str, count + 1, arr);
			}
			if (arr[i][j - 1] == str.charAt(count + 1)) {
				find(i, j - 1, str, count + 1, arr);
			}
			if (arr[i][j] == str.charAt(count + 1)) {
				find(i, j, str, count + 1, arr);
			} else {
				return;
			}
		} else if (i == 0) {
			if (j != 0 && j != arr.length - 1) {
				if (arr[i][j - 1] == str.charAt(count + 1)) {
					find(i, j - 1, str, count + 1, arr);
				}
				if (arr[i][j] == str.charAt(count + 1)) {
					find(i, j, str, count + 1, arr);
				}
				if (arr[i][j + 1] == str.charAt(count + 1)) {
					find(i, j + 1, str, count + 1, arr);
				}
				if (arr[i + 1][j - 1] == str.charAt(count + 1)) {
					find(i + 1, j - 1, str, count + 1, arr);
				}
				if (arr[i + 1][j] == str.charAt(count + 1)) {
					find(i + 1, j, str, count + 1, arr);
				}
				if (arr[i + 1][j + 1] == str.charAt(count + 1)) {
					find(i + 1, j + 1, str, count + 1, arr);
				} else {
					return;
				}
			}
		} else if (i == arr.length - 1) {
			if (j != 0 && j != arr.length - 1) {
				if (arr[i - 1][j - 1] == str.charAt(count + 1)) {
					find(i - 1, j - 1, str, count + 1, arr);
				}
				if (arr[i - 1][j] == str.charAt(count + 1)) {
					find(i - 1, j, str, count + 1, arr);
				}
				if (arr[i - 1][j + 1] == str.charAt(count + 1)) {
					find(i - 1, j + 1, str, count + 1, arr);
				}
				if (arr[i][j - 1] == str.charAt(count + 1)) {
					find(i, j - 1, str, count + 1, arr);
				}
				if (arr[i][j] == str.charAt(count + 1)) {
					find(i, j, str, count + 1, arr);
				}
				if (arr[i][j + 1] == str.charAt(count + 1)) {
					find(i, j + 1, str, count + 1, arr);
				}
			}
		} else if (j == 0) {
			if (i != 0 && i != arr.length - 1) {
				if (arr[i - 1][j] == str.charAt(count + 1)) {
					find(i - 1, j, str, count + 1, arr);
				}
				if (arr[i - 1][j + 1] == str.charAt(count + 1)) {
					find(i - 1, j + 1, str, count + 1, arr);
				}
				if (arr[i][j] == str.charAt(count + 1)) {
					find(i, j, str, count + 1, arr);
				}
				if (arr[i][j + 1] == str.charAt(count + 1)) {
					find(i, j + 1, str, count + 1, arr);
				}
				if (arr[i + 1][j] == str.charAt(count + 1)) {
					find(i + 1, j, str, count + 1, arr);
				}
				if (arr[i + 1][j + 1] == str.charAt(count + 1)) {
					find(i + 1, j + 1, str, count + 1, arr);
				} else {
					return;
				}
			}
		} else if (j == arr.length - 1) {
			if (i != 0 && i != arr.length - 1) {
				if (arr[i - 1][j - 1] == str.charAt(count + 1)) {
					find(i - 1, j - 1, str, count + 1, arr);
				}
				if (arr[i - 1][j] == str.charAt(count + 1)) {
					find(i - 1, j, str, count + 1, arr);
				}
				if (arr[i][j - 1] == str.charAt(count + 1)) {
					find(i, j - 1, str, count + 1, arr);
				}
				if (arr[i][j] == str.charAt(count + 1)) {
					find(i, j, str, count + 1, arr);
				}
				if (arr[i + 1][j - 1] == str.charAt(count + 1)) {
					find(i + 1, j - 1, str, count + 1, arr);
				}
				if (arr[i + 1][j] == str.charAt(count + 1)) {
					find(i + 1, j, str, count + 1, arr);
				} else {
					return;
				}
			}
		}
	}
}
