class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int i = 0;

        while(i<n-2) {
            int left = i + 1;
            int right = n-1;
            /**
            nums[i] + nums[left] + nums[right] = 0
            nums[left] + nums[right] = -nums[i];
             */

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[left]);
                    triplets.add(nums[right]);
                    ans.add(triplets);

                    left++;
                    while(left<right && nums[left] == nums[left-1]) {
                        left++;
                    }

                    right--;
                    while(left<right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if(sum < 0) {
                    left++;
                    while(left<right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else {
                    right--;
                    while(left<right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
            }

            i++;
            while(i<n-2 && nums[i] == nums[i-1]) {
                i++;
            }
        }

        return ans;
    }
}