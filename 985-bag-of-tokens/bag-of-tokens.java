class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int score = 0;
        int l = 0;
        int r = n-1;
        int maxScore = 0;
        while(l<=r) {
            if(tokens[l] <= power) {
                power -= tokens[l];
                score++;
                l++;
            } else if(score>0){
                power += tokens[r];
                score--;
                r--;
            } else {
                break;
            }

            maxScore = Math.max(maxScore, score);
        }


        return maxScore;
    }
}