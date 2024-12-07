/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: if the root is null, there's nothing to delete
        if (root == null) {
            return null;
        }
        
        // If the key to delete is smaller than the root's value, 
        // the target node must be in the left subtree.
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If the key to delete is greater than the root's value, 
        // the target node must be in the right subtree.
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // If the current node matches the key, we need to delete this node.
        else {
            // Case 1: Node has no left child, return the right subtree (may be null).
            if (root.left == null) {
                return root.right;
            }
            // Case 2: Node has no right child, return the left subtree (may be null).
            else if (root.right == null) {
                return root.left;
            }
            // Case 3: Node has both children.
            // Find the minimum node in the right subtree to replace the current node.
            TreeNode minNode = findMin(root.right);
            // Replace the value of the current node with the value of the minimum node.
            root.val = minNode.val;
            // Delete the minimum node from the right subtree recursively.
            root.right = deleteNode(root.right, minNode.val);
        }
        // Return the updated root.
        return root;
    }

    // Helper function to find the minimum value node in a given subtree.
    TreeNode findMin(TreeNode node) {
        // Traverse left until we find the leftmost node.
        while (node.left != null) {
            node = node.left;
        }
        // Return the leftmost (minimum value) node.
        return node;
    }
}
