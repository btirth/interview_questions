class Solution {
    public int getWinner(int[] arr, int k) {
        int count = 0;
        int prevWinner = -1;
        List<Integer> nums = new ArrayList<>();
        for(int num: arr) {
            nums.add(num);
        }

        k = Math.min(k, arr.length);
        while(count != k) {
            int v1 = nums.get(0);
            int v2 = nums.get(1);

            int winner = Math.max(v1, v2);
            int looser = winner == v1 ? v2 : v1;
            nums.remove(new Integer(looser));
            nums.add(looser);
            if(winner == prevWinner) {
                count++;
            } else {
                count = 1;
                prevWinner = winner;
            }
        }

        return prevWinner;
    }
}