class Solution {
    public int maximizeGreatness(int[] nums) {
        /**
        [1,3,5,2,1,3,1]

        for i in idx:
            find immediate bigger element
            reduce its freq
            count++

        TreeSet -> ceil -> TC O(log n) for in/out

        We can also use PriorityQueue with Array sort -> yeah that's better approach but how would you handle index? TreeSet is go for or TreeMap best
         */

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++) {
            Map.Entry<Integer, Integer> num = freq.higherEntry(nums[i]);
            if(num != null) {
                if(num.getValue() == 1) {
                    freq.remove(num.getKey());
                } else {
                    freq.put(num.getKey(), num.getValue() - 1);
                }
                
                count++;
            }
        }
        
        return count;
    }
}