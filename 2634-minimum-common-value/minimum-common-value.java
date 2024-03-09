class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;

        while(idx1 < len1 && idx2 < len2) {
            if(nums1[idx1] == nums2[idx2]) {
                return nums1[idx1];
            }

            if(nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return -1;
    }
}