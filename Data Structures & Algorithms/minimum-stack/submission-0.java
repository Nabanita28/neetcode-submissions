class MinStack {

    Stack<Integer> stack ;
    Stack<Integer> auxStack;

    public MinStack() {
        stack = new Stack<>();
        auxStack = new Stack<>();
    }
    
    public void push(int val) {
       int newMin = stack.isEmpty() ? val : Math.min(val, auxStack.peek());
       stack.push(val);
       auxStack.push(newMin);
    }
    
    public void pop() {
        if(!stack.isEmpty()){
        stack.pop();
        auxStack.pop();
        }
    }
    
    public int top() {
            return stack.peek();
    }
    
    public int getMin() {
            return auxStack.peek();
        
        
    }
}
