
class  ValidParentheses_20{
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(isLeft(ch)){
                stack.push(ch);
            }
            else if(!stack.isEmpty()){
                char left = stack.pop();
                if(isMatch(left, ch))
                    continue;
                else
                    return false;
            }
            else{
                return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else 
            return false;
    }
    
    public boolean isLeft(char ch){
        if(ch == '(' || ch == '{' || ch == '[')
            return true;
        return false;
        
    }
    
    public boolean isMatch(char left, char right){
        if((left == '(' && right == ')') ||
           (left == '[' && right == ']') ||
           (left == '{' && right == '}'))
            return true;
        return false;
    }
}