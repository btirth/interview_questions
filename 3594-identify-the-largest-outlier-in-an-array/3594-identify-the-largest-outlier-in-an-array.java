class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        int[] freq = new int[2001];
        for(int num: nums) {
            sum += num;
            freq[num + 1000]++;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int num: nums) {
            int outlier = sum - (num*2);
            if(outlier>=-1000 && outlier <= 1000 && freq[outlier + 1000] > 0) {
                if(num == outlier && freq[outlier + 1000] == 1) {
                    continue;
                }
                
                max = Math.max(outlier, max);
            }
        }

        return max;
    }
}