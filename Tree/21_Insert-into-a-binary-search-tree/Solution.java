class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val); // Base case: insert at the correct position
        insertNode(root, val); // Helper function to recursively insert the value
        return root;
    }

    void insertNode(TreeNode root, int val) {
        if (root.val < val) {
            // If the value to be inserted is greater, go to the right subtree
            if (root.right == null) 
                root.right = new TreeNode(val);
            else 
                insertNode(root.right, val);
        } else {
            // If the value to be inserted is smaller, go to the left subtree
            if (root.left == null) 
                root.left = new TreeNode(val);
            else 
                insertNode(root.left, val); // Corrected the recursive call direction
        }
    }
}
