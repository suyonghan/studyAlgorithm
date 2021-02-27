package algoSpot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Picnic {
    public static HashSet<Integer> checked = new HashSet<>();
    public static HashMap<Integer,Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int probCount = sc.nextInt();
        int[] resultArray = new int[probCount];
        for(int pc = 0; pc < probCount; pc++){
            int n = sc.nextInt();
            int coupleCount = sc.nextInt();
            boolean [][] couple = new boolean [n][n];

            for(int i = 0; i < coupleCount; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(x > y){
                    int temp = y;
                    y = x;
                    x = temp;
                }
                couple[x][y] = true;
            }
            // print(couple, n);
            //System.out.println("people : " + n + ", coupleCount : " + coupleCount);
            resultArray[pc] = findCouples(couple, 0, 0);
        }
        for(int i = 0; i < probCount; i++){
            System.out.println(resultArray[i]);
        }
    }

    public static int findCouples(boolean[][] couples, int matchCount, int i){
        int result = 0;

        if(matchCount == couples.length/2){
            result = 1;
            //System.out.println(hm.toString());
        }
        else if(i == couples.length){
            result = 0;
        }
        else if(checked.contains(i))
            result = findCouples(couples, matchCount, i+1);
        else{
            for(int j = i; j < couples.length; j++){
                if(i == j)
                    continue;
                else{
                    //System.out.println(i + ", " + j);
                    //System.out.println(checked.toString());
                    if(couples[i][j] && !checked.contains(j)){
                        checked.add(i);
                        checked.add(j);
                        couples[i][j] = false;

                        hm.put(i,j);
                        result += findCouples(couples, matchCount+1, i+1);
                        checked.remove(j);
                        checked.remove(i);
                        hm.remove(i);
                        couples[i][j] = true;
                    }
                }
            }
        }
        return result;
    }

    public static void print(boolean[][] couple, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(couple[i][j])
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println("");
        }
    }
}
