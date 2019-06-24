package sss;

import java.util.ArrayList;

public class Prob4_Carpet {
	public static void main(String[] args) {
		SolutionC s = new SolutionC();
		s.solution(10, 2);
		s.solution(8, 1);
		s.solution(24, 24);
	}
}

class SolutionC {
	public int[] solution(int brown, int red) {
		int[] answer = new int[2];
		int height = 0;
		int width = 0;
		if (isSqure(red)) {
			height = (int) Math.sqrt(brown + red);
			width = (int) Math.sqrt(brown + red);
		} else {
			ArrayList<Integer> a1;
			a1 = getDivisor(red);
//			System.out.println(a1);
			for (int i = 0; i < a1.size(); i += 2) {
				int temp1 = a1.get(i);
				int temp2 = a1.get(i + 1);
//				System.out.println(temp1 + " " + temp2);
				if ((temp1 * temp2 == red) && ((temp1 + 2) * (temp2 + 2) == (brown + red))) {
					height = temp1 + 2;
					width = temp2 + 2;
					break;
				}
			}
		}
		answer[0] = width;
		answer[1] = height;
//		System.out.println(width);
//		System.out.println(height);
		return answer;
	}

	boolean isSqure(int num) {
		int temp;
		switch (num & 0x0f) {
		case 0:
		case 1:
		case 4:
		case 9:
			temp = (int) Math.sqrt((((double) num) + 0.5));
			return temp * temp == num;
		default:
			break;
		}
		return false;
	}

	ArrayList<Integer> getDivisor(int num) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				arr.add(i);
				arr.add(num / i);
				if (i * i > num) {
					break;
				}
			}
		}
		return arr;
	}
}

//0 �� 0
//1 �� 1
//2 �� 4
//3 �� 9
//4 �� 16
//5 �� 25
//6 �� 36
//7 �� 49
//8 �� 64
//9 �� 81
//���⼭ 1�ڸ� ���ڸ� �� �̾ƺ��� �Ʒ��� ����.
//0, 1, 4, 5, 6, 9
//������ ������ 1�ڸ��� ���� 6�� �� �ϳ��� �ƴϸ� ���� �������� �� �� ����.
//�켱, 4�������� �����غ���.
//0~3�� ���� �����ϸ� �Ʒ��� ����.
//0 �� 0(4)
//1 �� 1(4)
//2 �� 10(4)
//3 �� 21(4)
//�� ���� ������ ���ڸ� 4������ ǥ������ �� 1�ڸ��� 2/3�̸� �������� �ƴ϶� ���̴�.
//10���� 40%�� ���� ������ �� �ִ� ���ɼ��� 50%�� �����ߴ�.
//�Դٰ�, �� ������ ������ (num & 0x03) �� ������ �� �� �ִ�1
//���� ������ 8������ �غ��� 1�ڸ� ���ڴ� 0, 1, 4�� 3������ 62.5%�� ������ �� �ִ�.
//16������ �غ��� 0, 1, 4, 9�� 4������ ���� 75%�� ������ �� �ִ�.
