/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 17-05-29 00:14
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        nodes.add(node);
        
        // put all nodes into a list, and create new nodes with same label
        int index = 0;
        while (index < nodes.size()) {
            UndirectedGraphNode current = nodes.get(index++);
            map.put(node, new UndirectedGraphNode(node.label));
            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        
        // connect new nodes together
        for (UndirectedGraphNode n : nodes) {
            // get current node's duplicate
            UndirectedGraphNode dupNode = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                // connect duplicated node other nodes accordingly
                dupNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}