class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        /**
        Cases:
        sum1 == sum2 
    
            zero1 == 0 OR zero2 == 0 (Only one)
                return -1

            return sum1 + max(zero1, zero2);    


        sum1 > sum2
            zero2 == 0
                return -1

            return max(sum1 + zero1, sum2 + zero2)         
        
        
        sum2 > sum1
            zero1 == 0
                return -1

            return sum2 + zero2    

         */


        long sum1 = 0;
        long sum2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        long zero1 = 0;
        long zero2 = 0;
        for(int i=0; i<n1; i++) {
            sum1 += nums1[i];
            if(nums1[i] == 0) {
                zero1++;
            }
        }

        for(int i=0; i<n2; i++) {
            sum2 += nums2[i];
            if(nums2[i] == 0) {
                zero2++;
            }
        }


        if(sum1 == sum2) {
            if(zero1 == zero2) {
                return sum1 + zero1;
            } else if(zero1 == 0 || zero2 == 0) {
                return -1;
            } 
                
            return sum1 + Math.max(zero1, zero2);
        }


        if(sum1 + zero1 > sum2) {
            if(zero2 == 0) {
                return -1;
            }
        }

        if(sum2 + zero2 > sum1) {
            if(zero1 == 0) {
                return -1;
            }
        }

        return Math.max(sum1+zero1, sum2+zero2);

    }
}