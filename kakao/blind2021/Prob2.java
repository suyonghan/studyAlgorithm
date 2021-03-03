package kakao_blind_2021;

import java.text.BreakIterator;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Prob2 {

    ConcurrentHashMap<String, Integer> hm = new ConcurrentHashMap<>();
    List<String> list = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        //모든 orders를 탐색
        for(String order : orders){
            //모든 메뉴의 nCr, 즉 조합을 구한다.
            for(int r = 2; r < order.length()+1; r++){
                int[] combArr = new int[order.length()];
                doCombination(combArr, order, r, 0, 0);

                //xy, yx의 케이스를 모두 생각하여 조합을 구해야함
                doCombination(combArr, new StringBuilder(order).reverse().toString(), r, 0, 0);
            }
        }

        // System.out.println(hm.toString());

        HashMap<Integer, Integer> courseMap = new HashMap<>();
        for(int i : course){
            courseMap.put(i, 0);
        }

        for(String key : hm.keySet()){
            if(hm.get(key) < 2)
                hm.remove(key);
            else{
                if(courseMap.containsKey(key.length())){ // 찾고있는 course인지
                    courseMap.put(key.length(), Math.max(hm.get(key), courseMap.get(key.length())));
                }
            }
        }

        ArrayList<String> list = new ArrayList<>();

        HashSet<String> dupCheck = new HashSet<>();
        for(String key : hm.keySet()){
            if(courseMap.containsKey(key.length()) && hm.get(key) == courseMap.get(key.length())){
                char[] charArr = key.toCharArray();
                Arrays.sort(charArr);
                String temp = new String(charArr);
                if(dupCheck.contains(temp))
                    continue;
                else{
                    dupCheck.add(temp);
                    list.add(key);
                }
            }
        }

        System.out.println(list.toString());

        String[] answer = list.toArray(new String[list.size()]);

        Arrays.sort(answer);
        return answer;
    }

    public void doCombination(int[] combArr, String order, int r, int index, int target) {
        if (r == 0){
            String result ="";
            char[] charArry = result.toCharArray();
            Arrays.sort(charArry);
            result = new String(charArry);
            for(int i = 0; i < index; i++)
                result += order.charAt(combArr[i]);
            if(hm.containsKey(result))
                hm.put(result, hm.get(result) + 1);
            else
                hm.put(result, 1);
        } else if (target == order.length())
            return;
        else {
            combArr[index] = target;
            doCombination(combArr, order, r-1, index+1, target+1);
            doCombination(combArr, order, r, index, target+1);
        }
    }

    public static void main(String[] args) {
        Prob2 p = new Prob2();
        //String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String orders[] = {"XYZ", "XWY", "WXA"};
        int course[] = {2,3,4};
        p.solution(orders, course);
    }
}
