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
//		// [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
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
//					if (temp == -1) { // ó��
//						temp = hm.get(skill_trees[i].charAt(j));
//					} else { // �ι�°
//						if (hm.get(skill_trees[i].charAt(j)) < temp) { // ������ΰ� �ƴ� ���
//							check = true;
//							break;
//						} else {
//							temp = hm.get(skill_trees[i].charAt(j)); // �� ����
//						}
//					}
//					if (temp_q.peek() != skill_trees[i].charAt(j)) {
//						check = true;
//						break;
//					} else {
//						temp_q.poll();
//					}
//				} else
//					continue; // ��ų ���̼��� ������� ���
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
