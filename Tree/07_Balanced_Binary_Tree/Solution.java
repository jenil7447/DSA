class Solution {
    public boolean isBalanced(TreeNode root) {

        return balanced(root) != -1;
    }

    int balanced(TreeNode root) {
        if (root == null) return 0; 

        int left = balanced(root.left);
        if (left == -1) return -1; 

        int right = balanced(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        
        return Math.max(left, right) + 1;
    }
}
