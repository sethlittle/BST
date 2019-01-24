package BST_A2;

public class BST_Playground {
	/*
	 * you will test your own BST implementation in here
	 *
	 * we will replace this with our own when grading, and will do what you
	 * should do in here... create BST objects, put data into them, take data
	 * out, look for values stored in it, checking size and height, and looking
	 * at the BST_Nodes to see if they are all linked up correctly for a BST
	 * 
	 */

	public static void main(String[] args) {

		// you should test your BST implementation in here
		// it is up to you to test it thoroughly and make sure
		// the methods behave as requested above in the interface

		// do not simple depend on the oracle test we will give
		// use the oracle tests as a way of checking AFTER you have done
		// your own testing

		// one thing you might find useful for debugging is a print tree method
		// feel free to use the printLevelOrder method to verify your trees
		// manually
		// or write one you like better
		// you may wish to print not only the node value, and indicators of what
		// nodes are the left and right subtree roots,
		// but also which node is the parent of the current node

		BST bst = new BST();
		bst.insert("alpha");
		System.out.println("empty(n): " + bst.empty());
		System.out.println("height(): " + bst.height());
		System.out.println("size(1): " + bst.size());

		bst.insert("beta");
		bst.insert("gamma");
		bst.insert("aaa");
		bst.insert("baaa");
		bst.insert("zeta");

		System.out.println("empty(n): " + bst.empty());
		System.out.println("height(3): " + bst.height());
		System.out.println("size(6): " + bst.size());

		BST bst2 = new BST();
		System.out.println("empty(y): " + bst2.empty());
		System.out.println("height(0): " + bst2.height());
		System.out.println("size(0): " + bst2.size());

		bst2.insert("hello");
		System.out.println("empty(n): " + bst2.empty());
		System.out.println("height(0): " + bst2.height());
		System.out.println("size(1): " + bst2.size());

		bst2.insert("deez");
		System.out.println("empty(n): " + bst2.empty());
		System.out.println("height(1): " + bst2.height());
		System.out.println("size(2): " + bst2.size());

		printInOrder(bst.root);
		System.out.println(" ");
		printInOrder(bst2.root);
		System.out.println(" ");

		bst.root.toString();
		System.out.println("hi");
		bst2.root.toString();

		printLevelOrder(bst);
		System.out.println(" ");

		System.out.println("height(3): " + bst.height());

		BST bst3 = new BST();
		bst3.insert("B");
		bst3.insert("A");
		bst3.insert("D");
		bst3.insert("C");
		bst3.insert("E");
		System.out.println("bst3 size(5)" + bst3.size());
		bst3.remove("B");
		bst3.remove("A");
		bst3.remove("D");
		bst3.remove("C");
		bst3.remove("E");
		System.out.println("bst3 size(0)" + bst3.size());

		BST b = new BST();
		b.insert("0");
		b.insert("C");
		b.insert("A");
		b.insert("B");
		b.insert("E");
		b.insert("D");
		System.out.print("b: ");
		printInOrder(b.getRoot());
		System.out.println("");
		System.out.print("b: ");
		printLevelOrder(b);
		System.out.println("");

		b.remove("C");
		System.out.print("b: ");
		printInOrder(b.getRoot());
		System.out.println("");
		System.out.print("b: ");
		printLevelOrder(b);

	}

	static void printLevelOrder(BST tree) {
		// will print your current tree in Level-Order...
		// https://en.wikipedia.org/wiki/Tree_traversal

		int h = tree.getRoot().getHeight(tree.getRoot());

		for (int i = 0; i <= h; i++) {
			printGivenLevel(tree.getRoot(), i);
		}

	}

	static void printGivenLevel(BST_Node root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.data + " ");
		else if (level > 0) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	static void printInOrder(BST_Node root) {
		// will print your current tree In-Order
		if (root != null) {
			printInOrder(root.getRight());
			System.out.print(root.getData() + " ");
			printInOrder(root.getLeft());
		}
	}
}