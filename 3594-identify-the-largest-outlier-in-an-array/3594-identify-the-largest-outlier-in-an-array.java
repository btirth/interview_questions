class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        int[] freq = new int[2001];
        for(int num: nums) {
            sum += num;
            freq[num + 1000]++;
        }
        
        int max = Integer.MIN_VALUE;
        /**
        sum + target + outlier = totalSum
        target + target + outlier = totalSum
        2 t + o = ts
        t = (ts - o)/2
        o = ts - 2t        
         */
        
        for(int num: nums) {
            if((sum-num)%2 != 0) {
                continue;
            }
            int sumNum = (sum - num) / 2;
            System.out.println(sum+" "+num+" "+sumNum);
            if(sumNum>=-1000 && sumNum <= 1000 && freq[sumNum + 1000] > 0) {
                if(num == sumNum && freq[sumNum + 1000] <= 1) {
                    continue;
                }
                max = Math.max(num, max);
            }
        }

        return max;
    }
}