class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = Integer.MAX_VALUE;
        int start = 1;
        int end = 0;

        for(int day: bloomDay) {
            end = Math.max(end, day);
        }

        while(start <= end) {
            int day = (start+end)/2;
            if(isPossible(bloomDay, m, k, day)) {
                ans = day;
                end = day-1;
            } else {
                start = day + 1;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int currCnt = 0;
        for(int d: bloomDay) {
            if(d <= day) {
                currCnt++;

                if(currCnt == k) {
                    m--;
                    currCnt = 0;
                }

                if(m == 0) {
                    return true;
                }
            } else {
                currCnt = 0;
            }
        }       

        return false;
    }
}