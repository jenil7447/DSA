public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return ""; // If the root is null, return an empty string.
        
        Queue<TreeNode> q = new LinkedList<>(); // Initialize a queue for level-order traversal.
        StringBuilder res = new StringBuilder(); // StringBuilder to store the serialized string.
        
        q.add(root); // Start with the root node.
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll(); // Retrieve and remove the head of the queue.
            if (node == null) {
                res.append("n "); // Append "n" for null nodes.
                continue;
            }
            
            res.append(node.val + " "); // Append the value of the node.
            q.add(node.left); // Add the left child to the queue.
            q.add(node.right); // Add the right child to the queue.
        }
        
        return res.toString(); // Return the serialized tree as a string.
    }
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null; // If the input string is empty, return null.
        
        Queue<TreeNode> q = new LinkedList<>(); // Initialize a queue for constructing the tree.
        String[] values = data.split(" "); // Split the serialized string into values.
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0])); // Create the root node.
        q.add(root); // Add the root node to the queue.
        
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll(); // Retrieve and remove the parent node.
            
            if (!values[i].equals("n")) { // If the value is not "n" (null):
                TreeNode left = new TreeNode(Integer.parseInt(values[i])); // Create the left child.
                parent.left = left; // Attach the left child.
                q.add(left); // Add the left child to the queue.
            }
            
            if (!values[++i].equals("n")) { // If the value is not "n" (null):
                TreeNode right = new TreeNode(Integer.parseInt(values[i])); // Create the right child.
                parent.right = right; // Attach the right child.
                q.add(right); // Add the right child to the queue.
            }
        }
        
        return root; // Return the reconstructed tree.
    }
}
