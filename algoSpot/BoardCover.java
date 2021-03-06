package algoSpot;

import javax.swing.*;
import java.util.HashSet;
import java.util.Scanner;

public class BoardCover {
    public static int resultCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int prob = 0; prob < n; prob++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            boolean[][] board = new boolean[x][y];
            for(int i = 0; i < x; i++){
                String line = sc.next();
                for(int j = 0; j < y ; j++){
                    if( line.charAt(j)== '#')
                        board[i][j] = false;
                    else
                        board[i][j] = true;
                }
            }
            //print(board);
//            if(x < 9 && y < 9)
            findCase(board, 0, 0);
            System.out.println(resultCount);
            resultCount = 0;
        }
    }

    public static void findCase(boolean[][] board, int i, int j){
        try {
//            System.out.print(i + "_" + j + ", ");
            if(i == board.length-1 && j == board[i].length-1){
                // 탐색의 마지막 케이스, case ㄴ 대칭형만 체크하고 종료
                checkCase(i, j, i, j+1, i+1, j+1, i+1, j, board);
                if(checkAllCoveredBoard(board))
                    resultCount++;
                return;
            } else if(board[i][j] == true){
                //case : ㄴ
                checkCase(i, j, i, j, i+1, j, i+1, j+1, board);
                //case : ㄴ대칭
                checkCase(i, j, i, j+1, i+1, j+1, i+1, j, board);
                //case : ㄱ
                checkCase(i, j, i, j, i, j+1, i+1, j+1, board);
                //case : ㄱ 대칭
                checkCase(i, j, i, j, i, j+1, i+1, j, board);
            }
            else if (board[i][j] == false){
                if(i+1 < board.length)
                    findCase(board, i+1, j);
                else
                    findCase(board, 0, j+1);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return ; //벗어나는 경로는 재귀호출 종료
        }
    }

    public static boolean checkValidation(int x1, int y1, int x2, int y2, int x3, int y3, boolean[][] board){
        try {
            if(board[x1][y1] && board[x2][y2] && board[x3][y3])
                return true;
            else
                return false;
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public static void checkCase(int i, int j, int x1, int y1, int x2, int y2, int x3, int y3, boolean[][] board){
        if(checkValidation(x1, y1, x2, y2, x3, y3, board)){
            board = checkBoard(x1, y1, x2, y2, x3, y3, board, true);
            if(i+1 < board.length)
                findCase(board,i+1,j);
            else if(j+1 < board[i].length)
                findCase(board,0,j+1);
            else
                return;
            board = checkBoard(x1, y1, x2, y2, x3, y3, board, false);
        } else{
            if(i+1 < board.length)
                findCase(board,i+1,j);
            else if(j+1 < board[i].length)
                findCase(board,0,j+1);
            else
                return;
        }
    }

    public static boolean[][] checkBoard(int x1, int y1, int x2, int y2, int x3, int y3, boolean[][] board, boolean isChange){
        if(!isChange){
            board[x1][y1] = true;
            board[x2][y2] = true;
            board[x3][y3] = true;
        } else{
            board[x1][y1] = false;
            board[x2][y2] = false;
            board[x3][y3] = false;
        }
        return board;
    }

    public static boolean checkAllCoveredBoard(boolean[][] board){
        //print(board);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j])
                    return false;
                else
                    continue;
            }
        }
        return true;
    }

    public static void print(boolean[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j])
                    System.out.print(".");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }

}
