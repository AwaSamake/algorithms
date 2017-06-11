/**
 *
 * 4.3 List of Depths
 *     Given a binary tree, design an algorithm which creates a linked list of all the nodes
 *     at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 */
import java.util.LinkedList;
import java.util.Random;

class ListOfDepths {
    public static LinkedList< LinkedList<Node> > listOfDepthsDFS(Tree tree) {
        LinkedList< LinkedList<Node> > lists = new LinkedList<>();
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(tree.root);
        lists.add(list);
        listOfDepthsDFS(tree.root, lists, 1);
        return lists;
    }
    
    public static void listOfDepthsDFS(Node parent, LinkedList< LinkedList<Node> > lists, int curDepth) {
        if (parent == null) {
            return;
        }
        if (lists.size() <= curDepth) {
            lists.add(new LinkedList<Node>());
        }
        LinkedList<Node> list = lists.get(curDepth);
        for (Node child : parent.children) {
            if (child != null) {
                list.add(child);
                listOfDepthsDFS(child, lists, curDepth + 1);
            }
        }
        if (list.size() > 0) {
            lists.set(curDepth, list);
        } else {
            lists.remove(curDepth);
        }
    }
    
    public static LinkedList< LinkedList<Node> > listOfDepthsBFS(Tree tree) {
        LinkedList< LinkedList<Node> > lists = new LinkedList< LinkedList<Node> >();
        if (tree.root == null) {
            return lists;
        }
        
        LinkedList<Node> list = new LinkedList<Node>(), nextLevel;
        list.add(tree.root);
        
        while (!list.isEmpty()) {
            lists.add(list);
            nextLevel = new LinkedList<Node>();
            for (Node element : list) {
                for (Node child: element.children) {
                    if (child != null) {
                        nextLevel.add(child);
                    }
                }
            }
            list = nextLevel;
        }
        return lists;
    }
    
	public static void main(String[] args) {
		Random rand = new Random();
        Tree tree = new Tree();
        
        for (int i = 0; i < 100; ++i) {
            tree.insert(Math.abs(rand.nextInt() % 100));
        }
        tree.BFS();
        
        LinkedList< LinkedList<Node> > lists = new LinkedList<>();
        lists = listOfDepthsDFS(tree);
        System.out.print(lists.toString());
        
        lists = listOfDepthsBFS(tree);
        System.out.print(lists.toString());
        
	}
}