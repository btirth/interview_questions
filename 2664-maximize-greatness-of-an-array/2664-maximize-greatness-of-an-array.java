class Solution {
    public int maximizeGreatness(int[] nums) {
        /**
        greatness = the number of idx for which perm[i] > nums[i]
        can I say create another sorted array

        for each ele in nums 
            get the bigger ele than it from sorted array
        and put remaining values anywhere in the index
        
        We don't need perm, we only care about the count

        [1,1,1,2,3,3,5]
        currCount = 0
        greaterCount = 0

        for i in (len-1, 0):
            if nums[i] == nums[i+1]:
                currCount++
            else:
                greaterCount += currCount
                currCount = 1

            if greaterCount > 0:
                count++
                greaterCount--    

         */

        Arrays.sort(nums);
        int res = 0;
        int curr = 1;
        int greater = 0;
        int len = nums.length;
        for(int i=len-2; i>=0; i--) {
            if(nums[i] == nums[i + 1]) {
                curr++;
            } else {
                greater += curr;
                curr = 1;
            }

            if(greater > 0) {
                res++;
                greater--;
            }
        } 

        return res;
    }
}