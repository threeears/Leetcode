class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack = new Stack<Integer>();  


    MinStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())  
            minStack.push(x); 
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek()))  
            minStack.pop();  
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
