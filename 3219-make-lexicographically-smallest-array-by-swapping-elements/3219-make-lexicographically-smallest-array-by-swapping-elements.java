class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] newNum = nums.clone();

        Arrays.sort(newNum);
        int n = nums.length;
        HashMap<Integer, Integer> numQueMap = new HashMap<>();
        List<Queue<Integer>> qList = new ArrayList<>();
        Queue<Integer> currQ = new LinkedList<>();
        currQ.add(newNum[0]);
        numQueMap.put(newNum[0], 0);
        int qIdx = 0;
        for(int i=1; i<n; i++) {
            if(newNum[i] - newNum[i-1] > limit) {
                qList.add(new LinkedList<>(currQ));
                currQ = new LinkedList<>();
                qIdx++;
            }

            currQ.add(newNum[i]);
            numQueMap.put(newNum[i], qIdx);
        }

        qList.add(new LinkedList<>(currQ));


        for(int i=0; i<n; i++) {
            int currQIdx = numQueMap.get(nums[i]);
            Queue<Integer> curr = qList.get(currQIdx);
            nums[i] = curr.poll();
        }

        return nums;
    }
}