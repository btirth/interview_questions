class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        ans[0] = A[0] == B[0] ? 1 : 0;
        A[A[0] - 1] *= -1;
        B[B[0] - 1] *= -1;
        
        for(int i=1; i<n; i++) {
            int a = Math.abs(A[i]) - 1;
            int b = Math.abs(B[i]) - 1;
            A[a] *= -1;
            B[b] *= -1;
            ans[i] = ans[i-1];
            if(a == b) {
                ans[i]++;
            } else {
                if(A[b] < 0) {
                    ans[i]++;
                }

                if(B[a] < 0) {
                    ans[i]++;
                }
            }
        }

        return ans;
    }
}