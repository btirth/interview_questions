class Solution {
    List<Integer> order = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        
        
        addNumbers(n, 1);

        return order;
    }

    void addNumbers(int n, int pre) {
        
        for(int i=0; i<10; i++) {
            int num = pre + i;
            if(num > n) {
                return;
            }
            
            if(num != 10 || !order.contains(num)) {
                order.add(num);
                if(num*10 <= n) {
                    addNumbers(n, num*10);
                } 
            }
               
        }
    }
}