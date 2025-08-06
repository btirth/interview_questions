class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /**
        I can move from word1 to word2 if
        -> They differs by a single letter

        beginWord not required in the wordList
        endWord needs to be in the wordList

        Find beginWord -> W1 -> W2 -> ... -> endWord

        max word length = 10
        wordList length = 5000

        if I visit a word again, I don't want to visit again, because I am looking for shortest trans.
        visited = []

        We can use Queue, for each iteration over Queue we'll increase the lenght.

        We'll have to create a map, so that we can map each word with possible next word (They differ by single letter)
        
        // if n = length of wordList, O(n^2)
        mapWord(beginWord, wordList) {
            Map<String, List<String>> map -> Key = word and values = words with a single letter diff

            for word in wordList:
                List<String> singleLetterDiff

                for nextWord in wordList:
                    if differBySingleLetter(word, nextWord):
                        singleLetterDiff.add(nextWord)

                map.put(word, singleLetterDiff) 
        }


        Queue q
        q.add(beginWord)

        while(q not empty) {
            int size = q.size();

            while(size-- > 0) {
                String word = q.poll();
                if(word === endWOrd) {
                    return sequence;
                }
            }

            sequence++;
        }

        return 0;


        O(n^2) -> to build map
        TC - O(n)
        SC - O(n)

         */

        wordList.add(beginWord);
        HashMap<String, List<String>> map = buildMap(wordList);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int seq = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                String word = q.poll();

                // We found the endword so return sequence length
                if(word.equals(endWord)) {
                    return seq + 1;
                } 

                if(map.containsKey(word)) {
                    q.addAll(map.get(word));  
                    map.remove(word);
                }
            }

            seq++;
        } 

        return 0;
    }

    HashMap<String, List<String>> buildMap(List<String> words) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word: words) {
            List<String> singleLetterDiff = new ArrayList<>();

            for(String nextWord: words) {
                if(differBySingleLetter(word, nextWord)) {
                    singleLetterDiff.add(nextWord);
                }
            }

            map.put(word, singleLetterDiff);
        }

        return map;
    }
    
    boolean differBySingleLetter(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        boolean found = false;
        for(int i=0; i<word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                if(found) {
                    return false;
                }

                found = true;
            }
        }

        return found;
    }

}