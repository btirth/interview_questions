class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int l1 = nums1.length;
        int l2 = nums2.length; 

        while(i<l1 && j<l2) {
            if(nums1[i] == nums2[j]) {
                set.add(nums1[i]); 
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] ans = new int[set.size()];
        int idx = 0;
        for(Integer num: set) {
            ans[idx++] = num;
        }

        return ans;
    }
}