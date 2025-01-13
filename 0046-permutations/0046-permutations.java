class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /**
        [1,2,3]
        [2,1,3]
        [3,2,1]

        [1,3,2]
        [2,3,1]
        [3,1,2]

         */
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> firstList = new ArrayList<>();
        for(int num: nums) {
            firstList.add(num);
        }
        ans.add(firstList);
        for(int i=0; i<n; i++) {
            List<List<Integer>> newAns = new ArrayList<>(); 
            for(int j=i+1; j<n; j++) {
                for(List<Integer> list: ans) {
                    List<Integer> newList = new ArrayList<>(list);
                    int temp1 = newList.get(i);
                    int temp2 = newList.get(j);

                    newList.set(i, temp2);
                    newList.set(j, temp1);

                    newAns.add(newList);
                }
            }

            ans.addAll(newAns);
        }

        return ans;
    }
}