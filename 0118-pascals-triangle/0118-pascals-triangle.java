class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        curr.add(1);
        res.add(curr);

        for(int i=1; i<numRows; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);

            for(int idx=0; idx<curr.size() - 1; idx++) {
                int num1 = curr.get(idx);
                int num2 = curr.get(idx + 1);

                next.add(num1 + num2);
            }

            next.add(1);
            res.add(next);
            curr = next;
        }


        return res;

    }
}