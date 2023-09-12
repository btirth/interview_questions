class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int max = 0;
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
            max = Math.max(max, freq[ch-'a']);
        }
        
        int count = 0;
        
        boolean[] uniqueFreq = new boolean[max+1]; 
        for(int i=0; i<26; i++) {
            int tempFreq = freq[i];
            if(uniqueFreq[tempFreq]) {
                while(tempFreq>0 && uniqueFreq[tempFreq]) {
                    tempFreq--;
                    count++;
                }
            } 
            uniqueFreq[tempFreq] = true;
            
        }
        
        return count;
    }
}