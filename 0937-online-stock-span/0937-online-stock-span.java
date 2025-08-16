class StockSpanner {
    /**
    [7,2,1,2]
    2
    [7,2,1,2,2] -> 4
    
    
    [100] -> 1
    [80] -> 1
    [60] -> 1
    [70] -> 2
    [60] -> 1
    [75] -> 4
    85 -> 6


    Stack -> (100,1)(80,1)(60,1)
    (100,1)(80,1)(70,2)(60,1)


    
     */

    Stack<int[]> stack; 
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            int[] prev = stack.pop();
            span += prev[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */