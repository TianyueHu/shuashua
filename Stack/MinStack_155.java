

class MinStack_155{
	Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        stack.push(x);
        int min = (minStack.isEmpty()) ? (x) : (Math.min(x, minStack.peek()));
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}