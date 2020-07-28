package leetcode;

public class Prob6 {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING"; //output : 'PAHNAPLSIIGYIR'
		int numRows = 3;
//		String s = "PAYPALISHIRING"; //output : 'PINALSIGYAHRPI'
//		int numRows = 4;
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert(s, numRows));
	}
	
}

class ZigZagConversion {
	public String convert(String s, int numRows) {
		int len = s.length();
		int[][] board = new int[numRows][len];
		int i = 0;
		int j = 0;
		int countVertical = 0;
		int countHorizental = 0;

		for (int index = 0; index < len; index++) {
            if(numRows == 1)
			return s;
//			System.out.println(i + ", " + j + ", " + index + ", " + countVertical + ", " + countHorizental);
			board[i][j] = s.charAt(index);
			if (countVertical < numRows - 1) {
				i++;
				countVertical++;
			} else {
				j++; i--;
				countHorizental++;
			}
			if(countHorizental == numRows - 1) {
				countVertical = countHorizental = 0;
			}
		}
		String result = "";
		for(int y = 0; y < numRows; y++) {
			for(int x = 0; x < len; x++) {
				if(board[y][x] != 0)
					result += (char)board[y][x];
			}
		}
		return result;
	}
}