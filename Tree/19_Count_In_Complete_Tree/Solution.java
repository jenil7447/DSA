class Solution {
    public int countNodes(TreeNode root) {
        return count(root);
    }
    int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
}
