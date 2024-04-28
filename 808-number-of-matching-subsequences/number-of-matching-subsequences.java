class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] map = new ArrayList[26];
        // to reduce duplicate words
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for(String word: words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        for(int i=0; i<26; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i =0; i<s.length(); i++) {
            map[s.charAt(i)-'a'].add(i);
        }

        int count = 0;
        for(String word: wordsMap.keySet()) {
            int minSIdx = -1;
            boolean isAns = true;

            for(char ch: word.toCharArray()) {
                List<Integer> list = map[ch-'a'];
                boolean found = false;
                for(int idx: list) {
                    if(idx>minSIdx) {
                        minSIdx = idx;
                        found = true;
                        break;
                    }
                }

                if(!found) {
                    isAns = false;
                    break;
                }
            }

            if(isAns) {
                count += wordsMap.get(word);
            }
        }

        return count;
    }
}