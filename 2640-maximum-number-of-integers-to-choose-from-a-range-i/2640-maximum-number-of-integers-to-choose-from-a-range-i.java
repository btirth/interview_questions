class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        int sum = 0;
        int len = banned.length;
        int idx = 0;
        Arrays.sort(banned);

        for(int i=1; i<=n; i++) {
            while(idx < len && banned[idx] < i) {
                idx++;
            }

            if((idx == len || banned[idx] != i) && sum + i < maxSum) {
                sum += i;
                count++;
            }
        }

        return count;
    }
}