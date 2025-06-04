class Solution {
    public String answerString(String word, int numFriends) {
    
        int len = word.length();
        if(numFriends == 1) {
            return word;
        }
        
        int r = len - numFriends + 1;
        String ans = "";
        List<Integer> largestCharIdx = new ArrayList<>();
        char largestChar = word.charAt(0);
        for(int i=0; i<len; i++) {
            if(word.charAt(i) == largestChar) {
                largestCharIdx.add(i);
            } else if(word.charAt(i) > largestChar) {
                largestCharIdx = new ArrayList<>();
                largestChar = word.charAt(i);
                largestCharIdx.add(i);
            }
        }

        for(Integer startIdx: largestCharIdx) {
            
                String sub = word.substring(startIdx, Math.min(len, startIdx+r));
                
                if(sub.compareTo(ans) > 0) {
                    ans = sub;
                }
            
        }

        return ans;
    }
}