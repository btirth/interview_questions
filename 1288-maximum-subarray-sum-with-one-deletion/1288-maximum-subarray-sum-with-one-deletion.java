class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxSum = arr[0];
        int prefixSum = 0;

        for(int i=0; i<n; i++) {
            if(prefixSum < 0) {
                prefixSum = 0;
            }
            prefixSum += arr[i];
            left[i] = prefixSum;
            maxSum = Math.max(maxSum, arr[i]);
        }

        prefixSum = 0;
        for(int i=n-1; i>=0; i--) {
            if(prefixSum < 0) {
                prefixSum = 0;
            }
            prefixSum += arr[i];
            right[i] = prefixSum;
        }

        
        for(int i=0; i<n; i++) {
            int sum = 0;

            if(i > 0 && left[i-1] > 0) {
                sum += left[i-1];
            }

            if(i<n-1 && right[i+1] > 0) {
                sum += right[i+1];
            }

            if(arr[i] >= 0) {
                sum += arr[i];
            }

            if((i==0 || left[i-1] < 0) && (i==n-1 || right[i+1] < 0) && arr[i] < 0) {
                sum = Integer.MIN_VALUE;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}