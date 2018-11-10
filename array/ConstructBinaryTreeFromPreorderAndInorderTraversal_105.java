
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class ConstructBinaryTreeFromPreorderAndInorderTraversal_105{
	private int prePtr = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getNode(preorder, inorder, 0, preorder.length - 1);
    }
    
    private TreeNode getNode(int[] preorder, int[] inorder, int start, int end){
        TreeNode rootNode = null;
        if(prePtr < preorder.length && start <= end){
            int rootValue = preorder[prePtr];
            int i = start;
            for(; i <= end; ++i){
                if(inorder[i] == rootValue){
                    ++prePtr;
                    rootNode = new TreeNode(rootValue);
                    rootNode.left = getNode(preorder, inorder, start, i - 1);
                    rootNode.right = getNode(preorder, inorder, i + 1, end);
                    break;
                }
            }
        }
        return rootNode;
    }
}