/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinarySearchTreeIterator_173{

	TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        if(hasNext()){
            TreeNode parent = root, node;
            while(parent.left != null){
                node = parent.left;
                if(node.left == null){
                    parent.left = node.right;
                    return node.val;
                }
            }
            int val = root.val;
            root = root.right;
            return val;
        }
        return 0;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        return root == null ? false : true;
    }
}