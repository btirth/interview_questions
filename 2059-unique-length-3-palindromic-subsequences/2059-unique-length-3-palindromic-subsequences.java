class Solution {
    public int countPalindromicSubsequence(String s) {
        /**
        s = "aabca"
        "" -> a, a, b, c, a
        a -> aa, ab, ac, aa
        
        We need to find palindromic substring of length 3
        that means we only care about 1st and last char and idx diff b/w them should be >1

        After careful observation we can say that we only care about first and last occurence
         */

        HashMap<Character, Integer> firstOccur = new HashMap<>();
        int n = s.length();

        for(int i=0; i<n; i++) {
            if(!firstOccur.containsKey(s.charAt(i))) {
                firstOccur.put(s.charAt(i), i);
            }
        }

        int count = 0;
        for(int i=n-1; i>=0; i--) {
            if(!firstOccur.containsKey(s.charAt(i))) {
                continue;
            }

            int firstOccurance = firstOccur.get(s.charAt(i));
            firstOccur.remove(s.charAt(i));
            if(i - firstOccurance > 1) {
                count += findUniqueCharBetween(s, firstOccurance, i);
            }
        } 

        return count;
    }

    int findUniqueCharBetween(String s, int start, int end) {
        boolean[] visited = new boolean[26];
        int count = 0;
        for(int i=start + 1; i<end; i++) {
            if(!visited[s.charAt(i) - 'a']) {
                visited[s.charAt(i) - 'a'] = true;
                count++;
            }
        }

        return count;
    }
}