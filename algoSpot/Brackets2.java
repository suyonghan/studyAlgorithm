package algoSpot;

import java.util.Scanner;
import java.util.Stack;

public class Brackets2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int prob = 0; prob < n; prob++) {
            String context = sc.next();
            if(solution(context))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
//        String context = "()()";
//        String context = "({[}])";
//        String context = "({}[(){}])";
//        if(solution(context))
//            System.out.println("YES");
//        else
//            System.out.println("NO");
    }

    public static boolean solution(String s){
        Stack<Character> stack = new Stack<Character>();
        boolean result = true;
        if(s.length() < 2)
            result = false;
        else{
            for(int i = 0; i < s.length(); i++){
                char temp = s.charAt(i);
                if(temp == '[' || temp == '{' || temp == '(')
                    stack.add(temp);
                else{
                    if(temp == ']' && '[' == stack.peek() && stack.size() > 0){
                        stack.pop();
                    } else if(temp == '}' && '{'== stack.peek() && stack.size() > 0){
                        stack.pop();
                    } else if(temp == ')' && '(' == stack.peek() && stack.size() > 0){
                        stack.pop();
                    } else{
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
