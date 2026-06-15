class MinStack {

    private Stack<Integer> values;
    private Stack<Integer> mins;
    
    public MinStack() {
        values = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        if (mins.isEmpty() || val <= mins.peek()) mins.push(val);
        else mins.push(mins.peek());

        values.push(val);
    }
    
    public void pop() {
        mins.pop();

        values.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
