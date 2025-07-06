class FindSumPairs {
    /**
    1000 * 1000 * 
    
     */
    HashMap<Integer, Integer> freq;
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        freq = new HashMap<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int num: nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }    
    }
    
    public void add(int index, int val) {
        int num = nums2[index];
        freq.put(num, freq.get(num) - 1);

        if(freq.get(num) == 0) {
            freq.remove(num);
        }        

        num += val;
        nums2[index] = num;
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int num: nums1) {
            int req = tot - num;
            count += freq.getOrDefault(req, 0);
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */