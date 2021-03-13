package algoSpot;

import java.util.Scanner;

public class QuadTree {

    public static void main(String[] args) {
//        System.out.println(doSomething("xbbww"));
//        System.out.println(doSomething("xbwxwbbwb"));
//        System.out.println(doSomething("xxwwwbxwxwbbbwwxxxwwbbbwwwwbb", 0));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] result = new String[n];

        for(int i = 0; i < n; i++){
            String prob = sc.next();
            result[i] = doSomething(prob);
        }
        for(String rr : result)
            System.out.println(rr);
    }

    public static String doSomething(String square){
        //System.out.println(square);
        String[] result = new String[5];
        int count = 1;

        if(square.length() == 1)
            return square;

        result[0] = "x";
        for(int i = 1; i < square.length(); i++){
            if(count == 5){ // 1,2,3,4가 다 찼음을 의미
                break;
            }
            if(square.charAt(i) != 'x'){ // 그냥 압축이 안된건 순서대로 저장
                result[count++] = square.charAt(i) + "";
                //System.out.println("depth : " + depth + ", " + result[count-1]);
            } else{ // 압축이 되었으면 그 사각형을 뭘로담을지를 검색
                result[count++] = doSomething(square.substring(i));
                i = i + (result[count-1].length() -1) ;
            }
        }
//        System.out.println(square);
//        System.out.println(result[0] + ", " + result[1] + ", " + result[2] + ", " + result[3] + ", " + result[4]);

        return result[0] + result[3] + result[4] + result[1] + result[2];
    }
}


