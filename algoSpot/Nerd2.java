package algoSpot;

import java.util.*;

public class Nerd2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int prob = sc.nextInt();
        for(int i = 0; i < prob; i++){
            int people = sc.nextInt();
            System.out.println(people);
            Queue<Node> queue = new LinkedList<Node>();
            int total = 0;
            for(int j = 0; j < people; j++){
                if(j == 0){
                    queue.add(new Node(sc.nextInt(), sc.nextInt()));
                }else{
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    boolean check = true;
                    for(Node n : queue){
                        if(n.compare(a,b)){
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        queue.add(new Node(a,b));
                    }
                }
                total += queue.size();
            }
            System.out.println(total);
        }
    }
}

class Node {
    public int a;
    public int b;
    public Node(int a, int b){
        this.a = a;
        this.b = b;
    }
    public boolean compare(int a, int b){
        if(this.a < a && this.b < b){
            this.a = a;
            this.b = b;
            return true;
        } else{
            return false;
        }
    }
}
