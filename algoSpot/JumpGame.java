package algoSpot;

import java.util.Scanner;

public class JumpGame {
    public static int[][] cache;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int prob = 0; prob < testCase; prob++){
            int n = sc.nextInt();
            board = new int[n][n];
            cache = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    board[i][j] = sc.nextInt();
                }

            }
            if(findPath(board, 0, 0))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static boolean findPath(int[][] board, int x, int y){
        boolean result = false;
//        System.out.println(x + ":" + y);
        if(x == board.length-1 && y == board.length-1)
            return true;
        else if (x >= board.length || y >= board.length){
            return false;
        }
        else if(cache[x][y] > 0)
            return false;
        else{
            try {
                int power = board[x][y];
                cache[x][y] = power;
                if(!findPath(board, x+power, y))
                    result = false;
                else
                    return true;
                if(!findPath(board, x, y+power))
                    result = false;
                else
                    return true;
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
            return false;
        }
    }
}
