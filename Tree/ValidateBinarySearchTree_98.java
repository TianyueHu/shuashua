/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ValidateBinarySearchTree_98{
	public boolean isValidBST(TreeNode root) {
        int max = Integer.MIN_VALUE;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Boolean> visit = new Stack<Boolean>();
        
        if(root != null){
            s.push(root);
            visit.push(false);
        }
        boolean init = false;
        while (!s.isEmpty()){
            TreeNode top = s.peek();
            boolean visited = visit.pop();
            if (!visited && top.left != null){
                visit.push(true);
                s.push(top.left);
                visit.push(false);
            }
                
            else {
                if(max < top.val || !init){
                    max = top.val;
                    init = true;
                }
                else 
                    return false;
                s.pop();
                if(top.right != null){
                    s.push(top.right);
                    visit.push(false);
                }
            }
        }
        return true;
    }
}