class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lost = new int[100001];
        int[] won = new int[100001];

        for(int[] match: matches) {
            lost[match[1]]++;
            
            won[match[1]] = -1;
            if(won[match[0]] == 0) {
                won[match[0]] = 1;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> loosers = new ArrayList<>();
        List<Integer> winners = new ArrayList<>();

        for(int i=1; i<100001; i++) {
            if(lost[i] == 1) {
                loosers.add(i);
            }

            if(won[i] == 1) {
                winners.add(i);
            }
        }
        

        ans.add(winners);
        ans.add(loosers);
        
        return ans;
    }
}