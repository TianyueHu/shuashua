
class SimplifyPath_71{
	public String simplifyPath(String path) {
        
        String[] paths = path.split("/");
        
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < paths.length; ++i){
            if(paths[i].length() == 0 || paths[i].equals(".")){
                continue;
            }
            else if(paths[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(paths[i]);
            }
        }
        String ret = "";
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            ret = ("/" + stack.pop()) + ret;
        }
        return ret;
    }
}