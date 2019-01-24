package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	public int size;

	public BST() {
		size = 0;
		root = null;
	}

	@Override
	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {
		if (s == null) {
			return false;
		}

		// if there is no root, this means the root is empty, and the next added
		// item needs to be placed in the root location, and the size needs to
		// be increased by 1

		if (root == null) {
			root = new BST_Node(s);
			size++;
			return true;
		}

		boolean output = root.insertNode(s);

		// this is written in this logic in order to count the size, therefore
		// the insert is only done once, but the size is incremented

		if (output) {
			size++;
		}
		return output;
	}

	@Override
	public boolean remove(String s) {

		if (root == null) {
			return false;
		} else if (root.data.compareTo(s) == 0) {
			// root is the node that needs to be removed
			// create a temporary new root and pass it in as the parent node to
			// the actual root

			BST_Node temp = new BST_Node("");
			temp.right = root;
			boolean output = root.removeNode(s, temp);
			root = temp.right;
			// same logic as insert for the size, you need to only decrease it
			// by 1 if it is a successful remove
			if (output) {
				size--;
			}
			return output;
		} else {
			if (root.removeNode(s, null)) {
				size--;
			}
			return root.removeNode(s, null);
		}
	}

	@Override
	public String findMin() {
		if (root == null) {
			throw new RuntimeException("root is null");
		}
		return root.findMin().getData();
	}

	@Override
	public String findMax() {
		if (root == null) {
			throw new RuntimeException("root is null");
		}
		return root.findMax().getData();
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public boolean contains(String s) {
		if (s == null) {
			return false;
		}
		return root.containsNode(s);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		if (root == null) {
			return 0;
		}
		if (empty()) {
			return 0;
		}

		return root.getHeight(root);

	}

}
