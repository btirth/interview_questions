class Solution {
    List<Integer> order = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1; i<10; i++) {
            if(i<=n) {
                order.add(i);
            }
            
            if(i*10 <= n) {
                addNumbers(n, i*10);
            } 
        }
        
        return order;
    }

    void addNumbers(int n, int pre) {
        
        for(int i=0; i<10; i++) {
            int num = pre + i;
            if(num > n) {
                return;
            }
            
            order.add(num);
            if(num*10 <= n) {
                addNumbers(n, num*10);
            } 
        }
    }
}