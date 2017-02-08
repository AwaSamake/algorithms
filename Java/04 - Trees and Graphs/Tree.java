/**
 *
 * 4.0.2 Tree
 *
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

class Tree {
	private Node root;
	private static final int LEFT = 0;
	private static final int RIGHT = 1;

	public Tree() {
		root = null;
	}
	
	public Tree(Node root) {
		this.root = root;
	}

	public void insert(int d) {
		if (root == null) {
			root = new Node(d);
		} else if (d == root.data) {
			root.count++;
		} else if (d < root.data) {
			if (root.children[LEFT] == null) {
				root.children[LEFT] = new Node(d);
			} else {
				insert(root.children[LEFT], d);
			}
		} else {
			if (root.children[RIGHT] == null) {
				root.children[RIGHT] = new Node(d);
			} else {
				insert(root.children[RIGHT], d);
			}
		}
	}

	private void insert(Node parent, int d) {
		if (d == parent.data) {
			parent.count++;
		} else if (d < parent.data) {
			if (parent.children[LEFT] == null) {
				parent.children[LEFT] = new Node(d);
			} else {
				insert(parent.children[LEFT], d);
			}
		} else {
			if (parent.children[RIGHT] == null) {
				parent.children[RIGHT] = new Node(d);
			} else {
				insert(parent.children[RIGHT], d);
			}
		}
	}
	
	public void preOrderPrint() {
		if (root == null) {
			System.out.println("Tree is empty.");
		} else {
			System.out.print(root.toString());
			preOrderPrint(root.children[LEFT]);
			preOrderPrint(root.children[RIGHT]);
		}
	}

	private void preOrderPrint(Node parent) {
		if (parent == null) {
			return;
		}
		System.out.print(parent.toString());
		preOrderPrint(parent.children[LEFT]);
		preOrderPrint(parent.children[RIGHT]);
	}

	public void inOrderPrint() {
		if (root == null) {
			System.out.println("Tree is empty.");
		} else {
			inOrderPrint(root.children[LEFT]);
			System.out.print(root.toString());
			inOrderPrint(root.children[RIGHT]);
		}
	}

	private void inOrderPrint(Node parent) {
		if (parent == null) {
			return;
		}
		inOrderPrint(parent.children[LEFT]);
		System.out.print(parent.toString());
		inOrderPrint(parent.children[RIGHT]);
	}

	public void postOrderPrint() {
		if (root == null) {
			System.out.println("Tree is empty.");
		} else {
			postOrderPrint(root.children[LEFT]);
			postOrderPrint(root.children[RIGHT]);
			System.out.print(root.toString());
		}
	}

	private void postOrderPrint(Node parent) {
		if (parent == null) {
			return;
		}
		postOrderPrint(parent.children[LEFT]);
		postOrderPrint(parent.children[RIGHT]);
		System.out.print(parent.toString());
	}

	public void DFS() {
		if (root == null) {
			return;
		}
		System.out.print(root.toString());
		for (int i = 0; i < root.children.length; ++i) {
			DFS(root.children[i]);
		}
	}

	private void DFS(Node parent) {
		if (parent == null) {
			return;
		}
		System.out.print(parent.toString());
		for (int i = 0; i < parent.children.length; ++i) {
			DFS(parent.children[i]);
		}
	}

	public void BFS() {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node node;
		while (!queue.isEmpty()) {
			node = queue.pollFirst();
			if (node != null) {
				System.out.print(node.toString());
				for (Node child: node.children) {
					queue.add(child);
				}
			}
		}
	}
}


class TreeTest {
	public static void main(String[] args) {
		Random rand = new Random();

		Tree tree = new Tree();

		for (int i = 0; i < 100; ++i) {
			tree.insert(Math.abs(rand.nextInt() % 100));
		}

		System.out.println("\nPre Order");
		tree.preOrderPrint();

		System.out.println("\n\nIn Order");
		tree.inOrderPrint();

		System.out.println("\n\nPost Order");
		tree.postOrderPrint();

		System.out.println("\n\nDFS");
		tree.DFS();

		System.out.println("\n\nBFS");
		tree.BFS();
	}
}