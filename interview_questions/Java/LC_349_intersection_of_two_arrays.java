/*

Given two arrays, write a function to compute their intersection.

Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]

Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]

Note:
    Each element in the result must be unique.
    The result can be in any order.

*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>  set = new HashSet<>();
        ArrayList<Integer> intersects = new ArrayList<>(); 
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                intersects.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int n = intersects.size();
        int[] intersectsValue = new int[n];
        for(int i=0; i<n; i++){
            intersectsValue[i] = intersects.get(i);
        }
        
        return intersectsValue;
    }
}