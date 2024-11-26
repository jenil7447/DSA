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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSame(root,subRoot)){
            return true;
        }
        return (root.left!=null && isSubtree(root.left,subRoot)) || (root.right!=null && isSubtree(root.right,subRoot)) ;

    }
    boolean isSame(TreeNode r,TreeNode s){
        if(r == null && s == null) return true;
        if(r == null || s == null) return false;
        return  (r.val == s.val) && isSame(r.left,s.left) && isSame(r.right,s.right);
    }
}
