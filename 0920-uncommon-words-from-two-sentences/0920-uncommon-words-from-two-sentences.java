class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> freq = new HashMap<>();
        for(String word: s1.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for(String word: s2.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<String> uniqueWords = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: freq.entrySet()) {
            if(entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }

        String[] ans = new String[uniqueWords.size()];
        int idx = 0;
        for(String word: uniqueWords) {
            ans[idx] = word;
            idx++;
        }

        return ans;
    }
}