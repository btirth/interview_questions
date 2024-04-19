class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return;
        }

        int len = nums1.length;
        int i1 = len-1; // nums1's index
        int i2 = 0; // nums2's index
        int idx = 0; // result arrays' index
        // shift values in nums1 to end.
        for(int i=m-1; i>=0; i--) {
            nums1[i1--] = nums1[i];
        }
        i1++;

        // start filling nums1 based on sorted value. 
        while(idx < len) {
            if(i1 == len) {
                nums1[idx++] = nums2[i2++];
            } else if(i2 == n) {
                nums1[idx++] = nums1[i1++];
            } else if(nums1[i1] <= nums2[i2]) {
                nums1[idx++] = nums1[i1++];
            } else {
                nums1[idx++] = nums2[i2++];
            }
        }
    }
}