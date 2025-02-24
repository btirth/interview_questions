class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        /**
        [1,2,3,10,4,2,3,5]

        remove from left
            go from (end, 0) until nums[i] >= nums[i-1] // right point
        remove from right and middle
            go from (start, end) until nums[i] <= nums[i+1] // left pointer
                if(nums[left] > nums[right])
                    right++;
        ans = 7
        right = 7
        right = 5
        ans = 5
        [0,1,2,3,4,5,6,7]
        [1,2,3,10,4,2,3,5]

        left = 0, 1, 2
        while(left < 5) {
            if left = 2, arr[2] > arr[right] // 3 > 2 [1,2,3,2,3,5] Not possible
                so right++; right = 6 [1,2,3,3,5] ans = right - left + 1 // 6 - 2 - 1
        }
         */

        int n = arr.length;
        int ans = arr.length - 1;

        int right = n-1;

        while(right > 0 && arr[right] >= arr[right-1]) {
            right--;
        }

        ans = Math.min(ans, right);
        int left = 0;

        while(left < right) {
            if(left != 0 && arr[left] < arr[left-1]) {
                break;
            }
            while(right < n && arr[right] < arr[left]) {
                right++;
            }

            ans = Math.min(ans, right - left - 1);

            left++;
        }

        return ans;
    }
}