class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        ans.add(new ArrayList<>());
        for(int i=0; i<n; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            int num = nums[i];
            for(List<Integer> l: ans) {
                for(int j=0; j<=l.size(); j++) {
                    l.add(j, num);
                    if(!temp.contains(l))
                    temp.add(new ArrayList<>(l));
                    l.remove(j);
                }
            }
            ans = temp;
        }


        return ans;
    }
}