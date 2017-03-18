/**
 *
 * 4.1 Route Between Nodes
 *     Given a directed graph, design an algorithm to find out whether there is a route
 *     between two nodes.
 *
 */
import java.util.ArrayList;;

class Node {
    int data;
    public enum STATE {VISITED, UNVISITED, VISITING}
    ArrayList<Node> nodes = null;
    STATE state;
    
    public Node(int d) {
        this.data = d;
        nodes = new ArrayList<Node>();
        state = STATE.UNVISITED;
    }
}

class Graph {
    public Node root;
    
    public Graph() {
        root = null;
    }
}

class RouteBetweenNodes {
    public static boolean BFS(Node start, Node end) {
        if (start == end) {
            return true;
        }
        
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(start);
        start.state = Node.STATE.VISITED;
        
        while (!nodes.isEmpty()) {
            Node node = nodes.remove(0);
            if (node != null) {
                for (Node child : node.nodes) {
                    if (child.state == Node.STATE.UNVISITED) {
                        child.state = Node.STATE.VISITING;
                        nodes.add(child);
                    } else if (child == end) {
                        return true;
                    }
                }
            }
            node.state = Node.STATE.VISITED;
        }
        return false;
    }
    
	public static void main(String[] args) {
		
	}
}