class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        List<Integer> prev = triangle.get(size - 1);

        for(int i=size-2; i>=0; i--) {
            List<Integer> curr = triangle.get(i);

            for(int j=0; j<curr.size(); j++) {
                curr.set(j, curr.get(j) + Math.min(prev.get(j), prev.get(j + 1)));
            }

            prev = curr;
        }

        return prev.get(0);
    }
}