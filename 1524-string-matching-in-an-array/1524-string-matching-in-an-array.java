class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> substrings = new HashSet<>();
        Arrays.sort(words, (a,b) -> Integer.compare(b.length(), a.length()));
        for(String word: words) {
            if(substrings.contains(word)) {
                ans.add(word);
                continue;
            }

            for(int i=0; i<word.length(); i++) {
                for(int j=i; j<word.length(); j++) {
                    substrings.add(word.substring(i, j+1));
                }
            }
        }

        return ans;
    }
}