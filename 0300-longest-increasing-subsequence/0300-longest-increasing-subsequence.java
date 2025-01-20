class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int lis = 1;

        for(int num: nums) {
            if(num > list.get(list.size() - 1)) {
                list.add(num);
                lis++;
            } else {
                int idx = Collections.binarySearch(list, num);

                if(idx < 0) {
                    idx = -idx-1;
                    list.set(idx, num);
                }

                
            }
        }

        return lis;
    }
}