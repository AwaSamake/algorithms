/**
 *
 * 297. Serialize and Deserialize Binary Tree
 *    Serialization is the process of converting a data structure or object into a
 *    sequence of bits so that it can be stored in a file or memory buffer, or
 *    transmitted across a network connection link to be reconstructed later in the
 *    same or another computer environment.
 *
 *    Design an algorithm to serialize and deserialize a binary tree. There is no
 *    restriction on how your serialization/deserialization algorithm should work. You
 *    just need to ensure that a binary tree can be serialized to a string and this
 *    string can be deserialized to the original tree structure.
 *
 *    For example, you may serialize the following tree
 *
 *        1
 *       / \
 *      2   3
 *         / \
 *        4   5
 *    as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary
 *    tree. You do not necessarily need to follow this format, so please be creative
 *    and come up with different approaches yourself.
 *    Note: Do not use class member/global/static variables to store states. Your
 *    serialize and deserialize algorithms should be stateless.
 *
 */

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserialize(nodes);
    }

    public TreeNode deserialize(String[] nodes) {
        if (index >= nodes.length || "#".equals(nodes[index])) {
            index++;
            return null;
        }
        int value = Integer.valueOf(nodes[index]);
        index++;
        TreeNode node = new TreeNode(value);
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));