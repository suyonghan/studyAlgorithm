package algoSpot;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int prob = sc.nextInt();
        for(int pp = 0; pp < prob; pp++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            survive(n, k);
        }
//        survive(6, 3);
//        survive(40, 3);
//        survive(3,4);
    }

    public static void survive(int n, int k){

        Queue<Integer> round = new LinkedList<>();
        for(int i = 1 ; i <= n; i++){
            round.add(i);
        }

        int count = 0;
        int kill = -1;
        round.poll(); //always be killed no.1...
        while(round.size() > 2){
            kill = round.poll();
            count++;
            if(count == k){
                count = 0;
            } else{
                round.add(kill);
            }
        }

        int[] result = new int[round.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = round.poll();
        }
        Arrays.sort(result);
        for(int i = 0; i < result.length; i++){
            if( i != result.length-1)
                System.out.print(result[i] + " ");
            else
                System.out.println(result[i]);
        }
    }
}
