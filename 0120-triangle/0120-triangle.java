class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] prev = {0};
        int ans = Integer.MAX_VALUE;
        for(List<Integer> list: triangle) {
            ans = Integer.MAX_VALUE;
            int[] curr = new int[list.size()];
        
            for(int i=0; i<list.size(); i++) {
                int min;
                if(i == 0) {
                    min = prev[i];
                } else if(i == list.size()-1) {
                    min = prev[i-1];
                } else {
                    min = Math.min(prev[i], prev[i-1]);
                }
                int val = list.get(i) + min;
                ans = Math.min(ans, val);
                curr[i] = val;
            }

            prev = curr;
        }

        return ans;
    }
}