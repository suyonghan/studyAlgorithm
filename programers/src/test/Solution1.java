package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//public class Solution {
//	public int solution(int[] A, int[] B) {
//		int answer = 0;
//		Arrays.sort(A);
//		Arrays.sort(B);
//		for (int i = 0; i < A.length; i++) {
//			answer += (A[i] * B[B.length - 1 - i]);
//		}
//
//		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//		System.out.println("Hello Java");
//
//		return answer;
//	}
//}

//public class Solution {
//	public int solution(String skill, String[] skill_trees) {
//		int answer = 0;
//		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
//		Queue<Character> q = new LinkedList<Character>();
//		Queue<Character> temp_q;
//		for (int i = 0; i < skill.length(); i++) {
//			hm.put(skill.charAt(i), i + 1);
//			q.add(skill.charAt(i));
//		}
//
//		boolean check;
//		for (int i = 0; i < skill_trees.length; i++) {
//			temp_q = q;
//			check = false;
//			int temp = -1;
//			for (int j = 0; j < skill_trees[i].length(); j++) {
//				if (hm.containsKey(skill_trees[i].charAt(j))) {
//					if (temp == -1) { // 처음
//						temp = hm.get(skill_trees[i].charAt(j));
//					} else { // 두번째
//						if (hm.get(skill_trees[i].charAt(j)) < temp) { // 순서대로가 아닐 경우
//							check = true;
//							break;
//						} else {
//							temp = hm.get(skill_trees[i].charAt(j)); // 그 다음
//						}
//					}
//					if (temp_q.peek() != skill_trees[i].charAt(j)) {
//						check = true;
//						break;
//					} else {
//						temp_q.poll();
//					}
//				} else
//					continue; // 스킬 선이수에 영향없는 사람
//			}
//
//			if (!check) {
//				answer++;
//				System.out.println(skill_trees[i]);
//			}
//		}
//		return answer;
//	}
//}
