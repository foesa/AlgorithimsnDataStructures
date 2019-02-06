
/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author 
 *
 *************************************************************************/

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root; // root of BST

	/**
	 * Private node class.
	 */
	private class Node {
		private Key key; // sorted by key
		private Value val; // associated data
		private Node left, right; // left and right subtrees
		private int N; // number of nodes in subtree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	// is the symbol table empty?
	public boolean isEmpty() {
		return size() == 0;
	}

	// return number of key-value pairs in BST
	public int size() {
		return size(root);
	}

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	/**
	 * Search BST for given key. Does there exist a key-value pair with given key?
	 *
	 * @param key the search key
	 * @return true if key is found and false otherwise
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}

	public boolean contains(Key key, Node node) {
		return get(node, key) != null;
	}

	/**
	 * Search BST for given key. What is the value associated with given key?
	 *
	 * @param key the search key
	 * @return value associated with the given key if found, or null if no such key
	 *         exists.
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	/**
	 * Insert key-value pair into BST. If key already exists, update with new value.
	 *
	 * @param key the key to insert
	 * @param val the value associated with key
	 */
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	/**
	 * Tree height.
	 *
	 * Asymptotic worst-case running time using Theta notation: TODO
	 *
	 * @return the number of links from the root to the deepest leaf.
	 *
	 *         Example 1: for an empty tree this should return -1. Example 2: for a
	 *         tree with only one node it should return 0. Example 3: for the
	 *         following tree it should return 2. B / \ A C \ D
	 */
	public int height() {
		if (!(root == null)) {
			int height = heightrec(this.root);
			return height;
		}
		return -1;
	}

	public int heightrec(Node node) {
		if (node != null) {
			int ldepth = -1;
			ldepth = heightrec(node.left)  ;
			int rdepth = -1;	
			rdepth = heightrec(node.right) ;
			if (ldepth > rdepth) {
				return (ldepth + 1);
			} else {
				return (rdepth + 1);
			}
		}
		return -1;
	}

	/**
	 * Median key. If the tree has N keys k1 < k2 < k3 < ... < kN, then their median
	 * key is the element at position (N+1)/2 (where "/" here is integer division)
	 *
	 * @return the median key, or null if the tree is empty.
	 */
	public Key median() {
		if (isEmpty()) {
			return null;
		} else {
			ArrayList<Node> alist = InorderTrav();
			int size = alist.size();
			if(alist.size() == 1) {
				return alist.get(1).key;
			}
			else {
				Key returnKey = alist.get((size + 1) / 2).key;
				return returnKey;
			}
		}
	}

	public ArrayList<Node> InorderTrav() {
		Node current = this.root;
		ArrayList<Node> alist = new ArrayList<Node>();
		while (current != null) {
			if (current.left == null) {
				alist.add(current);
				current = current.right;
			} else {
				Node pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
					if (pre.right == null) {
						pre.right = current;
						current = current.left;
					} else {
						pre.right = null;
						alist.add(current);
						current = current.right;
					}
				}
			}
		}
		return alist;
	}

	/**
	 * Print all keys of the tree in a sequence, in-order. That is, for each node,
	 * the keys in the left subtree should appear before the key in the node. Also,
	 * for each node, the keys in the right subtree should appear before the key in
	 * the node. For each subtree, its keys should appear within a parenthesis.
	 *
	 * Example 1: Empty tree -- output: "()" Example 2: Tree containing only "A" --
	 * output: "(()A())" Example 3: Tree: B / \ A C \ D
	 *
	 * output: "((()A())B(()C(()D())))"
	 *
	 * output of example in the assignment:
	 * (((()A(()C()))E((()H(()M()))R()))S(()X()))
	 *
	 * @return a String with all keys in the tree, in order, parenthesized.
	 */
	public String printKeysInOrder() {
		if (isEmpty()) {
			return "()";
		} else {
			String ret = "";
			ret = printKeysInOrder(root, ret);
			return ("(" + ret + ")");
		}
	}

	public String printKeysInOrder(Node node, String res) {
		if (node == null) {
			return "";
		}

		res = res + "(" + printKeysInOrder(node.left, res) + ")" + node.key + "(" + printKeysInOrder(node.right, res) + ")";

		return res;
	}

	/**
	 * Pretty Printing the tree. Each node is on one line -- see assignment for
	 * details.
	 *
	 * @return a multi-line string with the pretty ascii picture of the tree.
	 *         (((()A(()C()))E((()H(()M()))R()))S(()X()))
	 */
	public String prettyPrintKeys() {
		if(this.root == null) {
			return "-null";
		}
		 return prettyPrintKeys(this.root, "");
	}
	 private String prettyPrintKeys(Node node, String prefix) {
	        if (node == null) {
	            return  prefix + "-null\n";
	        }

	        String resultString = prefix
	                + "-"
	                + node.key
	                + "\n"
	                + prettyPrintKeys(node.left, prefix + " |")
	                + prettyPrintKeys(node.right, prefix + "  ");

	        return resultString;
	    }

	/**
	 * Deteles a key from a tree (if the key is in the tree). Note that this method
	 * works symmetrically from the Hibbard deletion: If the node to be deleted has
	 * two child nodes, then it needs to be replaced with its predecessor (not its
	 * successor) node.
	 * 
	 * @param key the key to delete
	 */
	public void delete(Key key) {
		if (contains(key)) {
			this.root = deletekey(key, this.root);
		}
	}

	public Node deletekey(Key key, Node node) {
		Node parent = null;

		// start with root node
		Node curr = node;

		// search key in BST and set its parent pointer
		while (curr != null && curr.key != key)
		{
			// update parent node as current node
			parent = curr;

			// if given key is less than the current node, go to left subtree
			// else go to right subtree
			if (key.compareTo(curr.key) < 0) {
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
		}

		// return if key is not found in the tree
		if (curr == null) {
			return node;
		}

		// Case 1: node to be deleted has no children i.e. it is a leaf node
		if (curr.left == null && curr.right == null)
		{
			// if node to be deleted is not a root node, then set its
			// parent left/right child to null
			if (curr != node) {
				if (parent.left == curr) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			// if tree has only root node, delete it and set root to null
			else {
				node = null;
			}
		}

		// Case 2: node to be deleted has two children
		else if (curr.left != null && curr.right != null)
		{
			// find its in-order predecessor node 
			Node predeccessor  = maxVal(curr.left);

			// store successor value
			Key val = predeccessor.key;

			// recursively delete the predecessor.
			deletekey(predeccessor.key,node);

			// Copy the value of predecessor to current node
			curr.key = val;
		}

		// Case 3: node to be deleted has only one child
		else
		{
			// find child node
			Node child = (curr.left != null)? curr.left: curr.right;

			// if node to be deleted is not a root node, then set its parent
			// to its child
			if (curr != node)
			{
				if (curr == parent.left) {
					parent.left = child;
				} else {
					parent.right = child;
				}
			}

			// if node to be deleted is root node, then set the root to child
			else {
				node = child;
			}
		}

		return node;
	}

	public Node maxVal(Node theNode) {
		 if (theNode.right == null) return theNode;
	        else return maxVal(theNode.right);
	}
}