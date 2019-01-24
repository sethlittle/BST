package BST_A2;

public class BST_Node {
	public String data;
	public BST_Node left;
	public BST_Node right;
	public BST_Node parent;

	BST_Node(String data) {
		this.data = data;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public boolean containsNode(String s) {
		if (s == null) {
			return false;
		}
		// there are 3 scenarios, the current node's value is equal to s, the
		// data is greater or the data is less

		if (data.compareTo(s) == 0) {
			return true;
		} else if (data.compareTo(s) > 0) {
			if (left == null) {
				return false;
			} else {
				return left.containsNode(s);
			}
		} else {
			if (right == null) {
				return false;
			} else {
				return right.containsNode(s);
			}
		}
	}

	public boolean insertNode(String s) {
		if (s == null) {
			return false;
		}

		// same logic as the contains method except if the left is null it
		// should become a new node with the data from the parameter, and the
		// same if it is supposed to be on the right if (s > data)

		if (data.compareTo(s) == 0) {
			return false;
		} else if (data.compareTo(s) > 0) {
			// string is to the left
			if (left == null) {
				left = new BST_Node(s);
				return true;
			} else {
				return left.insertNode(s);
			}
		} else {
			if (right == null) {
				right = new BST_Node(s);
				return true;
			} else {
				return right.insertNode(s);
			}
		}

	}

	public boolean removeNode(String s, BST_Node node) {
		if (s == null) {
			return false;
		}

		// there are 3 scenarios, if s > data, if s < data, or if they are
		// equal, and if they are equal we want to remove that node

		if (data.compareTo(s) > 0) {
			if (left != null) {
				// the value we want will be to the left, so we recursively call
				// remove on the left node, using this as a parent node and
				// passing it in
				return left.removeNode(s, this);
			} else {
				return false;
			}
		} else if (data.compareTo(s) < 0) {
			if (right != null) {
				// the value we want should be to the right, so we recursively
				// call remove on the right node, using this as a parent node in
				// the argument
				return right.removeNode(s, this);
			} else {
				return false;
			}
		} else {
			// the strings are equal so we want to remove the node, there are 4
			// different scenarios, the node we want to remove has
			// i) both leaves
			// ii) the right leaf
			// iii) the left leaf
			// iv) no leaves

			if (left != null && right != null) {
				// we copy the value of the maximum leaf to the left of the
				// desired removal node, and then we go and remove that node
				// from the left node passing this as a parent node argument
				data = left.findMax().getData();
				return left.removeNode(left.findMax().getData(), this);
			} else if (left == null && right != null) {
				// this indicates that the desired removal node only has a right
				// node, so if this is the right child of the parent child
				// parameter, we make the following right child the new right
				// child, and the same if left
				if (node.right == this) {
					node.right = right;
				} else {
					node.left = right;
				}
				return true;
			} else if (right == null && left != null) {
				// the reverse of the above, for the left node (because there is
				// only a left node)
				if (node.right == this) {
					node.right = left;
				} else {
					node.left = left;
				}
				return true;
			} else {
				// there are no leaves, so all we do is un-hook the leaf, we
				// test whether we are on the right or the left of the parent
				// node and we make whichever one we are working with null
				if (node.right == this) {
					node.right = null;
				} else {
					node.left = null;
				}
				return true;
			}
		}

	}

	public BST_Node findMin() {
		// this method travels down the left side of the tree until it hits
		// null, and this is the location of the minimum, by definition of the
		// binary search tree
		if (left == null) {
			return this;
		} else {
			return left.findMin();
		}

	}

	public BST_Node findMax() {
		// this method travels down the right side of the tree until it hits
		// null, and this is the location of the maximum, by definition of a
		// binary search tree
		if (right == null) {
			return this;
		} else {
			return right.findMax();
		}
	}

	public int getHeight(BST_Node node) {
		// this method returns the longest path to a leaf; so we will keep a
		// variable different paths, a right and a left path, and reset them to
		// 0 every time the method is called
		int leftH = 0;
		int rightH = 0;

		// if the left node is not null, add one to the leftH variable and add
		// that to another recursive call of getHeight with the parameter as the
		// left node, and then the same for the right
		if (node.left != null) {
			leftH++;
			leftH = leftH + getHeight(node.left);
		} else if (node.right != null) {
			rightH++;
			rightH = rightH + getHeight(node.right);
		}

		// once the left and right are both null, we want to return the greater
		// variable and then add one to it to include the current node
		if (leftH >= rightH) {
			return leftH + 1;
		} else {
			return rightH + 1;
		}

	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}
