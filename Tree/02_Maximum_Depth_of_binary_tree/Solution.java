class Solution {
    public int maxDepth(TreeNode root) {
        return count(root);
    }
    int count(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftTree = count(root.left);
        int rightTree = count(root.right);

        return Math.max(leftTree, rightTree) + 1;
    }
}
