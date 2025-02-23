class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int len = 0;
        visited.add(beginWord);
        q.add(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                String word = q.poll();

                if(word.equals(endWord)) {
                    return len + 1;
                }

                for(String next: wordList) {
                    if(visited.contains(next)) {
                        continue;
                    }

                    if(isPossible(word, next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }
            }

            len++;
        }

        return 0;
    }

    boolean isPossible(String s1, String s2) {
        boolean foundFirstDiffer = false;

        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                continue;
            }

            if(foundFirstDiffer) {
                return false;
            }

            foundFirstDiffer = true;
        }

        return foundFirstDiffer;
    }
}