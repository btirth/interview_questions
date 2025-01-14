class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        boolean[] presentA = new boolean[n + 1];
        boolean[] presentB = new boolean[n + 1];
        ans[0] = A[0] == B[0] ? 1 : 0;
        presentA[A[0]] = true;
        presentB[B[0]] = true;
        
        for(int i=1; i<n; i++) {
            presentA[A[i]] = true;
            presentB[B[i]] = true;
            ans[i] = ans[i-1];
            if(A[i] == B[i]) {
                ans[i]++;
            } else {
                if(presentA[B[i]]) {
                    ans[i]++;
                }

                if(presentB[A[i]]) {
                    ans[i]++;
                }
            }
        }

        return ans;
    }
}