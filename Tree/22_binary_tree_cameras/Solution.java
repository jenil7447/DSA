class Solution {
    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        // If the root itself is not covered, we need an additional camera
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    // Return states:
    // 0 -> Node needs a camera
    // 1 -> Node is covered (no camera at this node, but it's monitored)
    // 2 -> Node has a camera
    private int dfs(TreeNode node) {
        if (node == null) {
            return 1; // Null nodes are considered covered
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // If any child needs a camera, place a camera here
        if (left == 0 || right == 0) {
            cameras++;
            return 2;
        }

        // If either child has a camera, this node is covered
        if (left == 2 || right == 2) {
            return 1;
        }

        // Otherwise, this node needs a camera
        return 0;
    }
}
