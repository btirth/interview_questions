class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int prod1 = 1;
        int prod2 = 1;  
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                prod1 = 1;
                prod2 = 1;
                ans = Math.max(ans, 0);
                continue;
            }

            int p1 = prod1*nums[i];
            int p2 = prod2*nums[i];
            
            if(p1>0 && p2>0) {
                prod1 = Math.max(p1, p2);
                prod2 = Math.max(p1, p2);
                ans = Math.max(ans, Math.max(prod1, prod2));
            } else if(p1<0 && p2<0) {
                prod1 = 1;
                prod2 = Math.min(p1, p2);
                ans = Math.max(ans, prod2);
            } else if(p1<0) {
                prod2 = p1;
                prod1 = p2;
                ans = Math.max(ans, Math.max(prod1, prod2));
            } else {
                prod1 = p1;
                prod2 = p2;
                ans = Math.max(ans, Math.max(prod1, prod2));
            }
        }

        return ans;
    }
}