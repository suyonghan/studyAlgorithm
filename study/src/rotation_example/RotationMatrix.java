package rotation_example;

public class RotationMatrix {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int[][] arr2 = new int[10][10];
		int count = 1;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = count++;
			}
		}
		
		// rotateMatrix testCase
		printMatrix(arr);
		printMatrix(rotateMatrix(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix(arr2));

		// rotateMatrix1 testCase
		printMatrix(arr);
		printMatrix(rotateMatrix1(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix1(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix1(arr2));
	}

	// 정사각형 배열을 시계방향으로 한칸씩 이동
	public static int[][] rotateMatrix(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		int limitIndex = arr.length - 1;
		if (arr.length % 2 == 1)
			result[arr.length / 2][arr.length / 2] = arr[arr.length / 2][arr.length / 2];
		for (int i = 0; i < arr.length / 2; i++) {
//			System.out.println("up");
			for (int j = i; j < limitIndex - i; j++) { // 위 n-1개
				result[i][j + 1] = arr[i][j];
			}
//			System.out.println("right");
			for (int j = i; j < limitIndex - i; j++) { // 오른쪽 n-1개
				result[j + 1][limitIndex - i] = arr[j][limitIndex - i];
			}
//			System.out.println("left");
			for (int j = i; j < limitIndex - i; j++) { // 왼쪽 n-1개
				result[limitIndex - 1 - j][i] = arr[limitIndex - j][i];
			}
//			System.out.println("down");
			for (int j = i; j < limitIndex - i; j++) { // 아래 n-1개
				result[limitIndex - i][limitIndex - 1 - j] = arr[limitIndex - i][limitIndex - j];
			}
		}
		return result;
	}

	// 정사각형 배열의 홀수번째 줄은 반시계방향, 짝수번째 줄은 시계방향으로 한칸씩 이동
	public static int[][] rotateMatrix1(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		int limitIndex = arr.length - 1;
		if (arr.length % 2 == 1)
			result[arr.length / 2][arr.length / 2] = arr[arr.length / 2][arr.length / 2];
		for (int i = 0; i < arr.length / 2; i++) {
			if (i % 2 == 1) {
				for (int j = i; j < limitIndex - i; j++) { // 위 n-1개
					result[i][j] = arr[i][j + 1];
				}
//				System.out.println("right");
				for (int j = i; j < limitIndex - i; j++) { // 오른쪽 n-1개
					result[j][limitIndex - i] = arr[j + 1][limitIndex - i];
				}
//				System.out.println("left");
				for (int j = i; j < limitIndex - i; j++) { // 왼쪽 n-1개
					result[limitIndex - j][i] = arr[limitIndex - 1 - j][i];
				}
//				System.out.println("down");
				for (int j = i; j < limitIndex - i; j++) { // 아래 n-1개
					result[limitIndex - i][limitIndex - j] = arr[limitIndex - i][limitIndex - 1 - j];
				}
			} else {
//				System.out.println("up");
				for (int j = i; j < limitIndex - i; j++) { // 위 n-1개
					result[i][j + 1] = arr[i][j];
				}
//				System.out.println("right");
				for (int j = i; j < limitIndex - i; j++) { // 오른쪽 n-1개
					result[j + 1][limitIndex - i] = arr[j][limitIndex - i];
				}
//				System.out.println("left");
				for (int j = i; j < limitIndex - i; j++) { // 왼쪽 n-1개
					result[limitIndex - 1 - j][i] = arr[limitIndex - j][i];
				}
//				System.out.println("down");
				for (int j = i; j < limitIndex - i; j++) { // 아래 n-1개
					result[limitIndex - i][limitIndex - 1 - j] = arr[limitIndex - i][limitIndex - j];
				}
			}
		}
		return result;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j > 0) {
					System.out.print(" ");
					if (arr[i][j] < 10)
						System.out.print(" ");
				} else if (j == 0 && arr[i][j] < 10)
					System.out.print(" ");
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
