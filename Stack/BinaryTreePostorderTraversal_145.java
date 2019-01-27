class BinaryTreePostorderTraversal_145{
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        if(root == null)
            return lst;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> vStack = new Stack<Integer>();
        
        stack.push(root);
        vStack.push(0);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int visit = vStack.pop();
            switch (visit){
                case 0:
                    if(node.left != null){
                        stack.push(node);
                        vStack.push(1);
                        stack.push(node.left);
                        vStack.push(0);
                        break;
                    }
                    
                case 1:
                    if(node.right != null){
                        stack.push(node);
                        vStack.push(2);
                        stack.push(node.right);
                        vStack.push(0);
                        break;
                    }
                case 2:
                    lst.add(node.val);
                    
            }
        }
        return lst;
    }
}