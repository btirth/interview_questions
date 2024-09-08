class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        long left = 0;
        long right = start[start.length - 1] - start[0] + d;
        long maxScore = 0;
        
        while(left <= right) {
            long mid = (right + left) / 2;
            if(isPossible(start, d, mid)) {
                maxScore = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } 

        return (int)maxScore;
    }

    boolean isPossible(int[] start, int d, long diff) {
        long prev = start[0];
        for(int i=1; i<start.length; i++) {
            long next = Math.max(prev+diff, (long)start[i]); 
            if(next > (long)start[i] + d) {
                return false;
            } 

            prev = next;
        }

        return true;
    }
}