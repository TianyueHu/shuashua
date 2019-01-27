 /* 
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class BinaryTreeZigzagLevelOrderTraversal_103{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) 
            return ret;
        
        List<Integer> lst = new ArrayList<Integer>();
        rightStack.push(root);
        
        while (!leftStack.isEmpty() || !rightStack.isEmpty()){
            if(!leftStack.isEmpty()){
                while(!leftStack.isEmpty()){
                    TreeNode node = leftStack.pop();
                    lst.add(node.val);
                    if(node.right != null)
                        rightStack.push(node.right);
                    if(node.left != null)
                        rightStack.push(node.left);
                }
                ret.add(lst);
                lst = new ArrayList<Integer>();
            }
            else{
                while(!rightStack.isEmpty()){
                    TreeNode node = rightStack.pop();
                    lst.add(node.val);
                    if(node.left != null)
                        leftStack.push(node.left);
                    if(node.right != null)
                        leftStack.push(node.right);
                }
                ret.add(lst);
                lst = new ArrayList<Integer>();
            }
        }
        
        return ret;
    }
}