class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        int count = boxes.charAt(0) == '1' ? 1 : 0;
        for(int i=1; i<n; i++) {
            left[i] = left[i - 1] + count;
            count += boxes.charAt(i) == '1' ? 1 : 0;            
        }

        count = boxes.charAt(n - 1) == '1' ? 1 : 0;
        for(int i = n-2; i>=0; i--) {
            right[i] = right[i + 1] + count;
            count += boxes.charAt(i) == '1' ? 1 : 0;
        }

        ans[0] = right[0];
        ans[n-1] = left[n-1];
        
        for(int i=1; i<n-1; i++) {
            ans[i] = left[i] + right[i];
        }

        return ans;
    }
}