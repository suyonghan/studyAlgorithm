package test;

import java.util.HashMap;

class FIndRoad {
	public int solution(String dirs) {
		int answer = 0;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int p_x;
		int p_y;
		char p_op = ' ';
		int x = 0;
		int y = 0;
		for (int i = 0; i < dirs.length(); i++) {
			p_x = x;
			p_y = y;
			switch (dirs.charAt(i)) {
			case 'U':
				if (y < 5) {
					y++;
					p_op = 'D';
				}
				break;
			case 'D':
				if (y > -5) {
					y--;
					p_op = 'U';
				}
				break;
			case 'R':
				if (x < 5) {
					x++;
					p_op = 'L';
				}
				break;
			case 'L':
				if (x > -5) {
					x--;
					p_op = 'L';
				}
				break;
			default:
				break;
			}
			String savePoint1 = Integer.toString(x) + Integer.toString(y) + Character.toString(dirs.charAt(i));
			String savePoint2 = Integer.toString(p_x) + Integer.toString(p_y) + Character.toString(p_op);
			if (hm.containsKey(savePoint1))
				continue;
			else if (hm.containsKey(savePoint2)) {
				continue;
			} else {
				hm.put(Integer.toString(p_x) + Integer.toString(p_x) + Character.toString(p_op), 0);
				hm.put(Integer.toString(x) + Integer.toString(y) + Character.toString(dirs.charAt(i)), 0);
				answer++;
			}
			System.out.println(hm.keySet());
		}
		return answer;
	}
}