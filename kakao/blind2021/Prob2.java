package kakao_blind_2021;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Prob2 {

    public static HashMap<String, Integer> hm = new HashMap<String, Integer >();

    public String[] solution(String[] orders, int[] course) {

        for(String order : orders){
            //모든 메뉴의 nCr, 즉 조합을 구한다.
            for(int r = 2; r < order.length()+1; r++){
                int[] combArr = new int[order.length()];
                doCombination(combArr, sort(order), r, 0, 0);
            }
        }
        List<String> keyList = new ArrayList<>(hm.keySet());
        Collections.sort(keyList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return hm.get(o2).compareTo(hm.get(o1));
            }
        });
        //System.out.println(keyList.toString());
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        List<String> resultList = new ArrayList<String>();
        for(String str : keyList){
            if(hm.get(str) == 1)
                break;
            if(!countMap.containsKey(str.length())){
                countMap.put(str.length(), hm.get(str));
                resultList.add(str);
            } else{
                if(countMap.get(str.length()) <= hm.get(str)){
                    countMap.put(str.length(), hm.get(str));
                    resultList.add(str);
                }
            }
        }
        String[] answer = new String[resultList.size()];
        Collections.sort(resultList);
        for(int i = 0; i < answer.length; i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] prob1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = { 2,3,4 };
        Prob2 p = new Prob2();
        print(p.solution(prob1, course));
    }

    public static void print(String[] args){
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }

    public static String sort(String arg){
        char[] a = arg.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public void doCombination(int[] combArr, String order, int r, int index, int target) {
        if (r == 0){
            String result ="";
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
}
