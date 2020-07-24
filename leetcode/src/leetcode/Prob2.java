package leetcode;

public class Prob2 {
	public static void main(String[] args) {

	}
}

class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		String l1str = "";
		String l2str = "";
		for (ListNode curr = l1; curr != null; curr = curr.next)
			l1str = l1str + Integer.toString(curr.val);
		for (ListNode curr = l2; curr != null; curr = curr.next)
			l2str = l2str + Integer.toString(curr.val);
		int size = Math.max(l1str.length(), l2str.length());
		int a = l1str.charAt(0) - '0';
		int b = l2str.charAt(0) - '0';
		int ten;
		if(a + b >= 10) {
			result = new ListNode(a + b - 10);
			ten = 1;
		}
		else {
			result = new ListNode(a + b);
			ten = 0;
		}
		ListNode curr = result;
		result = curr;
				for (int i = 1; i < size; i++) {
			if(i > l1str.length()-1)
				a = 0;
			else
				a = l1str.charAt(i) - '0';
			if(i > l2str.length()-1)
				b = 0;
			else
				b = l2str.charAt(i) - '0';
			if(a + b + ten >= 10) {
				result.next = new ListNode(a + b + ten - 10);
				ten = 1;
			}
			else {
				result.next = new ListNode(a + b + ten);
				ten = 0;
			}
			result = result.next;
		}
        if(ten == 1)
			result.next = new ListNode(1);
        result = curr;
		return result;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}