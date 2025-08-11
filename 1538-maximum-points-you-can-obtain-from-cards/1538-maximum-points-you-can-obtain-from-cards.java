class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int score = 0;
        int length = cardPoints.length;
        int left = 0;
        int right = length - 1;

        for(int i=0; i<k; i++) {
            score += cardPoints[right];
            right--;
        }

        right++;
        maxScore = score;

        while(left <= right && left < k) {
            score = score - cardPoints[right] + cardPoints[left];
            right++;
            left++;

            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}