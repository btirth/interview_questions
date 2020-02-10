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
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i=0,j=0;
        
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                
                set.add(nums2[j]);
                i++;
                j++;
            }
        }
        
        int n = set.size();
        int[] intersectsValue = new int[n];
        int k = 0;
        for(Integer num : set ){
            intersectsValue[k] = num;
            k++;
        }
        
        return intersectsValue;
    }
}