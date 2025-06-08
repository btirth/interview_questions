class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1; i<10; i++) {
            helper(n, i);
        }
        return res;
    }

    boolean helper(int n, int curr) {
        if(curr > n) {
            return false;
        }

        res.add(curr);
        for(int i=0; i<10; i++) {
            if(!helper(n, (curr*10) + i)) {
                break;
            }
        }

        return true;
    }
}