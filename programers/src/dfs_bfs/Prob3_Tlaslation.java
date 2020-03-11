package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob3_Tlaslation {
	public static void main(String[] args) {
		SolutionTrs s = new SolutionTrs();
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println("결과는 : " + s.solution("hit", "cog", words));
//		SolutionTrs s1 = new SolutionTrs();
//		String[] words2 = { "dog", "log", "cog" };
//		System.out.println("결과는 : " + s1.solution("dig", "cog", words2));
	}
}

class SolutionTrs {
	static LinkedList<String> li;
	int min = Integer.MAX_VALUE;

	public SolutionTrs() {
		li = new LinkedList<String>();
	}

	public int solution(String begin, String target, String[] words) {
		boolean[] check = new boolean[words.length];
		boolean isTarget = false;
		for (String s : words) {
			if (s.equals(target)) {
				isTarget = true;
				break;
			}
		}

		if (!isTarget) {
			return 0;
		} else {
			bfs(begin, target, words, check, 0);
			return this.min;
		}
	}

	public void bfs(String now, String target, String[] words, boolean check[], int depth) {
		int count;
		for (int i = 0; i < words.length; i++) {
			count = 0;
			if (!check[i]) {
				for(int j = 0; j < now.length(); j++) {
					if (now.charAt(j) == words[i].charAt(j))
						count++;					
				}
				if (now.equals(target)) {
					this.min = Math.min(depth, this.min);
				} else if (count == now.length()-1) {
					check[i] = true;
					bfs(words[i], target, words, check, depth + 1);
					check[i] = false;
				} else
					continue;
			} else {
				continue;
			}
		}
	}
//	public int solution(String begin, String target, String[] words) {
//		int answer = Integer.MAX_VALUE;
//		String result;
//		boolean isTarget = false;
//		Queue<String> q = new LinkedList<String>();
//		for (String s : words) {
//			q.add(s);
//			if (target.equals(s))
//				isTarget = true;
//		}
//		if (isTarget) {
//			result = begin;
//			bfs(begin, target, words, q, result);
//		}
////		System.out.println(li.toString());
//		StringTokenizer st;
//		for (int i = 0; i < li.size(); i++) {
//			st = new StringTokenizer(li.get(i), " ");
//			answer = Math.min(st.countTokens(), answer);
//		}
//		if(li.size() == 0)
//			return 0;
//		return answer-1;
//	}
//
//	public void bfs(String begin, String target, String words[], Queue<String> q, String result) {
//		if (begin.equals(target)) {
//			li.add(result);
//			return;
//		} else {
//			int count;
//			int q_size = q.size();
//			int i = 0;
//			String s;
//			String tmp_res;
//			String tmp_begin;
//			while (i < q_size) {
//				count = 0;
//				s = q.poll();
////				System.out.print("start : " + result + "      ");
////				System.out.print(begin + "," + s + "     -     ");
//				for(int j = 0; j < s.length(); j++) {
//					if (s.charAt(j) == begin.charAt(j))
//						count++;					
//				}
//				if (count == s.length())
//					begin = s;
//				else if (count == s.length()-1) {
//					tmp_begin = begin;
//					begin = s;
//					tmp_res = result;
//					result += " " + s;
////					System.out.print(result + "  ");
////					System.out.println(q.toString());
//					bfs(begin, target, words, q, result);
//					result = tmp_res;
//					begin = tmp_begin;
//					q.add(s);
//				}
//				i++;
//			}
//		}
//	}

}
