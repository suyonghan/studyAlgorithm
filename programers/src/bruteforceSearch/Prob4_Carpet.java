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

//0 → 0
//1 → 1
//2 → 4
//3 → 9
//4 → 16
//5 → 25
//6 → 36
//7 → 49
//8 → 64
//9 → 81
//여기서 1자리 숫자만 다 뽑아보면 아래와 같다.
//0, 1, 4, 5, 6, 9
//임의의 숫자의 1자리가 위의 6개 중 하나가 아니면 결코 제곱수가 될 수 없다.
//우선, 4진수부터 시작해보자.
//0~3을 각각 제곱하면 아래와 같다.
//0 → 0(4)
//1 → 1(4)
//2 → 10(4)
//3 → 21(4)
//이 말은 임의의 숫자를 4진수로 표기했을 때 1자리가 2/3이면 제곱수가 아니란 뜻이다.
//10진수 40%에 비해 배제할 수 있는 가능성도 50%로 증가했다.
//게다가, 이 연산은 간단히 (num & 0x03) 한 방으로 할 수 있다1
//같은 연산을 8진수로 해보면 1자리 숫자는 0, 1, 4의 3가지로 62.5%를 배제할 수 있다.
//16진수로 해보면 0, 1, 4, 9의 4가지로 무려 75%를 배제할 수 있다.
