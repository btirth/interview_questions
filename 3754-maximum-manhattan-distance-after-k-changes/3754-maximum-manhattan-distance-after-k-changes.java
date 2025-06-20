class Solution {
    public int maxDistance(String str, int k) {
        /**
        can we say position is like x and y

        ans = |x| + |y|

        so if we count no. of N, W, S, E
        
        now our task is to max |N - S| + |W - E|
        we'll also have to divide K.

        Can we say whatever is ans we can add K in that
        ans = |N - S| + |W - E| + K

        or

        ans = Max(N, S) + Max(W, E) + Min(min(s,n) + min(w,e), k)
         */

        int n = 0;
        int s = 0;
        int w = 0;
        int e = 0;  
        int ans = 0;

        for(char ch: str.toCharArray()) {
            if(ch == 'N') {
                n++;
            } else if(ch == 'S') {
                s++;
            } else if(ch == 'W') {
                w++;
            } else if(ch == 'E') {
                e++;
            }

            ans = Math.max(ans, Math.abs(n - s) + Math.abs(w - e) + 2 * (Math.min(Math.min(n,s) + Math.min(w,e), k)));
        } 

        return ans;
    }
}