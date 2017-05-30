/**
 *
 * 4.0.1 Node
 *
 */
class Node {
	public int data;
	public int count;
	public Node[] children;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;

	public Node(int data) {
		this.data = data;
		this.count = 1;
		children = new Node[2];
	}

	public String toString() {
//		return "[" + data + "-" + count + "] ";
		return data + " ";
	}
}