package algoSpot;

import java.util.Scanner;

public class TrianglePath {
    public static int[][] board;
    public static int[][] cost;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int prob = 0; prob < testCase; prob++){
            int n = sc.nextInt();
            board = new int[n][n];
            cost = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j <= i; j++){
                    board[i][j] = sc.nextInt();
                }
            }
//            print(board);
            System.out.println(findMaxPath(board, cost, n));;
        }
    }

    public static int findMaxPath(int[][] board, int[][] cost, int n){
        // cost n-1라인을 board로 구하기
        for(int i = 0; i < n; i++){
            cost[n-1][i] = board[n-1][i];
        }
        //cost[i-1][j]의 최대값을 cost[i][j], cost[i][j+1]의 최대값에서 구하기
        for(int i = n-2; i > -1; i--){
            for(int j = 0; j < i+1; j++){
                cost[i][j] = Math.max(cost[i+1][j], cost[i+1][j+1]) + board[i][j];
            }
        }

//        print(cost);
        return cost[0][0];
    }

    public static void print(int[][]board){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < i+1; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
