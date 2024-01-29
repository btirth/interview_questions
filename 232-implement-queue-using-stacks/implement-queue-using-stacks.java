class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.add(x);
    }
    
    public int pop() {
        if(this.empty()) {
            return -1;
        }
        transfer();
        int val = s2.pop();
        transfer();
        return val;
    }
    
    public int peek() {
        if(this.empty()) {
            return -1;
        }
        transfer();
        int val = s2.peek();
        transfer();
        return val;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }

    void transfer() {
        if(s1.isEmpty()) {
            while(!s2.isEmpty()) {
                s1.add(s2.pop());
            }
        } else {
            while(!s1.isEmpty()) {
                s2.add(s1.pop());
            }
        }
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */