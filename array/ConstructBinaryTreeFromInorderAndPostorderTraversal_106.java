
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class ConstructBinaryTreeFromInorderAndPostorderTraversal_106{
	private int postPtr;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postPtr = postorder.length - 1;
        return getNode(inorder, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode getNode(int[] inorder, int[] postorder, int start, int end){
        TreeNode node = null;
        if(postPtr >= 0 && start <= end){
            int i = end;
            for(; i >= start; --i){
                if(postorder[postPtr] == inorder[i]){
                    node = new TreeNode(postorder[postPtr]);
                    --postPtr;
                    node.right = getNode(inorder, postorder, i + 1, end);
                    node.left = getNode(inorder, postorder, start, i - 1);
                    break;
                }
            }
        }
        return node;
    }
}