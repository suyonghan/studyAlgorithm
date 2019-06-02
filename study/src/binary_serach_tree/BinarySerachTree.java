package binary_serach_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySerachTree {
	private Node root;

	public BinarySerachTree() {
		root = null;
	}

	public void add(int val) {
		Node current = root;
		if (root == null)
			root = new Node(val);
		else {
			while (current != null) {
				if (current.val < val) {
					if (current.right != null)
						current = current.right;
					else {
						current.right = new Node(val);
						break;
					}
				}

				else if (current.val > val)
					if (current.left != null)
						current = current.left;
					else {
						current.left = new Node(val);
						break;
					}
				else {
					System.out.println("already existed");
					return;
				}
			}
		}
	}

	public Boolean search(int val) {
		Node current = root;
		while (current != null) {
			if (current.val > val)
				current = current.left;
			else if (current.val < val)
				current = current.right;
			else
				return true;
		}
		return false;
	}

	public Boolean remove(int val) {
		if (root != null) {
			Node current = root;
			Node prev = null;
			if (root.val == val) { // ��Ʈ�� ������ ����� ���
				current = root;
			} else { // ��Ʈ�� ��������� �ƴ� ���
				prev = root;
				if (val < root.val)
					current = root.left;
				else
					current = root.right;
				while (current != null) { // ���� �����Ϸ��� ���� ������ current�� null���� �ȴ�.
					if (val == current.val)
						break;
					else {
						prev = current;
						if (val < current.val)
							current = current.left;
						else
							current = current.right;
					}
				}
			}
			if (current != null) { // ������ ���� ã�� ���
				if (current.left == null && current.right == null) { // ������ ����� ������尡 ���� ��
					if (prev != null) { // ������ ������� ������尡 root�� �ƴ� ��
						if (current == prev.left) // ��������� ���ʳ�� == ������ ���
							prev.left = null;
						else if (current == prev.right)// ��������� �����ʳ�� == ������ ���
							prev.right = null;
					} else
						root = null;
				} else { // ������ ����� ������尡 ������ ��
					if (current.left != null) {
						Node leftMax = current.left;
						Node leftMaxParent = current;
						for (; leftMax.right != null; leftMaxParent = leftMax, leftMax = leftMax.right)
							;
						int maxValue = leftMax.val;
						if (leftMax == leftMaxParent.left)
							leftMaxParent.left = leftMax.left;
						else if (leftMax == leftMaxParent.right)
							leftMaxParent.right = leftMax.left;
						leftMax.left = null;
						current.val = maxValue;
					} else if (current.right != null) {
						Node rightMin = current.left;
						Node rightMinParent = current;
						for (; rightMin.right != null; rightMinParent = rightMin, rightMin = rightMin.left)
							;
						int minValue = rightMin.val;
						if (rightMin == rightMinParent.left)
							rightMinParent.left = rightMin.right;
						else if (rightMin == rightMinParent.right)
							rightMinParent.right = rightMin.right;
						rightMin.left = null;
						current.val = minValue;
					}
				}
				return true;
			} else
				return false;
		} else
			return false;
	}

	private int getkMinVal() {
		if (root == null)
			return Integer.MIN_VALUE;
		else {
			Node current = root;
			while (current.left != null)
				current = current.left;
			return current.val;
		}
	}

	private int getkMaxVal() {
		if (root == null)
			return Integer.MAX_VALUE;
		else {
			Node current = root;
			while (current.right != null)
				current = current.right;
			return current.val;
		}
	}

	public void printTree() {
		System.out.print("[Print tree]");
		System.out.printf("\nMin value: %d", getkMinVal());
		System.out.printf("\nMax value: %d", getkMaxVal());
		System.out.print("\nIn-order : ");
		printInOrder(this.root);
		System.out.print("\nPre-order : ");
		printPreOrder(this.root);
		System.out.print("\nPost-order : ");
		printPostOrder(this.root);
		System.out.print("\nLevel-order : ");
		printLevelOrder(this.root);
	}

	private void printInOrder(Node current) {
		if (current == null)
			return;
		else {
			System.out.print(current.val + " ");
			printInOrder(current.left);
			printInOrder(current.right);
		}
	}

	private void printPreOrder(Node current) {
		if (current == null)
			return;
		else {
			printPreOrder(current.left);
			System.out.print(current.val + " ");
			printPreOrder(current.right);
		}
	}

	private void printPostOrder(Node current) {
		if (current == null)
			return;
		else {
			printPostOrder(current.right);
			System.out.print(current.val + " ");
			printPostOrder(current.left);
		}
	}

	private void printLevelOrder(Node current) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				level.add(node.val);
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
			result.add(level);
		}
		System.out.println(result);
	}
}
