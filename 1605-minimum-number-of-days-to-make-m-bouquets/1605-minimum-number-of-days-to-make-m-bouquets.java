class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1;
        int right = 0;

        for(int b: bloomDay) {
            right = Math.max(right, b);
        }

        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int count = 0;

        for(int b: bloomDay) {
            if(b <= day) {
                count++;
            } else {
                count = 0;
            }

            if(count == k) {
                m--;
                count = 0;
            }

            if(m == 0) {
                return true;
            }
        }

        return false;
    }
}