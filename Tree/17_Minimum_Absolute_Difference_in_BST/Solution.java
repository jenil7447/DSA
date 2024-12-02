class Solution {
    int minDifference = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDifference;
    }
    void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(prev != null){
            minDifference = Math.min(minDifference,Math.abs(root.val - prev.val));
        }
        prev = root;
        inOrder(root.right);

    }
}
