class MinStack {

    Stack<Integer> values;
    Stack<Integer> mins;

    public MinStack() {
        values = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        values.push(val);

        if (mins.isEmpty() || val <= mins.peek()) mins.push(val);
    }
    
    public void pop() {
        int removed = values.pop();

        if (!mins.isEmpty() && removed == mins.peek()) mins.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
