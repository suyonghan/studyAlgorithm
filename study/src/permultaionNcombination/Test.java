package permultaionNcombination;

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[8];
		combination(arr, 0, 8, 3, 0);
	}

	// arr : ä�� ���� array, index : arr�� index, n : n���� ���� ��, k : �̾ƾ���(�����ִ�) ������ ����,
	// target : arr�� ������ ���� ��
	static void combination(int[] arr, int index, int n, int k, int target) {
		if (k == 0) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		} else if (target == n) {
			return;
		} else {

			arr[index] = target;
			// case#1. index�� target���� ä���� (index + 1, k - 1, target + 1)
			combination(arr, index + 1, n, k - 1, target + 1);
			// case#2. target�� ������ �ȵ� index ��ä���� (index, k, target + 1)
			combination(arr, index, n, k, target + 1);
		}
	}

	static void permutation(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			printPermutation(arr, k);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}

	}

	static void printPermutation(int[] arr, int k) {

		for (int i = 0; i < k; i++) {

			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void swap(int[] arr, int i, int j) {

		int temp;

		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
