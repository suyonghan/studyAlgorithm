package greedy;

import java.util.*;
class Prob1_GymSuit {
    public static int solution(int n, int[] lost, int[] reserve) {
        List<String> lostList = new ArrayList<>();
        for(int num : lost)
            lostList.add(num + "");
 
        List<String> reserveList = new ArrayList<>();
        for(int num : reserve)
            reserveList.add(num + "");
 
        int answer = 0;
 
        List<String> allList = new ArrayList<>();
        for(int i = 0; i < n; i++)
            allList.add(i + 1 + "");
 
        // �翬�� ü������ 2�� ������ �л��� ü������ ������ ���ߴٸ�, ������ ü������ ������ �� �����ϴ�.
        Iterator<String> it = lostList.iterator();
        while(it.hasNext()) {
            String num = it.next();
            System.out.println(num);
            if(reserveList.contains(num)) {
                reserveList.remove(num);
                it.remove();
            }
        }
 
        for(int i = 0; i < allList.size(); i++) {
            String num = allList.get(i);
            if(lostList.contains(num)) {
                /* �л����� ��ȣ�� ü�� ������ �Ű��� �ֱ� ������ �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ �����ַ��� �մϴ�. */
                if(reserveList.contains((Integer.parseInt(num) - 1) + "")) {
                    lostList.remove(num);
                    reserveList.remove((Integer.parseInt(num) - 1) + "");
                    answer++;
                } else if (reserveList.contains((Integer.parseInt(num) + 1) +"")) {
                    lostList.remove(num);
                    reserveList.remove((Integer.parseInt(num) + 1) + "");
                    answer++;
                }
            } else {
                answer++;
            }
        }
        return answer;
    }
 
    public static void main(String args[]) {
        int[] lost = {1,2};
        int[] reserve = {1,2};
        System.out.println(solution(30, lost, reserve));
    }
}
