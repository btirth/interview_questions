class Solution {
    public int singleNumber(int[] nums) {
        /**
        2 ^ 2 ^ 3 ^ 2

        010
        010
        010
        110
         */

        int ans = 0;
        for(int i=0; i<32; i++) {
            int count = 0;
            for(int num: nums) {
                if((num & (1 << i)) != 0) {
                    count++;
                }
            }

            int rem = count % 3;
            if(rem > 0) {
                ans |= (1 << i);
            }
        } 

        return ans;
    }
}