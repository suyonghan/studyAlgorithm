//Stack 3번문제

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
//				if (truck + totalTruck <= weight) { // 들어가기전 통과할 수 있는 무게라면
//					answer++;
//				} else {
//					answer += bridge_length; // 기다린 시간만큼 추가
//					totalTruck = totalTruck - bridgeQueue.peek();
//					bridgeQueue.poll();// 다리위 차가 하나 지나간다
//				}
//				totalTruck += truck; // 총 트럭 무게를 추가
//				bridgeQueue.offer(truck);// 다리큐로
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
