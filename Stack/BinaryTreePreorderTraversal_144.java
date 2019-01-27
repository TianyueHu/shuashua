
 /* 
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class BinaryTreePreorderTraversal_144{
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        
        if(root == null)
            return lst;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null)
                continue;
            lst.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return lst;
    }
}