class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = arr[0]/arr[n-1];
        double high = 1;

        while(low < high) {
            double mid = (high + low)/2;
            int[] pairs = helper(arr, mid);
            if(pairs[0] < k) {
                low = mid;
            } else if(pairs[0] > k) {
                high = mid;
            } else {
                return new int[]{pairs[1], pairs[2]};
            }
        }

        return null;
    }

    int[] helper(int[] arr, double target) {
        int count = 0;
        int i = 0;
        int n = arr.length;
        int num = arr[0];
        int den = arr[n-1];

        for(int j=1; j<n; j++) {
            while(arr[i] <= arr[j]*target) {
                i++;
            }

            count += i;
            if(i>0 && arr[i-1]*den > arr[j]*num) {
                num = arr[i-1];
                den = arr[j];
            }
        }

        return new int[]{count, num, den};
    }
}