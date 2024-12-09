class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /**
            nums = [1,2,3]
            [1,2,3]
            [2,1,3]
            [3,2,1]

            [1,3,2]
            [2,3,1]
            [3,1,2]

         */
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int num: nums) {
            curr.add(num);
        }
        ans.add(new ArrayList<>(curr));

        for(int i=0; i<nums.length; i++) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for(int j=i+1; j<nums.length; j++) {
                for(List<Integer> subset: ans) {
                    int temp = subset.get(i);
                    subset.set(i, subset.get(j));
                    subset.set(j, temp);

                    newSubsets.add(new ArrayList<>(subset));

                    temp = subset.get(i);
                    subset.set(i, subset.get(j));
                    subset.set(j, temp);
                }
            }

            ans.addAll(newSubsets);
        }

        return ans;
    }
}