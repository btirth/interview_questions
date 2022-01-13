/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 
Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
 
Constraints:
    Methods pop, top and getMin operations will always be called on non-empty stacks.
*/

// Using array
class MinStack {
    int[] stack = new int[10000];
    int[] min = new int[10000];
    int topPtr;
    int minPtr;
    /** initialize your data structure here. */
    public MinStack() {
        topPtr = -1;
        minPtr = -1;
    }
    
    public void push(int val) {
        stack[++topPtr] = val;
        if(minPtr == -1 || min[minPtr] > val) {
            min[++minPtr] = val;
        } else {
            min[minPtr+1] = min[minPtr];
            minPtr++;
        }
    }
    
    public void pop() {
        --topPtr;
        --minPtr;
    }
    
    public int top() {
        return stack[topPtr];
    }
    
    public int getMin() {
        return min[minPtr];
    }
}


// Using Stack
class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    
    public MinStack() {
        s1  = new Stack<Integer>();
        s2  = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.s1.add(x);
        if(s2.isEmpty() || x<=s2.peek()) {
            this.s2.add(x);
            
        }
    }
    
    public void pop() {
        int top = this.s1.pop();
        
        if(!s2.isEmpty() && this.s2.peek()==top) {
            this.s2.pop();
        }
    }
    
    public int top() {
        return this.s1.peek();
    }
    
    public int getMin() {
        return this.s2.peek();
    }
}



//Using List
class MinStack {

    /** initialize your data structure here. */
    List<Integer> s1;
    List<Integer> s2;
    int i,j,min;
    
    public MinStack() {
        s1  = new ArrayList<Integer>();
        s2  = new ArrayList<Integer>();
        i = 0;
        j = 0;
    }
    
    public void push(int x) {
        s1.add(x);
        i++;
        if(j==0) {
            min = x;
            s2.add(x);
            j++;
        } else if(min>=x) {
            s2.add(x);
            min = x;
            j++;
        }
    }
    
    public void pop() {
        int r = s1.remove(i-1);
        i--;
        
        if(min==r) {
            if(j>=0) {
                s2.remove(j-1);    
            }
            
            j--;
            if(j>0) {
                min = s2.get(j-1);    
            }
        }
    }
    
    public int top() {
        return s1.get(i-1);
    }
    
    public int getMin() {
        return min;
    }
}
