class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /**
        1,2,1,2,1 [n=5, n/3 = 2]
        
        1,1,1,2,2,2,3,3,3 [n=9, n/3 = 3]
        Can I say that at most 2 elements would appear more than n/3 times. Otherwise it would be equals to n/3.

        Can I use the same concept as majority element?
        -> element1 = 0, count1 = 0, element2 = 0, count2 = 0
        for(num: nums)
            if(num == element1) {
                count1++;
            } else if(num == element2) {
                count2++;
            } else if(count1 == 0) {
                element1 = num
                count1 = 1
            } else if(count2 == 0) {
                element2 = num
                count2 = 1
            } else {
                count1--
                count2--
            }

        > n/3 = 9/3 = 3
        [5,4,6,5,2,5,4,4,6]
        5 -> e1=5,c1=1,e2=-1,c2=0
        4 -> e1=5,c1=1,e2=4,c2=1
        6 -> e1=5,c1=0,e2=4,c2=0
        5 -> e1=5,c1=1,e2=4,c2=0
        2 -> e1=5,c1=1,e2=2,c2=1
        5 -> e1=5,c1=2,e2=2,c2=1
        4 -> e1=5,c1=1,e2=2,c2=0
        4 -> e1=5,c1=1,e2=4,c2=1
        6 -> e1=5,c1=1,e2=4,c2=1    
         */

        int n = nums.length;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;
        int c1 = 0;
        int c2 = 0;

        for(int num: nums) {
            if(e1 == num) {
                c1++;
            } else if(e2 == num) {
                c2++;
            } else if(c1 == 0) {
                e1 = num;
                c1++;
            } else if(c2 == 0) {
                e2 = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        // Verify if e1 and e2 is actual ans
        int finalCount1 = 0;
        int finalCount2 = 0;

        for(int num: nums) {
            if(num == e1) {
                finalCount1++;
            } else if(num == e2) {
                finalCount2++;
            }
        } 

        List<Integer> ans = new ArrayList<>();
        if(finalCount1 > n/3) {
            ans.add(e1);
        }

        if(finalCount2 > n/3) {
            ans.add(e2);
        }

        return ans;
    }
}