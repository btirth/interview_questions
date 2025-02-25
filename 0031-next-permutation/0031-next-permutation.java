class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;

        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        if(breakPoint == -1) {
            Arrays.sort(nums);
            return;
        }

        // Find smalles number on right of breakPoint but greater than nums[breakPoint]

        int smallesNumberIdx = breakPoint+1;
        for(int i=breakPoint + 1; i<n; i++) {
            if(nums[i] > nums[breakPoint] && nums[i] < nums[smallesNumberIdx]) {
                smallesNumberIdx = i;
            }
        }

        // Swap
        int temp = nums[breakPoint];
        nums[breakPoint] = nums[smallesNumberIdx];
        nums[smallesNumberIdx] = temp;

        // Sort on Right
        List<Integer> sorted = new ArrayList<>();
        for(int i=breakPoint + 1; i<n; i++) {
            sorted.add(nums[i]);
        }
        Collections.sort(sorted);
        for(int i=breakPoint + 1; i<n; i++) {
            nums[i] = sorted.get(i - breakPoint -1);
        }
    }
}