class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> processed = new HashSet<>();

        q.add(beginWord);
        processed.add(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String str = q.poll();
                for(String word: wordList) {
                    if(!processed.contains(word) && isValid(str, word)) {
                        processed.add(word);
                        q.add(word);
                        if(word.equals(endWord)) {
                            return length + 1;
                        }
                    }
                }
            }
            
            length++;
        }

        return 0;
    }

    boolean isValid(String s, String t) {
        boolean foundMismatch = false;

        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(foundMismatch) {
                    return false;
                }

                foundMismatch = true;
            }
        }

        return foundMismatch;
    }
}