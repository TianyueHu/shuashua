class BinaryTreeInorderTraversal_94{
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Boolean> visit = new Stack<Boolean>();
        
        if(root != null){
            s.push(root);
            visit.push(false);
        }
            
        while (!s.isEmpty()){
            TreeNode top = s.peek();
            boolean visited = visit.pop();
            if (!visited && top.left != null){
                visit.push(true);
                s.push(top.left);
                visit.push(false);
            }
                
            else {
                lst.add(top.val);
                s.pop();
                if(top.right != null){
                    s.push(top.right);
                    visit.push(false);
                }
            }
        }
        return lst;
    }
}