//Stack 3������

package stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Prob3_TruckOnBridge {
//	public int solution(int bridge_length, int weight, int[] truck_weights) {
//		int answer = 0;
//		Queue<Integer> readyQueue = new LinkedList<>();
//		Queue<Integer> bridgeQueue = new LinkedList<>();
//		for (int i : truck_weights) {
//			readyQueue.offer(i);
//		}
//		int totalTruck = 0;
//		while (true) {
//			System.out.print("   answer : " + answer);
//			System.out.print("   ready : " + readyQueue);
//			System.out.println("   onBrige : " + bridgeQueue);
//
//			if (!readyQueue.isEmpty()) {
//				int truck = 0;
//				truck = readyQueue.poll();
//				if (truck + totalTruck <= weight) { // ������ ����� �� �ִ� ���Զ��
//					answer++;
//				} else {
//					answer += bridge_length; // ��ٸ� �ð���ŭ �߰�
//					totalTruck = totalTruck - bridgeQueue.peek();
//					bridgeQueue.poll();// �ٸ��� ���� �ϳ� ��������
//				}
//				totalTruck += truck; // �� Ʈ�� ���Ը� �߰�
//				bridgeQueue.offer(truck);// �ٸ�ť��
//			} else {
//				while (!bridgeQueue.isEmpty()) {
//					bridgeQueue.poll();
//					System.out.print("   answer : " + answer);
//					System.out.print("   ready : " + readyQueue);
//					System.out.println("   onBrige : " + bridgeQueue);
//				}
//				answer = answer + bridge_length;
//				break;
//			}
//		}
//
//		return answer;
//	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		int sum;
		sum = answer = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			int d = truck_weights[i];
			while (true) {
				if (q.isEmpty()) {
					q.offer(d);
					answer++;
					sum += d;
					break;
				}

				else if (q.size() == bridge_length) {
					sum -= q.peek();
					q.poll();
				} else {
					if (sum + d > weight) {
						q.offer(0);
						answer++;
					} else {
						q.offer(d);
						answer++;
						sum += d;
						break;
					}
				}
			}
		}
		return answer + bridge_length;
	}
}
