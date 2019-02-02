
class BinaryTreeLevelOrderTraversal_102{
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        if(root == null)
            return lists;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> lst = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if(node != null){
                lst.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            else{
                lists.add(lst);
                if(!queue.isEmpty()){
                    queue.offer(null);
                    lst = new ArrayList<Integer>();
                }
            }
        }
        return lists;
    }
}