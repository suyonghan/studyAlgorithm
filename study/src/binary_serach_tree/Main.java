package binary_serach_tree;

public class Main {
	public static void main(String[] args) {
		int arr[] = { 8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15 };
		BinarySerachTree bst = new BinarySerachTree();
		for (int i = 0; i < arr.length; i++) {
			bst.add(arr[i]);
		}

		bst.printTree();
		System.out.println();
		System.out.print("\n--------------------");
		System.out.print("\nremove data : " + 4);
		bst.remove(4);
		System.out.print("\nremove data : " + 15);
		bst.remove(15);
		System.out.print("\nremove data : " + 2);
		bst.remove(2);
		System.out.println("\n-------------------\n");
		bst.printTree();
	}
}
